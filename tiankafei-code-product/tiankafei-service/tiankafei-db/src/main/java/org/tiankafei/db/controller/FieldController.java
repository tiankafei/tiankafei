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
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.db.entity.FieldEntity;
import org.tiankafei.db.param.FieldNameListParam;
import org.tiankafei.db.param.FieldNamePageParam;
import org.tiankafei.db.param.FieldNameParam;
import org.tiankafei.db.service.FieldService;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.vo.Paging;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RestController
@Api(value = "数据库表的字段 API", tags = "数据库表的字段 查询API")
public class FieldController extends BaseController {

    @Autowired
    private FieldService fieldService;

    /**
     * 获取 数据库表
     *
     * @param fieldNameParam
     * @return
     * @throws Exception
     */
    @PostMapping("/fieldEntity")
    @ApiOperation(value = "获取 数据库表的字段 对象", notes = "获取 数据库表的字段")
    @PreAuthorize(hasPermi = "field:info:get")
    @Log(title = "数据库表的字段", businessType = BusinessType.CHECK)
    public ApiResult<FieldEntity> getFieldEntity(@Valid @RequestBody FieldNameParam fieldNameParam) throws Exception {
        FieldEntity fieldEntity = fieldService.getFieldEntity(fieldNameParam);
        return ApiResult.ok(fieldEntity);
    }

    /**
     * 获取 数据库表 分页对象列表
     *
     * @param fieldNamePageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageFieldList")
    @ApiOperation(value = "获取 数据库表的字段集合 分页对象列表", notes = "获取 数据库表的字段集合 分页对象列表")
    @PreAuthorize(hasPermi = "field:info:pageList")
    @Log(title = "数据库表的字段", businessType = BusinessType.PAGE_LIST)
    public ApiResult<Paging<FieldEntity>> getFieldEntityPageList(@Valid @RequestBody FieldNamePageParam fieldNamePageParam) throws Exception {
        Paging<FieldEntity> sysUserLoginPageList = fieldService.getFieldEntityPageList(fieldNamePageParam);
        return ApiResult.ok(sysUserLoginPageList);
    }

    /**
     * 获取 数据库表 对象列表
     *
     * @param fieldNameListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/fieldList")
    @ApiOperation(value = "取 数据库表的字段集合 对象列表", notes = "取 数据库表的字段集合 对象列表")
    @PreAuthorize(hasPermi = "field:info:list")
    @Log(title = "数据库表的字段", businessType = BusinessType.LIST)
    public ApiResult<List<FieldEntity>> getFieldEntityList(@Valid @RequestBody FieldNameListParam fieldNameListParam) throws Exception {
        List<FieldEntity> sysUserLoginList = fieldService.getFieldEntityList(fieldNameListParam);
        return ApiResult.ok(sysUserLoginList);
    }

}
