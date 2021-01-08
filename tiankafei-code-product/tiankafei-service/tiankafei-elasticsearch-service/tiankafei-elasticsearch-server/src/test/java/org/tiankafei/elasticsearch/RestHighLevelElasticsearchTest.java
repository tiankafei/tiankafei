package org.tiankafei.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author 甜咖啡
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticsearchApplication.class})
public class RestHighLevelElasticsearchTest {

    @Autowired
    private ElasticsearchRestClientProperties elasticsearchRestClientProperties;

    private RestHighLevelClient client;

    private String indexName = "test_index_rest_high_level";

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Before
    public void before() {
        List<String> uriList = elasticsearchRestClientProperties.getUris();
        int length = uriList.size();
        HttpHost[] httpHostArray = new HttpHost[length];
        for (int index = 0; index < length; index++) {
            String uri = uriList.get(index);
            String[] hosts = uri.split(":");

            String ip = hosts[0];
            int port = Integer.parseInt(hosts[1]);

            HttpHost http = new HttpHost(ip, port, "http");
            httpHostArray[index] = http;
        }
        client = new RestHighLevelClient(RestClient.builder(httpHostArray));
    }

    @Test
    public void createIndex() {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );
        try {
            CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            boolean flag = createIndexResponse.isAcknowledged();
            if (flag) {
                System.out.println("创建" + indexName + "成功!");
            } else {
                System.out.println("创建" + indexName + "失败!");
            }

            flag = elasticsearchRestTemplate.createIndex(indexName);
            if (flag) {
                System.out.println("创建" + indexName + "成功!");
            } else {
                System.out.println("创建" + indexName + "失败!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getIndex() {
        try {
            GetIndexRequest getIndexRequest = new GetIndexRequest("test_index_*");
            GetIndexResponse getIndexResponse = client.indices().get(getIndexRequest, RequestOptions.DEFAULT);
            List<String> indexList = Arrays.asList(getIndexResponse.getIndices());
            for (String indexName : indexList) {
                System.out.println(indexName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteIndex() {
        try {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
            AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            boolean flag = delete.isAcknowledged();
            if (flag) {
                System.out.println("删除" + indexName + "索引成功！");
            } else {
                System.out.println("删除" + indexName + "索引失败！");
            }

            flag = elasticsearchRestTemplate.deleteIndex(indexName);
            if (flag) {
                System.out.println("删除" + indexName + "索引成功！");
            } else {
                System.out.println("删除" + indexName + "索引失败！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertData() {

    }

    @Test
    public void batchInsertData() {

    }

    @Test
    public void getById() {

    }

    @Test
    public void multiGetById() {

    }

    @Test
    public void updateByQuery() {

    }

    @Test
    public void delById() {

    }

    @After
    public void after() {
        try {
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
