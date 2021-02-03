package org.tiankafei.db.controller;

import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.db.entity.TableEntity;
import org.tiankafei.db.param.TableNameParam;
import org.tiankafei.db.param.TableNameListParam;
import org.tiankafei.db.param.TableNamePageParam;
import org.tiankafei.db.service.TableService;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.vo.Paging;

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
     *
     * @param tableNameParam
     * @return
     * @throws Exception
     */
    @PostMapping("/tableEntity")
    @ApiOperation(value = "获取 数据库表 对象", notes = "获取 数据库表")
    @PreAuthorize(hasPermi = "table:info:get")
    @Log(title = "数据库表", businessType = BusinessType.INFO)
    public ApiResult<TableEntity> getTableEntity(@Valid @RequestBody TableNameParam tableNameParam) throws Exception {
        TableEntity tableEntity = tableService.getTableEntity(tableNameParam);
        return ApiResult.ok(tableEntity);
    }

    /**
     * 获取 数据库表 分页对象列表
     *
     * @param tableNamePageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageTableList")
    @ApiOperation(value = "获取 数据库表 分页对象列表", notes = "获取 数据库表 分页对象列表")
    @PreAuthorize(hasPermi = "table:info:pageList")
    @Log(title = "数据库表", businessType = BusinessType.PAGE_LIST)
    public ApiResult<Paging<TableEntity>> getTableEntityPageList(@Valid @RequestBody TableNamePageParam tableNamePageParam) throws Exception {
        Paging<TableEntity> sysUserLoginPageList = tableService.getTableEntityPageList(tableNamePageParam);
        return ApiResult.ok(sysUserLoginPageList);
    }

    /**
     * 获取 数据库表 对象列表
     *
     * @param tableNameListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/tableList")
    @ApiOperation(value = "取 数据库表 对象列表", notes = "取 数据库表 对象列表")
    @PreAuthorize(hasPermi = "table:info:list")
    @Log(title = "数据库表", businessType = BusinessType.LIST)
    public ApiResult<List<TableEntity>> getTableEntityList(@Valid @RequestBody TableNameListParam tableNameListParam) throws Exception {
        List<TableEntity> sysUserLoginList = tableService.getTableEntityList(tableNameListParam);
        return ApiResult.ok(sysUserLoginList);
    }

}
