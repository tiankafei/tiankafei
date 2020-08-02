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
import org.tiankafei.user.param.MenuInfoCheckParam;
import org.tiankafei.user.param.MenuInfoCountParam;
import org.tiankafei.user.param.MenuInfoDeleteParam;
import org.tiankafei.user.param.MenuInfoListParam;
import org.tiankafei.user.param.MenuInfoPageParam;
import org.tiankafei.user.service.MenuInfoService;
import org.tiankafei.user.vo.MenuInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统功能菜单信息表 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/user/menu-info-entity")
@Api(value = "系统功能菜单信息表 API", tags = {"系统功能菜单信息表"})
public class MenuInfoController extends BaseController {

    @Autowired
    private MenuInfoService menuInfoService;

    @PostMapping("/check")
    @ApiOperation(value = "校验 系统功能菜单信息表 对象是否存在")
    public ApiResult<Boolean> checkMenuInfoControllerExists(@Valid @RequestBody MenuInfoCheckParam menuInfoCheckParam) throws Exception {
        Boolean flag = menuInfoService.checkMenuInfoServiceExists(menuInfoCheckParam);
        return ApiResult.ok(flag);
    }

    @PostMapping
    @ApiOperation(value = "添加 系统功能菜单信息表")
    public ApiResult<Long> addMenuInfoController(@Valid @RequestBody MenuInfoVo menuInfoVo) throws Exception {
        Long id = menuInfoService.addMenuInfoService(menuInfoVo);
        return ApiResult.ok(id);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统功能菜单信息表")
    public ApiResult<List<Long>> batchAddMenuInfoController(@Valid @RequestBody List<MenuInfoVo> menuInfoVoList) throws Exception {
        List<Long> idList = menuInfoService.batchAddMenuInfoService(menuInfoVoList);
        return ApiResult.ok(idList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统功能菜单信息表")
    public ApiResult<Boolean> deleteMenuInfoController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = menuInfoService.deleteMenuInfoService(id);
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统功能菜单信息表")
    public ApiResult<Boolean> batchDeleteMenuInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = menuInfoService.batchDeleteMenuInfoService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统功能菜单信息表")
    public ApiResult<Boolean> conditionDeleteMenuInfoController(@Valid @RequestBody MenuInfoDeleteParam menuInfoDeleteParam) throws Exception {
        boolean flag = menuInfoService.conditionDeleteMenuInfoService(menuInfoDeleteParam);
        return ApiResult.ok(flag);
    }

    @PatchMapping
    @ApiOperation(value = "更新 系统功能菜单信息表")
    public ApiResult<Boolean> updateMenuInfoController(@Valid @RequestBody MenuInfoVo menuInfoVo) throws Exception {
        boolean flag = menuInfoService.updateMenuInfoService(menuInfoVo);
        return ApiResult.ok(flag);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取 系统功能菜单信息表 对象")
    public ApiResult<MenuInfoVo> getMenuInfoController(@PathVariable(value = "id") String id) throws Exception {
        MenuInfoVo menuInfoVo = menuInfoService.getMenuInfoServiceById(id);
        return ApiResult.ok(menuInfoVo);
    }

    @GetMapping
    @ApiOperation(value = "获取 系统功能菜单信息表 对象全部列表")
    public ApiResult<List<MenuInfoVo>> getMenuInfoControllerAllList() throws Exception {
        List<MenuInfoVo> menuInfoVoList = menuInfoService.getMenuInfoServiceList(null);
        return ApiResult.ok(menuInfoVoList);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取 系统功能菜单信息表 对象列表")
    public ApiResult<List<MenuInfoVo>> getMenuInfoControllerList(@Valid @RequestBody MenuInfoListParam menuInfoListParam) throws Exception {
        List<MenuInfoVo> menuInfoVoList = menuInfoService.getMenuInfoServiceList(menuInfoListParam);
        return ApiResult.ok(menuInfoVoList);
    }

    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统功能菜单信息表 分页对象列表")
    public ApiResult<Paging<MenuInfoVo>> getMenuInfoControllerPageList(@Valid @RequestBody MenuInfoPageParam menuInfoPageParam) throws Exception {
        Paging<MenuInfoVo> menuInfoVoList = menuInfoService.getMenuInfoServicePageList(menuInfoPageParam);
        return ApiResult.ok(menuInfoVoList);
    }

    @PostMapping("/count")
    @ApiOperation(value = "求 系统功能菜单信息表 对象的记录数")
    public ApiResult<Integer> countMenuInfoController(@Valid @RequestBody MenuInfoCountParam menuInfoCountParam) throws Exception {
        Integer count = menuInfoService.countMenuInfoService(menuInfoCountParam);
        return ApiResult.ok(count);
    }


}

