package org.tiankafei.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.param.DeptInfoCheckParam;
import org.tiankafei.user.param.DeptInfoCountParam;
import org.tiankafei.user.param.DeptInfoDeleteParam;
import org.tiankafei.user.param.DeptInfoListParam;
import org.tiankafei.user.param.DeptInfoPageParam;
import org.tiankafei.user.service.DeptInfoService;
import org.tiankafei.user.vo.DeptInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统部门表信息 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/user/dept-info-entity")
@Api(value = "系统部门表信息 API", tags = {"系统部门表信息"})
public class DeptInfoController extends BaseController {

    @Autowired
    private DeptInfoService deptInfoService;

    @PostMapping("/check")
    @ApiOperation(value = "校验 系统部门表信息 对象是否存在")
    public ApiResult<Boolean> checkDeptInfoControllerExists(@Valid @RequestBody DeptInfoCheckParam deptInfoCheckParam) throws Exception {
        Boolean flag = deptInfoService.checkDeptInfoServiceExists(deptInfoCheckParam);
        return ApiResult.ok(flag);
    }

    @PostMapping
    @ApiOperation(value = "添加 系统部门表信息")
    public ApiResult<Long> addDeptInfoController(@Valid @RequestBody DeptInfoVo deptInfoVo) throws Exception {
        Long id = deptInfoService.addDeptInfoService(deptInfoVo);
        return ApiResult.ok(id);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统部门表信息")
    public ApiResult<List<Long>> batchAddDeptInfoController(@Valid @RequestBody List<DeptInfoVo> deptInfoVoList) throws Exception {
        List<Long> idList = deptInfoService.batchAddDeptInfoService(deptInfoVoList);
        return ApiResult.ok(idList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统部门表信息")
    public ApiResult<Boolean> deleteDeptInfoController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = deptInfoService.deleteDeptInfoService(id);
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统部门表信息")
    public ApiResult<Boolean> batchDeleteDeptInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = deptInfoService.batchDeleteDeptInfoService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统部门表信息")
    public ApiResult<Boolean> conditionDeleteDeptInfoController(@Valid @RequestBody DeptInfoDeleteParam deptInfoDeleteParam) throws Exception {
        boolean flag = deptInfoService.conditionDeleteDeptInfoService(deptInfoDeleteParam);
        return ApiResult.ok(flag);
    }

    @PatchMapping
    @ApiOperation(value = "更新 系统部门表信息")
    public ApiResult<Boolean> updateDeptInfoController(@Valid @RequestBody DeptInfoVo deptInfoVo) throws Exception {
        boolean flag = deptInfoService.updateDeptInfoService(deptInfoVo);
        return ApiResult.ok(flag);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取 系统部门表信息 对象")
    public ApiResult<DeptInfoVo> getDeptInfoController(@PathVariable(value = "id") String id) throws Exception {
        DeptInfoVo deptInfoVo = deptInfoService.getDeptInfoServiceById(id);
        return ApiResult.ok(deptInfoVo);
    }

    @GetMapping
    @ApiOperation(value = "获取 系统部门表信息 对象全部列表")
    public ApiResult<List<DeptInfoVo>> getDeptInfoControllerAllList() throws Exception {
        List<DeptInfoVo> deptInfoVoList = deptInfoService.getDeptInfoServiceList(null);
        return ApiResult.ok(deptInfoVoList);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取 系统部门表信息 对象列表")
    public ApiResult<List<DeptInfoVo>> getDeptInfoControllerList(@Valid @RequestBody DeptInfoListParam deptInfoListParam) throws Exception {
        List<DeptInfoVo> deptInfoVoList = deptInfoService.getDeptInfoServiceList(deptInfoListParam);
        return ApiResult.ok(deptInfoVoList);
    }

    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统部门表信息 分页对象列表")
    public ApiResult<Paging<DeptInfoVo>> getDeptInfoControllerPageList(@Valid @RequestBody DeptInfoPageParam deptInfoPageParam) throws Exception {
        Paging<DeptInfoVo> deptInfoVoList = deptInfoService.getDeptInfoServicePageList(deptInfoPageParam);
        return ApiResult.ok(deptInfoVoList);
    }

    @PostMapping("/count")
    @ApiOperation(value = "求 系统部门表信息 对象的记录数")
    public ApiResult<Integer> countDeptInfoController(@Valid @RequestBody DeptInfoCountParam deptInfoCountParam) throws Exception {
        Integer count = deptInfoService.countDeptInfoService(deptInfoCountParam);
        return ApiResult.ok(count);
    }


}

