package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysDepartmentService;
import org.tiankafei.user.param.SysDepartmentQueryParam;
import org.tiankafei.user.param.SysDepartmentPageQueryParam;
import org.tiankafei.user.vo.SysDepartmentQueryVo;
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
 * 系统部门表信息 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/sysDepartment")
@Api(value = "系统部门表信息 API", tags = "系统部门表信息 功能维护")
public class SysDepartmentController extends BaseController {

    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * 校验 系统部门表信息 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统部门表信息 是否已经存在", notes = "校验 系统部门表信息 是否已经存在")
    public ApiResult<Boolean> checkSysDepartmentExists(@Valid @RequestBody SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception {
        Boolean flag = sysDepartmentService.checkSysDepartmentExists(sysDepartmentQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统部门表信息 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统部门表信息 对象", notes = "添加 系统部门表信息")
    public ApiResult<String> addSysDepartment(@Valid @RequestBody SysDepartmentQueryVo sysDepartmentQueryVo) throws Exception {
        Object id = sysDepartmentService.addSysDepartment(sysDepartmentQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统部门表信息 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 系统部门表信息 对象", notes = "修改 系统部门表信息")
    public ApiResult<Boolean> updateSysDepartment(@Valid @RequestBody SysDepartmentQueryVo sysDepartmentQueryVo) throws Exception {
        boolean flag = sysDepartmentService.updateSysDepartment(sysDepartmentQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统部门表信息 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 系统部门表信息 对象", notes = "删除 系统部门表信息")
    public ApiResult<Boolean> deleteSysDepartment(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysDepartmentService.deleteSysDepartment(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统部门表信息 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统部门表信息 对象详情", notes = "获取 系统部门表信息 对象详情")
    public ApiResult<SysDepartmentQueryVo> getSysDepartment(@PathVariable("id") String id) throws Exception {
         SysDepartmentQueryVo sysDepartmentQueryVo = sysDepartmentService.getSysDepartmentById(id);
        return ApiResult.ok(sysDepartmentQueryVo);
    }

    /**
     * 获取 系统部门表信息 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统部门表信息 分页列表", notes = "获取 系统部门表信息 分页列表")
    public ApiResult<Paging<SysDepartmentQueryVo>> getSysDepartmentPageList(@Valid @RequestBody SysDepartmentPageQueryParam sysDepartmentPageQueryParam) throws Exception {
         Paging<SysDepartmentQueryVo> paging = sysDepartmentService.getSysDepartmentPageList(sysDepartmentPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统部门表信息 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统部门表信息 列表", notes = "获取 系统部门表信息 列表")
    public ApiResult<List<SysDepartmentQueryVo>> getSysDepartmentList(@Valid @RequestBody SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception {
         List<SysDepartmentQueryVo> paging = sysDepartmentService.getSysDepartmentList(sysDepartmentQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统部门表信息 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统部门表信息 总记录数", notes = "计算 系统部门表信息 总记录数")
    public ApiResult<Integer> countSysDepartment(@Valid @RequestBody SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception {
        int count = sysDepartmentService.countSysDepartment(sysDepartmentQueryParam);
        return ApiResult.ok(count);
    }

}