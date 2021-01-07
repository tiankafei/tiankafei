package org.tiankafei.elasticsearch;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 甜咖啡
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticsearchApplication.class})
public class TransportElasticsearchTest {

    private TransportClient client;

    private String indexName = "test_index_transport";

    @Before
    public void before(){
        try {
            Settings setting = Settings.builder().put("cluster.name", "my-application").build();
            client = new PreBuiltTransportClient(setting)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.21.123"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createIndex(){

        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );



    }

    @Test
    public void getIndex(){

    }

    @Test
    public void deleteIndex(){

    }

    @After
    public void after(){
        if(client != null){
            client.close();
        }
    }


}
