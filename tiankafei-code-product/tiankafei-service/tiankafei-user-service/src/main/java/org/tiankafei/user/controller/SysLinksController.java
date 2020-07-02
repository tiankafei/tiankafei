package org.tiankafei.user.controller;

import org.tiankafei.user.service.SysLinksService;
import org.tiankafei.user.param.SysLinksQueryParam;
import org.tiankafei.user.param.SysLinksPageQueryParam;
import org.tiankafei.user.vo.SysLinksQueryVo;
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
 * 系统的友情链接 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-02
 */
@Slf4j
@RestController
@RequestMapping("/sysLinks")
@Api(value = "系统的友情链接 API", tags = "系统的友情链接 功能维护")
public class SysLinksController extends BaseController {

    @Autowired
    private SysLinksService sysLinksService;

    /**
     * 校验 系统的友情链接 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的友情链接 是否已经存在", notes = "校验 系统的友情链接 是否已经存在")
    public ApiResult<Boolean> checkSysLinksExists(@Valid @RequestBody SysLinksQueryParam sysLinksQueryParam) throws Exception {
        Boolean flag = sysLinksService.checkSysLinksExists(sysLinksQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统的友情链接 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统的友情链接 对象", notes = "添加 系统的友情链接")
    public ApiResult<String> addSysLinks(@Valid @RequestBody SysLinksQueryVo sysLinksQueryVo) throws Exception {
        Object id = sysLinksService.addSysLinks(sysLinksQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统的友情链接 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 系统的友情链接 对象", notes = "修改 系统的友情链接")
    public ApiResult<Boolean> updateSysLinks(@Valid @RequestBody SysLinksQueryVo sysLinksQueryVo) throws Exception {
        boolean flag = sysLinksService.updateSysLinks(sysLinksQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统的友情链接 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 系统的友情链接 对象", notes = "删除 系统的友情链接")
    public ApiResult<Boolean> deleteSysLinks(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = sysLinksService.deleteSysLinks(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统的友情链接 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统的友情链接 对象详情", notes = "获取 系统的友情链接 对象详情")
    public ApiResult<SysLinksQueryVo> getSysLinks(@PathVariable("id") String id) throws Exception {
         SysLinksQueryVo sysLinksQueryVo = sysLinksService.getSysLinksById(id);
        return ApiResult.ok(sysLinksQueryVo);
    }

    /**
     * 获取 系统的友情链接 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的友情链接 分页列表", notes = "获取 系统的友情链接 分页列表")
    public ApiResult<Paging<SysLinksQueryVo>> getSysLinksPageList(@Valid @RequestBody SysLinksPageQueryParam sysLinksPageQueryParam) throws Exception {
         Paging<SysLinksQueryVo> paging = sysLinksService.getSysLinksPageList(sysLinksPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 系统的友情链接 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的友情链接 列表", notes = "获取 系统的友情链接 列表")
    public ApiResult<List<SysLinksQueryVo>> getSysLinksList(@Valid @RequestBody SysLinksQueryParam sysLinksQueryParam) throws Exception {
         List<SysLinksQueryVo> paging = sysLinksService.getSysLinksList(sysLinksQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 系统的友情链接 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统的友情链接 总记录数", notes = "计算 系统的友情链接 总记录数")
    public ApiResult<Integer> countSysLinks(@Valid @RequestBody SysLinksQueryParam sysLinksQueryParam) throws Exception {
        int count = sysLinksService.countSysLinks(sysLinksQueryParam);
        return ApiResult.ok(count);
    }

}