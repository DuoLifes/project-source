package com.cn.connext.project.framework.query;

public interface QueryInfo {
    /**
     * @return 最多允许翻至多少页
     */
    int getMaxPage();


    /**
     * @return 每页最大行数
     */
    int getMaxSize();


    /**
     * @return 允许查询的数据列及操作符定义
     */
    QueryCriteria[] getQueryCriterias();


    /**
     * @return 允许进行排序的列定义
     */
    String[] getAllowSortFields();
}
