package com.cn.connext.project.framework.query;

import org.apache.commons.lang.StringUtils;

public enum QueryOperator {
    GreaterThan("gt"),
    GreaterThanOrEqualTo("ge"),
    LessThan("lt"),
    LessThanOrEqualTo("le"),
    Equal("equal"),
    Like("like"),
    Start("start");

    private String operator;

    QueryOperator(String operator) {
        this.operator = operator;
    }

    public static QueryOperator getOperator(String operator) {
        for (QueryOperator queryOperator : QueryOperator.values()) {
            if (StringUtils.equals(operator.toLowerCase(), queryOperator.getOperator())) {
                return queryOperator;
            }
        }
        return null;
    }

    public static QueryOperator getOperator(String[] operatorInfo) {
        if (operatorInfo.length == 1) {
            return QueryOperator.Equal;
        } else {
            return getOperator(operatorInfo[1]);
        }


    }

    public String getOperator() {
        return operator;
    }
}
