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
import org.tiankafei.user.param.LinksInfoListParam;
import org.tiankafei.user.param.LinksInfoPageParam;
import org.tiankafei.user.service.LinksInfoService;
import org.tiankafei.user.vo.LinksInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统的友情链接 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/sysLinks")
@Api(value = "系统的友情链接 API", tags = "系统的友情链接 功能维护")
public class LinksInfoController extends BaseController {

    @Autowired
    private LinksInfoService linksInfoService;

    /**
     * 校验 系统的友情链接 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的友情链接 是否已经存在", notes = "校验 系统的友情链接 是否已经存在")
    public ApiResult<Boolean> checkSysLinksExists(@Valid @RequestBody LinksInfoListParam linksInfoListParam) throws Exception {
        Boolean flag = linksInfoService.checkSysLinksExists(linksInfoListParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统的友情链接 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统的友情链接 对象", notes = "添加 系统的友情链接")
    public ApiResult<String> addSysLinks(@Valid @RequestBody LinksInfoVo linksInfoVo) throws Exception {
        Object id = linksInfoService.addSysLinks(linksInfoVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统的友情链接 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 系统的友情链接 对象", notes = "修改 系统的友情链接")
    public ApiResult<Boolean> updateSysLinks(@Valid @RequestBody LinksInfoVo linksInfoVo) throws Exception {
        boolean flag = linksInfoService.updateSysLinks(linksInfoVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统的友情链接 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 系统的友情链接 对象", notes = "删除 系统的友情链接")
    public ApiResult<Boolean> deleteSysLinks(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = linksInfoService.deleteSysLinks(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统的友情链接 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统的友情链接 对象详情", notes = "获取 系统的友情链接 对象详情")
    public ApiResult<LinksInfoVo> getSysLinks(@PathVariable("id") String id) throws Exception {
        LinksInfoVo linksInfoVo = linksInfoService.getSysLinksById(id);
        return ApiResult.ok(linksInfoVo);
    }

    /**
     * 获取 系统的友情链接 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的友情链接 分页列表", notes = "获取 系统的友情链接 分页列表")
    public ApiResult<Paging<LinksInfoVo>> getSysLinksPageList(@Valid @RequestBody LinksInfoPageParam linksInfoPageParam) throws Exception {
        Paging<LinksInfoVo> paging = linksInfoService.getSysLinksPageList(linksInfoPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 获取 系统的友情链接 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的友情链接 列表", notes = "获取 系统的友情链接 列表")
    public ApiResult<List<LinksInfoVo>> getSysLinksList(@Valid @RequestBody LinksInfoListParam linksInfoListParam) throws Exception {
        List<LinksInfoVo> paging = linksInfoService.getSysLinksList(linksInfoListParam);
        return ApiResult.ok(paging);
    }

    /**
     * 计算 系统的友情链接 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统的友情链接 总记录数", notes = "计算 系统的友情链接 总记录数")
    public ApiResult<Integer> countSysLinks(@Valid @RequestBody LinksInfoListParam linksInfoListParam) throws Exception {
        int count = linksInfoService.countSysLinks(linksInfoListParam);
        return ApiResult.ok(count);
    }

}