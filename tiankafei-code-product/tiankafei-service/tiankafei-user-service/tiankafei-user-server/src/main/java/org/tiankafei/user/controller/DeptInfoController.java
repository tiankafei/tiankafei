package org.tiankafei.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.param.DeptInfoListParam;
import org.tiankafei.user.param.DeptInfoPageParam;
import org.tiankafei.user.service.DeptInfoService;
import org.tiankafei.user.vo.DeptInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

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
public class DeptInfoController extends BaseController {

    @Autowired
    private DeptInfoService deptInfoService;

    /**
     * 校验 系统部门表信息 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统部门表信息 是否已经存在", notes = "校验 系统部门表信息 是否已经存在")
    public ApiResult<Boolean> checkSysDepartmentExists(@Valid @RequestBody DeptInfoListParam deptInfoListParam) throws Exception {
        Boolean flag = deptInfoService.checkSysDepartmentExists(deptInfoListParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统部门表信息 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统部门表信息 对象", notes = "添加 系统部门表信息")
    public ApiResult<String> addSysDepartment(@Valid @RequestBody DeptInfoVo deptInfoVo) throws Exception {
        Object id = deptInfoService.addSysDepartment(deptInfoVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统部门表信息 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 系统部门表信息 对象", notes = "修改 系统部门表信息")
    public ApiResult<Boolean> updateSysDepartment(@Valid @RequestBody DeptInfoVo deptInfoVo) throws Exception {
        boolean flag = deptInfoService.updateSysDepartment(deptInfoVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统部门表信息 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 系统部门表信息 对象", notes = "删除 系统部门表信息")
    public ApiResult<Boolean> deleteSysDepartment(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = deptInfoService.deleteSysDepartment(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统部门表信息 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统部门表信息 对象详情", notes = "获取 系统部门表信息 对象详情")
    public ApiResult<DeptInfoVo> getSysDepartment(@PathVariable("id") String id) throws Exception {
        DeptInfoVo deptInfoVo = deptInfoService.getSysDepartmentById(id);
        return ApiResult.ok(deptInfoVo);
    }

    /**
     * 获取 系统部门表信息 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统部门表信息 分页列表", notes = "获取 系统部门表信息 分页列表")
    public ApiResult<Paging<DeptInfoVo>> getSysDepartmentPageList(@Valid @RequestBody DeptInfoPageParam deptInfoPageParam) throws Exception {
        Paging<DeptInfoVo> paging = deptInfoService.getSysDepartmentPageList(deptInfoPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 获取 系统部门表信息 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统部门表信息 列表", notes = "获取 系统部门表信息 列表")
    public ApiResult<List<DeptInfoVo>> getSysDepartmentList(@Valid @RequestBody DeptInfoListParam deptInfoListParam) throws Exception {
        List<DeptInfoVo> paging = deptInfoService.getSysDepartmentList(deptInfoListParam);
        return ApiResult.ok(paging);
    }

    /**
     * 计算 系统部门表信息 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统部门表信息 总记录数", notes = "计算 系统部门表信息 总记录数")
    public ApiResult<Integer> countSysDepartment(@Valid @RequestBody DeptInfoListParam deptInfoListParam) throws Exception {
        int count = deptInfoService.countSysDepartment(deptInfoListParam);
        return ApiResult.ok(count);
    }

}