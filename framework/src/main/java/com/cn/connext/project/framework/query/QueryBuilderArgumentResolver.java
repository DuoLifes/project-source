package com.cn.connext.project.framework.query;

import com.cn.connext.project.framework.annotation.QueryInfo;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import java.text.MessageFormat;
import java.util.Map;

@Component
@SuppressWarnings("unchecked")
public class QueryBuilderArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(QueryBuilder.class);
    }

    @Override
    public QueryBuilder resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer,
                                        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver = new PageableHandlerMethodArgumentResolver();
        Pageable pageable = pageableHandlerMethodArgumentResolver.resolveArgument(methodParameter, mavContainer, webRequest, binderFactory);

        com.cn.connext.project.framework.query.QueryInfo queryInfo = null;
        QueryInfo searcher = methodParameter.getMethodAnnotation(QueryInfo.class);
        if (searcher != null) {
            Object object = searcher.value().newInstance();
            if (object instanceof com.cn.connext.project.framework.query.QueryInfo) {
                queryInfo = (com.cn.connext.project.framework.query.QueryInfo) object;
            } else {
                throw new Exception(MessageFormat.format("{0} is not implements {1}", searcher.value().getName(), com.cn.connext.project.framework.query.QueryInfo.class.getName()));
            }
        }

        Map<String, String[]> parmMap = webRequest.getParameterMap();

        return new QueryBuilder(queryInfo, pageable, parmMap);
    }


}
