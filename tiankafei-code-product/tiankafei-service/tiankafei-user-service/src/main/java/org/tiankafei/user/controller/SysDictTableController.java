package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysDictTableService;
import org.tiankafei.user.param.SysDictTableQueryParam;
import org.tiankafei.user.param.SysDictTablePageQueryParam;
import org.tiankafei.user.vo.SysDictTableQueryVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.tiankafei.web.common.vo.Paging;
import org.tiankafei.web.common.param.IdsParam;

import java.util.List;

/**
 * <pre>
 * 字典的数据表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@RestController
@RequestMapping("/sysDictTable")
@Api(value = "字典的数据表 API", tags = "字典的数据表 功能维护")
public class SysDictTableController extends BaseController {

    @Autowired
    private SysDictTableService sysDictTableService;

    /**
     * 校验 字典的数据表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 字典的数据表 是否已经存在", notes = "校验 字典的数据表 是否已经存在")
    public ApiResult<Boolean> checkSysDictTableExists(@Valid @RequestBody SysDictTableQueryParam sysDictTableQueryParam) throws Exception {
        Boolean flag = sysDictTableService.checkSysDictTableExists(sysDictTableQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 字典的数据表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 字典的数据表 对象", notes = "添加 字典的数据表")
    public ApiResult<String> addSysDictTable(@Valid @RequestBody SysDictTableQueryVo sysDictTableQueryVo) throws Exception {
        Object id = sysDictTableService.saveSysDictTable(sysDictTableQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 字典的数据表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 字典的数据表 对象", notes = "修改 字典的数据表")
    public ApiResult<Boolean> updateSysDictTable(@Valid @RequestBody SysDictTableQueryVo sysDictTableQueryVo) throws Exception {
        boolean flag = sysDictTableService.updateSysDictTable(sysDictTableQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 字典的数据表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 字典的数据表 对象", notes = "删除 字典的数据表")
    public ApiResult<Boolean> deleteSysDictTable(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysDictTableService.deleteSysDictTable(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 字典的数据表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 字典的数据表 对象详情", notes = "获取 字典的数据表 对象详情")
    public ApiResult<SysDictTableQueryVo> getSysDictTable(@PathVariable("id") String id) throws Exception {
         SysDictTableQueryVo sysDictTableQueryVo = sysDictTableService.getSysDictTableById(id);
        return ApiResult.ok(sysDictTableQueryVo);
    }

    /**
     * 获取 字典的数据表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 字典的数据表 分页列表", notes = "获取 字典的数据表 分页列表")
    public ApiResult<Paging<SysDictTableQueryVo>> getSysDictTablePageList(@Valid @RequestBody SysDictTablePageQueryParam sysDictTablePageQueryParam) throws Exception {
         Paging<SysDictTableQueryVo> paging = sysDictTableService.getSysDictTablePageList(sysDictTablePageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 字典的数据表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 字典的数据表 列表", notes = "获取 字典的数据表 列表")
    public ApiResult<List<SysDictTableQueryVo>> getSysDictTableList(@Valid @RequestBody SysDictTableQueryParam sysDictTableQueryParam) throws Exception {
         List<SysDictTableQueryVo> paging = sysDictTableService.getSysDictTableList(sysDictTableQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 字典的数据表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 字典的数据表 总记录数", notes = "计算 字典的数据表 总记录数")
    public ApiResult<Integer> countSysDictTable(@Valid @RequestBody SysDictTableQueryParam sysDictTableQueryParam) throws Exception {
        int count = sysDictTableService.countSysDictTable(sysDictTableQueryParam);
        return ApiResult.ok(count);
    }

}