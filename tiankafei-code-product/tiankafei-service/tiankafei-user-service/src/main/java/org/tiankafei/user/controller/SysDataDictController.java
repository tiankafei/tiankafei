package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysDataDictService;
import org.tiankafei.user.param.SysDataDictQueryParam;
import org.tiankafei.user.param.SysDataDictPageQueryParam;
import org.tiankafei.user.vo.SysDataDictQueryVo;
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
 * 系统数据字典表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Slf4j
@RestController
@RequestMapping("/sysDataDict")
@Api(value = "系统数据字典表 API", tags = "系统数据字典表 功能维护")
public class SysDataDictController extends BaseController {

    @Autowired
    private SysDataDictService sysDataDictService;

    /**
     * 校验 系统数据字典表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典表 是否已经存在", notes = "校验 系统数据字典表 是否已经存在")
    public ApiResult<Boolean> checkSysDataDictExists(@Valid @RequestBody SysDataDictQueryParam sysDataDictQueryParam) throws Exception {
        Boolean flag = sysDataDictService.checkSysDataDictExists(sysDataDictQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统数据字典表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统数据字典表 对象", notes = "添加 系统数据字典表")
    public ApiResult<String> addSysDataDict(@Valid @RequestBody SysDataDictQueryVo sysDataDictQueryVo) throws Exception {
        Object id = sysDataDictService.saveSysDataDict(sysDataDictQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统数据字典表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 系统数据字典表 对象", notes = "修改 系统数据字典表")
    public ApiResult<Boolean> updateSysDataDict(@Valid @RequestBody SysDataDictQueryVo sysDataDictQueryVo) throws Exception {
        boolean flag = sysDataDictService.updateSysDataDict(sysDataDictQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统数据字典表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 系统数据字典表 对象", notes = "删除 系统数据字典表")
    public ApiResult<Boolean> deleteSysDataDict(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysDataDictService.deleteSysDataDict(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统数据字典表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统数据字典表 对象详情", notes = "获取 系统数据字典表 对象详情")
    public ApiResult<SysDataDictQueryVo> getSysDataDict(@PathVariable("id") String id) throws Exception {
         SysDataDictQueryVo sysDataDictQueryVo = sysDataDictService.getSysDataDictById(id);
        return ApiResult.ok(sysDataDictQueryVo);
    }

    /**
     * 获取 系统数据字典表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典表 分页列表", notes = "获取 系统数据字典表 分页列表")
    public ApiResult<Paging<SysDataDictQueryVo>> getSysDataDictPageList(@Valid @RequestBody SysDataDictPageQueryParam sysDataDictPageQueryParam) throws Exception {
         Paging<SysDataDictQueryVo> paging = sysDataDictService.getSysDataDictPageList(sysDataDictPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统数据字典表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典表 列表", notes = "获取 系统数据字典表 列表")
    public ApiResult<List<SysDataDictQueryVo>> getSysDataDictList(@Valid @RequestBody SysDataDictQueryParam sysDataDictQueryParam) throws Exception {
         List<SysDataDictQueryVo> paging = sysDataDictService.getSysDataDictList(sysDataDictQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统数据字典表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统数据字典表 总记录数", notes = "计算 系统数据字典表 总记录数")
    public ApiResult<Integer> countSysDataDict(@Valid @RequestBody SysDataDictQueryParam sysDataDictQueryParam) throws Exception {
        int count = sysDataDictService.countSysDataDict(sysDataDictQueryParam);
        return ApiResult.ok(count);
    }

}