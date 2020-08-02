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
import org.tiankafei.user.param.MenuInfoListParam;
import org.tiankafei.user.param.MenuInfoPageParam;
import org.tiankafei.user.service.MenuInfoService;
import org.tiankafei.user.vo.MenuInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统功能菜单信息表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/sysMenuInfo")
@Api(value = "系统功能菜单信息表 API", tags = "系统功能菜单信息表 功能维护")
public class MenuInfoController extends BaseController {

    @Autowired
    private MenuInfoService menuInfoService;

    /**
     * 校验 系统功能菜单信息表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统功能菜单信息表 是否已经存在", notes = "校验 系统功能菜单信息表 是否已经存在")
    public ApiResult<Boolean> checkSysMenuInfoExists(@Valid @RequestBody MenuInfoListParam menuInfoListParam) throws Exception {
        Boolean flag = menuInfoService.checkSysMenuInfoExists(menuInfoListParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统功能菜单信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统功能菜单信息表 对象", notes = "添加 系统功能菜单信息表")
    public ApiResult<String> addSysMenuInfo(@Valid @RequestBody MenuInfoVo menuInfoVo) throws Exception {
        Object id = menuInfoService.addSysMenuInfo(menuInfoVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统功能菜单信息表 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 系统功能菜单信息表 对象", notes = "修改 系统功能菜单信息表")
    public ApiResult<Boolean> updateSysMenuInfo(@Valid @RequestBody MenuInfoVo menuInfoVo) throws Exception {
        boolean flag = menuInfoService.updateSysMenuInfo(menuInfoVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统功能菜单信息表 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 系统功能菜单信息表 对象", notes = "删除 系统功能菜单信息表")
    public ApiResult<Boolean> deleteSysMenuInfo(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = menuInfoService.deleteSysMenuInfo(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统功能菜单信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统功能菜单信息表 对象详情", notes = "获取 系统功能菜单信息表 对象详情")
    public ApiResult<MenuInfoVo> getSysMenuInfo(@PathVariable("id") String id) throws Exception {
        MenuInfoVo menuInfoVo = menuInfoService.getSysMenuInfoById(id);
        return ApiResult.ok(menuInfoVo);
    }

    /**
     * 获取 系统功能菜单信息表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统功能菜单信息表 分页列表", notes = "获取 系统功能菜单信息表 分页列表")
    public ApiResult<Paging<MenuInfoVo>> getSysMenuInfoPageList(@Valid @RequestBody MenuInfoPageParam menuInfoPageParam) throws Exception {
        Paging<MenuInfoVo> paging = menuInfoService.getSysMenuInfoPageList(menuInfoPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 获取 系统功能菜单信息表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统功能菜单信息表 列表", notes = "获取 系统功能菜单信息表 列表")
    public ApiResult<List<MenuInfoVo>> getSysMenuInfoList(@Valid @RequestBody MenuInfoListParam menuInfoListParam) throws Exception {
        List<MenuInfoVo> paging = menuInfoService.getSysMenuInfoList(menuInfoListParam);
        return ApiResult.ok(paging);
    }

    /**
     * 计算 系统功能菜单信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统功能菜单信息表 总记录数", notes = "计算 系统功能菜单信息表 总记录数")
    public ApiResult<Integer> countSysMenuInfo(@Valid @RequestBody MenuInfoListParam menuInfoListParam) throws Exception {
        int count = menuInfoService.countSysMenuInfo(menuInfoListParam);
        return ApiResult.ok(count);
    }

}