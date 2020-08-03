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
import org.tiankafei.user.param.LinksInfoCheckParam;
import org.tiankafei.user.param.LinksInfoCountParam;
import org.tiankafei.user.param.LinksInfoDeleteParam;
import org.tiankafei.user.param.LinksInfoListParam;
import org.tiankafei.user.param.LinksInfoPageParam;
import org.tiankafei.user.service.LinksInfoService;
import org.tiankafei.user.vo.LinksInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统的友情链接 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/linksInfo")
@Api(value = "系统的友情链接 API", tags = {"系统的友情链接"})
public class LinksInfoController extends BaseController {

    @Autowired
    private LinksInfoService linksInfoService;

    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的友情链接 对象是否存在")
    public ApiResult<Boolean> checkLinksInfoControllerExists(@Valid @RequestBody LinksInfoCheckParam linksInfoCheckParam) throws Exception {
        Boolean flag = linksInfoService.checkLinksInfoServiceExists(linksInfoCheckParam);
        return ApiResult.ok(flag);
    }

    @PostMapping
    @ApiOperation(value = "添加 系统的友情链接")
    public ApiResult<Long> addLinksInfoController(@Valid @RequestBody LinksInfoVo linksInfoVo) throws Exception {
        Long id = linksInfoService.addLinksInfoService(linksInfoVo);
        return ApiResult.ok(id);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统的友情链接")
    public ApiResult<List<Long>> batchAddLinksInfoController(@Valid @RequestBody List<LinksInfoVo> linksInfoVoList) throws Exception {
        List<Long> idList = linksInfoService.batchAddLinksInfoService(linksInfoVoList);
        return ApiResult.ok(idList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统的友情链接")
    public ApiResult<Boolean> deleteLinksInfoController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = linksInfoService.deleteLinksInfoService(id);
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统的友情链接")
    public ApiResult<Boolean> batchDeleteLinksInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = linksInfoService.batchDeleteLinksInfoService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统的友情链接")
    public ApiResult<Boolean> conditionDeleteLinksInfoController(@Valid @RequestBody LinksInfoDeleteParam linksInfoDeleteParam) throws Exception {
        boolean flag = linksInfoService.conditionDeleteLinksInfoService(linksInfoDeleteParam);
        return ApiResult.ok(flag);
    }

    @PatchMapping
    @ApiOperation(value = "更新 系统的友情链接")
    public ApiResult<Boolean> updateLinksInfoController(@Valid @RequestBody LinksInfoVo linksInfoVo) throws Exception {
        boolean flag = linksInfoService.updateLinksInfoService(linksInfoVo);
        return ApiResult.ok(flag);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取 系统的友情链接 对象")
    public ApiResult<LinksInfoVo> getLinksInfoController(@PathVariable(value = "id") String id) throws Exception {
        LinksInfoVo linksInfoVo = linksInfoService.getLinksInfoServiceById(id);
        return ApiResult.ok(linksInfoVo);
    }

    @GetMapping
    @ApiOperation(value = "获取 系统的友情链接 对象全部列表")
    public ApiResult<List<LinksInfoVo>> getLinksInfoControllerAllList() throws Exception {
        List<LinksInfoVo> linksInfoVoList = linksInfoService.getLinksInfoServiceList(new LinksInfoListParam());
        return ApiResult.ok(linksInfoVoList);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的友情链接 对象列表")
    public ApiResult<List<LinksInfoVo>> getLinksInfoControllerList(@Valid @RequestBody LinksInfoListParam linksInfoListParam) throws Exception {
        List<LinksInfoVo> linksInfoVoList = linksInfoService.getLinksInfoServiceList(linksInfoListParam);
        return ApiResult.ok(linksInfoVoList);
    }

    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的友情链接 分页对象列表")
    public ApiResult<Paging<LinksInfoVo>> getLinksInfoControllerPageList(@Valid @RequestBody LinksInfoPageParam linksInfoPageParam) throws Exception {
        Paging<LinksInfoVo> linksInfoVoList = linksInfoService.getLinksInfoServicePageList(linksInfoPageParam);
        return ApiResult.ok(linksInfoVoList);
    }

    @PostMapping("/count")
    @ApiOperation(value = "求 系统的友情链接 对象的记录数")
    public ApiResult<Integer> countLinksInfoController(@Valid @RequestBody LinksInfoCountParam linksInfoCountParam) throws Exception {
        Integer count = linksInfoService.countLinksInfoService(linksInfoCountParam);
        return ApiResult.ok(count);
    }


}

