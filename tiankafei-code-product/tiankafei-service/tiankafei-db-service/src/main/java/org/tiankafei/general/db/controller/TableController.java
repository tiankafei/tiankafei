package org.tiankafei.general.db.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.general.db.entity.TableEntity;
import org.tiankafei.general.db.param.TableNameEntityQueryParam;
import org.tiankafei.general.db.param.TableNameListQueryParam;
import org.tiankafei.general.db.param.TableNamePageListQueryParam;
import org.tiankafei.general.db.service.TableService;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.vo.Paging;

import javax.validation.Valid;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RestController
@RequestMapping("/table")
@Api(value = "数据库表 API", tags = "数据库表 查询API")
public class TableController extends BaseController {

    @Autowired
    private TableService tableService;

    /**
     * 获取 数据库表
     * @param tableNameEntityQueryParam
     * @return
     * @throws Exception
     */
    @PostMapping("/tableEntity")
    @ApiOperation(value = "获取 数据库表 对象", notes = "获取 数据库表")
    public ApiResult<TableEntity> getTableEntity(@Valid @RequestBody TableNameEntityQueryParam tableNameEntityQueryParam) throws Exception {
        TableEntity tableEntity = tableService.getTableEntity(tableNameEntityQueryParam);
        return ApiResult.ok(tableEntity);
    }

    /**
     * 获取 数据库表 分页对象列表
     *
     * @param tableNamePageListQueryParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageTableList")
    @ApiOperation(value = "获取 数据库表 分页对象列表", notes = "获取 数据库表 分页对象列表")
    public ApiResult<Paging<TableEntity>> getTableEntityPageList(@Valid @RequestBody TableNamePageListQueryParam tableNamePageListQueryParam) throws Exception {
        Paging<TableEntity> tkfUserLoginPageList = tableService.getTableEntityPageList(tableNamePageListQueryParam);
        return ApiResult.ok(tkfUserLoginPageList);
    }

    /**
     * 获取 数据库表 对象列表
     *
     * @param tableNameListQueryParam
     * @return
     * @throws Exception
     */
    @PostMapping("/tableList")
    @ApiOperation(value = "取 数据库表 对象列表", notes = "取 数据库表 对象列表")
    public ApiResult<List<TableEntity>> getTableEntityList(@Valid @RequestBody TableNameListQueryParam tableNameListQueryParam) throws Exception {
        List<TableEntity> tkfUserLoginList = tableService.getTableEntityList(tableNameListQueryParam);
        return ApiResult.ok(tkfUserLoginList);
    }

}
