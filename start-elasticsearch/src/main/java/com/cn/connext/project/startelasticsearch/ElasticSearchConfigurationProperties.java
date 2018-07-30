package com.cn.connext.project.startelasticsearch;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "es")
public class ElasticSearchConfigurationProperties {
    private String cluster_name;
    private String cluster_nodes;

    public String getCluster_name() {
        return cluster_name;
    }

    public void setCluster_name(String cluster_name) {
        this.cluster_name = cluster_name;
    }

    public String getCluster_nodes() {
        return cluster_nodes;
    }

    public void setCluster_nodes(String cluster_nodes) {
        this.cluster_nodes = cluster_nodes;
    }
}
