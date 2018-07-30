package com.cn.connext.project.basic.queryinfo;
import com.cn.connext.project.framework.query.QueryCriteria;
import com.cn.connext.project.framework.query.QueryInfo;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 媒体信息 - 自定义查询定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Component
public class MediaQuery implements QueryInfo {

    /**
     * 静态变量：允许进行排序的字段名称集合
     */
    private final static String[] ALLOW_SORT_FIELDS;

    /**
     * 静态变量：允许进行查询的字段名称及查询条件
     */
    private final static QueryCriteria[] QUERY_CRITERIAS;

    static {
        ALLOW_SORT_FIELDS = new String[]{"updateTime", "createIndex"};

        QUERY_CRITERIAS = new QueryCriteria[]{
                new QueryCriteria("name", String.class, "like"),
                new QueryCriteria("code", String.class, "like"),
                new QueryCriteria("updateTime", Date.class, "equal,like,gt,ge,lt,le"),
                new QueryCriteria("remark", String.class, "equal,like"),
                new QueryCriteria("isInvalid", Boolean.class, "equal,like"),
                new QueryCriteria("createIndex", Integer.class, "equal,ge,gt,le,lt"),
        };
    }

    /**
     * @return 返回分页模式下，最大允许翻至多少页。
     */
    @Override
    public int getMaxPage() {
        return 2000;
    }

    /**
     * @return 返回分页模式下，每页的最大行数。
     */
    @Override
    public int getMaxSize() {
        return 100;
    }

    /**
     * @return 返回允许进行查询的字段名称及查询条件。
     */
    @Override
    public QueryCriteria[] getQueryCriterias() {
        return QUERY_CRITERIAS;
    }

    /**
     * @return 返回允许进行排序的字段名称集合。
     */
    @Override
    public String[] getAllowSortFields() {
        return ALLOW_SORT_FIELDS;
    }

}

