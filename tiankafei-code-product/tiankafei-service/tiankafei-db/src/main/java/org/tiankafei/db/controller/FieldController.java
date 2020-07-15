package org.tiankafei.db.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.db.entity.FieldEntity;
import org.tiankafei.db.param.FieldNameEntityQueryParam;
import org.tiankafei.db.param.FieldNameListQueryParam;
import org.tiankafei.db.param.FieldNamePageListQueryParam;
import org.tiankafei.db.service.FieldService;
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
@Api(value = "数据库表的字段 API", tags = "数据库表的字段 查询API")
public class FieldController extends BaseController {

    @Autowired
    private FieldService fieldService;

    /**
     * 获取 数据库表
     *
     * @param fieldNameEntityQueryParam
     * @return
     * @throws Exception
     */
    @PostMapping("/fieldEntity")
    @ApiOperation(value = "获取 数据库表的字段 对象", notes = "获取 数据库表的字段")
    public ApiResult<FieldEntity> getFieldEntity(@Valid @RequestBody FieldNameEntityQueryParam fieldNameEntityQueryParam) throws Exception {
        FieldEntity fieldEntity = fieldService.getFieldEntity(fieldNameEntityQueryParam);
        return ApiResult.ok(fieldEntity);
    }

    /**
     * 获取 数据库表 分页对象列表
     *
     * @param fieldNamePageListQueryParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageFieldList")
    @ApiOperation(value = "获取 数据库表的字段集合 分页对象列表", notes = "获取 数据库表的字段集合 分页对象列表")
    public ApiResult<Paging<FieldEntity>> getFieldEntityPageList(@Valid @RequestBody FieldNamePageListQueryParam fieldNamePageListQueryParam) throws Exception {
        Paging<FieldEntity> sysUserLoginPageList = fieldService.getFieldEntityPageList(fieldNamePageListQueryParam);
        return ApiResult.ok(sysUserLoginPageList);
    }

    /**
     * 获取 数据库表 对象列表
     *
     * @param fieldNameListQueryParam
     * @return
     * @throws Exception
     */
    @PostMapping("/fieldList")
    @ApiOperation(value = "取 数据库表的字段集合 对象列表", notes = "取 数据库表的字段集合 对象列表")
    public ApiResult<List<FieldEntity>> getFieldEntityList(@Valid @RequestBody FieldNameListQueryParam fieldNameListQueryParam) throws Exception {
        List<FieldEntity> sysUserLoginList = fieldService.getFieldEntityList(fieldNameListQueryParam);
        return ApiResult.ok(sysUserLoginList);
    }

}
