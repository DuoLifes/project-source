package com.cn.connext.project.framework.query;


import com.cn.connext.project.framework.Time;
import com.cn.connext.project.framework.exception.ServiceException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.*;
import java.util.*;


public class QueryBuilder<T> {
    private Pageable pageable;
    private Specification<T> specification;
    private QueryInfo queryInfo;
    private Map<String, String[]> parmMap;


    public QueryBuilder(QueryInfo queryInfo, Pageable pageable, Map<String, String[]> parmMap) {
        initQueryInfo(queryInfo);
        initPageable(queryInfo, pageable);
        initSpecification(queryInfo, parmMap);
    }

    public Pageable getPageable() {
        return pageable;
    }

    public Specification<T> getSpecification() {
        return specification;
    }

    private void initQueryInfo(QueryInfo queryInfo) {
        this.queryInfo = queryInfo;
    }

    private void initPageable(QueryInfo queryInfo, Pageable pageable) {
        this.pageable = pageable;
    }

    private void initSpecification(QueryInfo queryInfo, Map<String, String[]> parmMap) {
        this.parmMap = parmMap;
        this.specification = (root, query, cb) -> {
            if (queryInfo == null) return null;

            List<Predicate> predicates = new ArrayList<Predicate>();
            Arrays.stream(queryInfo.getQueryCriterias()).forEach(criteria -> {
                if (parmMap.containsKey(criteria.field)) {
                    fillPredicates(predicates, criteria, root, query, cb);
                }
            });
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
    }

    private void fillPredicates(List<Predicate> predicates, QueryCriteria criteria, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        String fieldName = criteria.field;
        String[] fieldInfoArray = parmMap.get(fieldName);
        // request请求在多个同名参数时返回一个数组。？code=100,gt&code=200,lt，所以此处进行遍历
        Arrays.stream(fieldInfoArray).forEach(fieldInfo -> {
            String[] fieldCriterias = fieldInfo.split(",");
            String fieldValue = fieldCriterias[0];


            QueryOperator operator = QueryOperator.getOperator(fieldCriterias);

            if (operator == null || criteria.isNotAllow(operator)) {
                throw new ServiceException("global_query_error_operatorNotAllow");
            }

            addPredicate(predicates, criteria, root, cb, fieldName, fieldValue, operator);
        });
    }

    private void addPredicate(List<Predicate> predicates, QueryCriteria criteria, Root<T> root, CriteriaBuilder cb, String fieldName, String fieldValue, QueryOperator operator) {
        String fieldType = criteria.type.getTypeName();
        switch (operator) {
            case Equal:
                addPredicateEqual(predicates, root, cb, fieldName, fieldValue, fieldType);
                break;

            case Like:
                addPredicateLike(predicates, root, cb, fieldName, fieldValue, fieldType);
                break;

            case Start:
                addPredicateStart(predicates, root, cb, fieldName, fieldValue, fieldType);
                break;

            case GreaterThan:
                addPredicateGreaterThan(predicates, root, cb, fieldName, fieldValue, fieldType);
                break;

            case GreaterThanOrEqualTo:
                addPredicateGreaterThanOrEqualTo(predicates, root, cb, fieldName, fieldValue, fieldType);
                break;

            case LessThan:
                addPredicateLessThan(predicates, root, cb, fieldName, fieldValue, fieldType);
                break;

            case LessThanOrEqualTo:
                addPredicateLessThanOrEqualTo(predicates, root, cb, fieldName, fieldValue, fieldType);
                break;
        }
    }

    private void addPredicateEqual(List<Predicate> predicates, Root<T> root, CriteriaBuilder cb, String fieldName, String fieldValue, String fieldType) {
        switch (fieldType) {
            case "java.lang.String":
                Path<String> stringPath = root.get(fieldName);
                predicates.add(cb.equal(stringPath, fieldValue));
                break;

            case "java.util.Date":
            case "java.sql.Date":
                Path<Date> datePath = root.get(fieldName);
                predicates.add(cb.equal(datePath, Time.parseFromString(fieldValue)));
                break;

            case "java.lang.Boolean":
            case "boolean":
                Path<Boolean> booleanPath = root.get(fieldName);
                predicates.add(cb.equal(booleanPath, Boolean.parseBoolean(fieldValue)));
                break;

            case "java.lang.Byte":
            case "byte":
                Path<Byte> bytePath = root.get(fieldName);
                predicates.add(cb.equal(bytePath, Byte.parseByte(fieldValue)));
                break;

            case "java.lang.Short":
            case "short":
                Path<Short> shortPath = root.get(fieldName);
                predicates.add(cb.equal(shortPath, Short.parseShort(fieldValue)));
                break;

            case "java.lang.Integer":
            case "int":
                Path<Integer> intPath = root.get(fieldName);
                predicates.add(cb.equal(intPath, Integer.parseInt(fieldValue)));
                break;

            case "java.lang.Long":
            case "long":
                Path<Long> longPath = root.get(fieldName);
                predicates.add(cb.equal(longPath, Long.parseLong(fieldValue)));
                break;

            case "java.lang.Float":
            case "float":
                Path<Float> floatPath = root.get(fieldName);
                predicates.add(cb.equal(floatPath, Float.parseFloat(fieldValue)));
                break;

            case "java.lang.Double":
            case "double":
                Path<Double> doublePath = root.get(fieldName);
                predicates.add(cb.equal(doublePath, Double.parseDouble(fieldValue)));
                break;
        }
    }

    private void addPredicateLike(List<Predicate> predicates, Root<T> root, CriteriaBuilder cb, String fieldName, String fieldValue, String fieldType) {
        switch (fieldType) {
            case "java.lang.String":
                Path<String> stringPath = root.get(fieldName);
                predicates.add(cb.like(stringPath, "%" + fieldValue + "%"));
                break;

            default:
                throw new RuntimeException("Can not use like operator on " + fieldType + " type field.");
        }
    }

    private void addPredicateStart(List<Predicate> predicates, Root<T> root, CriteriaBuilder cb, String fieldName, String fieldValue, String fieldType) {
        switch (fieldType) {
            case "java.lang.String":
                Path<String> stringPath = root.get(fieldName);
                predicates.add(cb.like(stringPath, fieldValue + "%"));
                break;

            default:
                throw new RuntimeException("Can not use start operator on " + fieldType + " type field.");
        }
    }

    private void addPredicateGreaterThan(List<Predicate> predicates, Root<T> root, CriteriaBuilder cb, String fieldName, String fieldValue, String fieldType) {
        switch (fieldType) {
            case "java.lang.String":
                Path<String> stringPath = root.get(fieldName);
                predicates.add(cb.greaterThan(stringPath, fieldValue));
                break;

            case "java.util.Date":
            case "java.sql.Date":
                Path<Date> datePath = root.get(fieldName);
                predicates.add(cb.greaterThan(datePath, Time.parseFromString(fieldValue)));
                break;

            case "java.lang.Boolean":
            case "boolean":
                Path<Boolean> booleanPath = root.get(fieldName);
                predicates.add(cb.greaterThan(booleanPath, Boolean.parseBoolean(fieldValue)));
                break;

            case "java.lang.Byte":
            case "byte":
                Path<Byte> bytePath = root.get(fieldName);
                predicates.add(cb.greaterThan(bytePath, Byte.parseByte(fieldValue)));
                break;

            case "java.lang.Short":
            case "short":
                Path<Short> shortPath = root.get(fieldName);
                predicates.add(cb.greaterThan(shortPath, Short.parseShort(fieldValue)));
                break;

            case "java.lang.Integer":
            case "int":
                Path<Integer> intPath = root.get(fieldName);
                predicates.add(cb.greaterThan(intPath, Integer.parseInt(fieldValue)));
                break;

            case "java.lang.Long":
            case "long":
                Path<Long> longPath = root.get(fieldName);
                predicates.add(cb.greaterThan(longPath, Long.parseLong(fieldValue)));
                break;

            case "java.lang.Float":
            case "float":
                Path<Float> floatPath = root.get(fieldName);
                predicates.add(cb.greaterThan(floatPath, Float.parseFloat(fieldValue)));
                break;

            case "java.lang.Double":
            case "double":
                Path<Double> doublePath = root.get(fieldName);
                predicates.add(cb.greaterThan(doublePath, Double.parseDouble(fieldValue)));
                break;
        }
    }

    private void addPredicateGreaterThanOrEqualTo(List<Predicate> predicates, Root<T> root, CriteriaBuilder cb, String fieldName, String fieldValue, String fieldType) {
        switch (fieldType) {
            case "java.lang.String":
                Path<String> stringPath = root.get(fieldName);
                predicates.add(cb.greaterThanOrEqualTo(stringPath, fieldValue));
                break;

            case "java.util.Date":
            case "java.sql.Date":
                Path<Date> datePath = root.get(fieldName);
                predicates.add(cb.greaterThanOrEqualTo(datePath, Time.parseFromString(fieldValue)));
                break;

            case "java.lang.Boolean":
            case "boolean":
                Path<Boolean> booleanPath = root.get(fieldName);
                predicates.add(cb.greaterThanOrEqualTo(booleanPath, Boolean.parseBoolean(fieldValue)));
                break;

            case "java.lang.Byte":
            case "byte":
                Path<Byte> bytePath = root.get(fieldName);
                predicates.add(cb.greaterThanOrEqualTo(bytePath, Byte.parseByte(fieldValue)));
                break;

            case "java.lang.Short":
            case "short":
                Path<Short> shortPath = root.get(fieldName);
                predicates.add(cb.greaterThanOrEqualTo(shortPath, Short.parseShort(fieldValue)));
                break;

            case "java.lang.Integer":
            case "int":
                Path<Integer> intPath = root.get(fieldName);
                predicates.add(cb.greaterThanOrEqualTo(intPath, Integer.parseInt(fieldValue)));
                break;

            case "java.lang.Long":
            case "long":
                Path<Long> longPath = root.get(fieldName);
                predicates.add(cb.greaterThanOrEqualTo(longPath, Long.parseLong(fieldValue)));
                break;

            case "java.lang.Float":
            case "float":
                Path<Float> floatPath = root.get(fieldName);
                predicates.add(cb.greaterThanOrEqualTo(floatPath, Float.parseFloat(fieldValue)));
                break;

            case "java.lang.Double":
            case "double":
                Path<Double> doublePath = root.get(fieldName);
                predicates.add(cb.greaterThanOrEqualTo(doublePath, Double.parseDouble(fieldValue)));
                break;
        }
    }

    private void addPredicateLessThan(List<Predicate> predicates, Root<T> root, CriteriaBuilder cb, String fieldName, String fieldValue, String fieldType) {
        switch (fieldType) {
            case "java.lang.String":
                Path<String> stringPath = root.get(fieldName);
                predicates.add(cb.lessThan(stringPath, fieldValue));
                break;

            case "java.util.Date":
            case "java.sql.Date":
                Path<Date> datePath = root.get(fieldName);
                predicates.add(cb.lessThan(datePath, Time.parseFromString(fieldValue)));
                break;

            case "java.lang.Boolean":
            case "boolean":
                Path<Boolean> booleanPath = root.get(fieldName);
                predicates.add(cb.lessThan(booleanPath, Boolean.parseBoolean(fieldValue)));
                break;

            case "java.lang.Byte":
            case "byte":
                Path<Byte> bytePath = root.get(fieldName);
                predicates.add(cb.lessThan(bytePath, Byte.parseByte(fieldValue)));
                break;

            case "java.lang.Short":
            case "short":
                Path<Short> shortPath = root.get(fieldName);
                predicates.add(cb.lessThan(shortPath, Short.parseShort(fieldValue)));
                break;

            case "java.lang.Integer":
            case "int":
                Path<Integer> intPath = root.get(fieldName);
                predicates.add(cb.lessThan(intPath, Integer.parseInt(fieldValue)));
                break;

            case "java.lang.Long":
            case "long":
                Path<Long> longPath = root.get(fieldName);
                predicates.add(cb.lessThan(longPath, Long.parseLong(fieldValue)));
                break;

            case "java.lang.Float":
            case "float":
                Path<Float> floatPath = root.get(fieldName);
                predicates.add(cb.lessThan(floatPath, Float.parseFloat(fieldValue)));
                break;

            case "java.lang.Double":
            case "double":
                Path<Double> doublePath = root.get(fieldName);
                predicates.add(cb.lessThan(doublePath, Double.parseDouble(fieldValue)));
                break;
        }
    }

    private void addPredicateLessThanOrEqualTo(List<Predicate> predicates, Root<T> root, CriteriaBuilder cb, String fieldName, String fieldValue, String fieldType) {
        switch (fieldType) {
            case "java.lang.String":
                Path<String> stringPath = root.get(fieldName);
                predicates.add(cb.lessThanOrEqualTo(stringPath, fieldValue));
                break;

            case "java.util.Date":
            case "java.sql.Date":
                Path<Date> datePath = root.get(fieldName);
                predicates.add(cb.lessThanOrEqualTo(datePath, Time.parseFromString(fieldValue)));
                break;

            case "java.lang.Boolean":
            case "boolean":
                Path<Boolean> booleanPath = root.get(fieldName);
                predicates.add(cb.lessThanOrEqualTo(booleanPath, Boolean.parseBoolean(fieldValue)));
                break;

            case "java.lang.Byte":
            case "byte":
                Path<Byte> bytePath = root.get(fieldName);
                predicates.add(cb.lessThanOrEqualTo(bytePath, Byte.parseByte(fieldValue)));
                break;

            case "java.lang.Short":
            case "short":
                Path<Short> shortPath = root.get(fieldName);
                predicates.add(cb.lessThanOrEqualTo(shortPath, Short.parseShort(fieldValue)));
                break;

            case "java.lang.Integer":
            case "int":
                Path<Integer> intPath = root.get(fieldName);
                predicates.add(cb.lessThanOrEqualTo(intPath, Integer.parseInt(fieldValue)));
                break;

            case "java.lang.Long":
            case "long":
                Path<Long> longPath = root.get(fieldName);
                predicates.add(cb.lessThanOrEqualTo(longPath, Long.parseLong(fieldValue)));
                break;

            case "java.lang.Float":
            case "float":
                Path<Float> floatPath = root.get(fieldName);
                predicates.add(cb.lessThanOrEqualTo(floatPath, Float.parseFloat(fieldValue)));
                break;

            case "java.lang.Double":
            case "double":
                Path<Double> doublePath = root.get(fieldName);
                predicates.add(cb.lessThanOrEqualTo(doublePath, Double.parseDouble(fieldValue)));
                break;
        }
    }
}
