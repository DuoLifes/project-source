package com.cn.connext.project.startelasticsearch;

import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "es")
public class ElasticSearchConfigurationProperties {
    /*系统日志*/
    private final static Logger LOGGER = LoggerFactory.getLogger(ElasticSearchAutoConfiguration.class);


    private String cluster_name;
    private String cluster_nodes;
    public List<TransportAddress> getTransportAddresses() {
        List<TransportAddress> transportAddresses = new ArrayList<>();
        try {
            Arrays.stream(cluster_nodes.split(",")).forEach(address -> {
                String[] hostInfo = address.split(":");
                String hostName = hostInfo[0];
                String hostPort = hostInfo[1];
                InetSocketAddress socketAddress = new InetSocketAddress(hostName, Integer.parseInt(hostPort));
                transportAddresses.add(new InetSocketTransportAddress(socketAddress));
            });
        } catch (Exception e) {
            LOGGER.error("Can not parse cluster nodes: " + cluster_nodes, e);
        }
        return transportAddresses;
    }


    /*get&&set*/
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
