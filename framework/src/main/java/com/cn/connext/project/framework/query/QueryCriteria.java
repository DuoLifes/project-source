package com.cn.connext.project.framework.query;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryCriteria {
    public String field;
    public Type type;
    public List<QueryOperator> operators;

    public QueryCriteria(String field, Type type, String operators) {
        this.field = field;
        this.type = type;

        String[] operatorArray = operators.split(",");
        this.operators = new ArrayList<>();
        Arrays.stream(operatorArray).forEach(operator -> {
            QueryOperator queryOperator = QueryOperator.getOperator(operator);
            if (queryOperator == null) {
                throw new IllegalArgumentException(MessageFormat.format("field {0} queryinfo operator is error", field));
            }
            this.operators.add(queryOperator);
        });
    }

    public boolean isNotAllow(QueryOperator queryOperator) {
        return !operators.contains(queryOperator);
    }
}
