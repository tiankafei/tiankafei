package org.tiankafei.elasticsearch.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tiankafei.elasticsearch.param.IndexParam;
import org.tiankafei.elasticsearch.service.IElasticsearchService;
import com.ruoyi.common.core.web.domain.ApiResult;

import javax.validation.Valid;

/**
 * @author 甜咖啡
 */
@RestController
@RequestMapping("/transport")
@Api(value = "Elasticsearch-Transport操作 API", tags = {"Elasticsearch-Transport操作"})
public class ElasticsearchTransportController {

    @Autowired
    private IElasticsearchService elasticsearchTransportServiceImpl;

    /**
     * 校验 索引 是否已经存在
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    @GetMapping("/checkIndexNameExists/{indexName}")
    @ApiOperation(value = "校验 索引 是否已经存在")
    public ApiResult<Boolean> checkIndexNameExists(@PathVariable String indexName) throws Exception {
        return ApiResult.ok(elasticsearchTransportServiceImpl.checkIndexNameExists(indexName));
    }

    /**
     * 创建 索引
     *
     * @param indexParam
     * @return
     * @throws Exception
     */
    @PostMapping("/createIndex")
    @ApiOperation(value = "创建 索引")
    public ApiResult<Boolean> createIndex(@Valid @RequestBody IndexParam indexParam) throws Exception {
        return ApiResult.ok(elasticsearchTransportServiceImpl.createIndex(indexParam));
    }

    /**
     * 删除 索引
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    @GetMapping("/deleteIndex/{indexName}")
    @ApiOperation(value = "删除 索引")
    public ApiResult<Boolean> deleteIndex(@PathVariable String indexName) throws Exception {
        return ApiResult.ok(elasticsearchTransportServiceImpl.deleteIndex(indexName));
    }

    /**
     * 插入数据
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    @GetMapping("/insertData/{indexName}")
    @ApiOperation(value = "插入 索引数据")
    public ApiResult<Boolean> insertData(@PathVariable String indexName) throws Exception {
        return ApiResult.ok(elasticsearchTransportServiceImpl.insertData(indexName));
    }

}
