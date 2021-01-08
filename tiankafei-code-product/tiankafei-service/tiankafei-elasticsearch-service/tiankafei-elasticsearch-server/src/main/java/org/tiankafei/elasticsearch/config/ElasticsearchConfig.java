package org.tiankafei.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * @author 甜咖啡
 */
@Configuration
public class ElasticsearchConfig {

    @Autowired
    private ElasticsearchProperties elasticsearchProperties;

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        Settings setting = Settings.builder().put("cluster.name", elasticsearchProperties.getClusterName()).build();
        TransportClient client = new PreBuiltTransportClient(setting);

        String clusterNodes = elasticsearchProperties.getClusterNodes();
        List<String> nodeList = Arrays.asList(clusterNodes.split(","));

        for (int index = 0, length = nodeList.size(); index < length; index++) {
            String node = nodeList.get(index);
            String[] hosts = node.split(":");

            String ip = hosts[0];
            Integer port = Integer.valueOf(hosts[1]);
            client.addTransportAddress(new TransportAddress(InetAddress.getByName(ip), port));
        }
        return client;
    }

}
