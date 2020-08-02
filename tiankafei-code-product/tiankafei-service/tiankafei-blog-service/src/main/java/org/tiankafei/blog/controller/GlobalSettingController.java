package org.tiankafei.blog.controller;

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
import org.tiankafei.blog.entity.GlobalSettingEntity;
import org.tiankafei.blog.param.GlobalSettingCheckParam;
import org.tiankafei.blog.param.GlobalSettingCountParam;
import org.tiankafei.blog.param.GlobalSettingDeleteParam;
import org.tiankafei.blog.param.GlobalSettingListParam;
import org.tiankafei.blog.param.GlobalSettingPageParam;
import org.tiankafei.blog.service.GlobalSettingService;
import org.tiankafei.blog.vo.GlobalSettingVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统的博客选项设置 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/blog/global-setting-entity")
@Api(value = "系统的博客选项设置 API", tags = {"系统的博客选项设置"})
public class GlobalSettingController extends BaseController {

    @Autowired
    private GlobalSettingService globalSettingService;

    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的博客选项设置 对象是否存在")
    public ApiResult<Boolean> checkGlobalSettingControllerExists(@Valid @RequestBody GlobalSettingCheckParam globalSettingCheckParam) throws Exception {
        Boolean flag = globalSettingService.checkGlobalSettingServiceExists(globalSettingCheckParam);
        return ApiResult.ok(flag);
    }

    @PostMapping
    @ApiOperation(value = "添加 系统的博客选项设置")
    public ApiResult<Object> addGlobalSettingController(@Valid @RequestBody GlobalSettingVo globalSettingVo) throws Exception {
        Object id = globalSettingService.addGlobalSettingService(globalSettingVo);
        return ApiResult.ok(id);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统的博客选项设置")
    public ApiResult<List<Object>> batchAddGlobalSettingController(@Valid @RequestBody List<GlobalSettingVo> globalSettingVoList) throws Exception {
        List<Object> idList = globalSettingService.batchAddGlobalSettingService(globalSettingVoList);
        return ApiResult.ok(idList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统的博客选项设置")
    public ApiResult<Boolean> deleteGlobalSettingController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = globalSettingService.deleteGlobalSettingService(id);
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统的博客选项设置")
    public ApiResult<Boolean> batchDeleteGlobalSettingController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = globalSettingService.batchDeleteGlobalSettingService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统的博客选项设置")
    public ApiResult<Boolean> conditionDeleteGlobalSettingController(@Valid @RequestBody GlobalSettingDeleteParam globalSettingDeleteParam) throws Exception {
        boolean flag = globalSettingService.conditionDeleteGlobalSettingService(globalSettingDeleteParam);
        return ApiResult.ok(flag);
    }

    @PatchMapping
    @ApiOperation(value = "更新 系统的博客选项设置")
    public ApiResult<Boolean> updateGlobalSettingController(@Valid @RequestBody GlobalSettingVo globalSettingVo) throws Exception {
        boolean flag = globalSettingService.updateGlobalSettingService(globalSettingVo);
        return ApiResult.ok(flag);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取 系统的博客选项设置 对象")
    public ApiResult<GlobalSettingVo> getGlobalSettingController(@PathVariable(value = "id") String id) throws Exception {
        GlobalSettingVo globalSettingVo = globalSettingService.getGlobalSettingServiceById(id);
        return ApiResult.ok(globalSettingVo);
    }

    @GetMapping
    @ApiOperation(value = "获取 系统的博客选项设置 对象全部列表")
    public ApiResult<List<GlobalSettingEntity>> getGlobalSettingControllerAllList() throws Exception {
        List<GlobalSettingEntity> globalSettingEntityList = globalSettingService.getGlobalSettingServiceList(null);
        return ApiResult.ok(globalSettingEntityList);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的博客选项设置 对象列表")
    public ApiResult<List<GlobalSettingEntity>> getGlobalSettingControllerList(@Valid @RequestBody GlobalSettingListParam globalSettingListParam) throws Exception {
        List<GlobalSettingEntity> globalSettingEntityList = globalSettingService.getGlobalSettingServiceList(globalSettingListParam);
        return ApiResult.ok(globalSettingEntityList);
    }

    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的博客选项设置 分页对象列表")
    public ApiResult<Paging<GlobalSettingEntity>> getGlobalSettingControllerPageList(@Valid @RequestBody GlobalSettingPageParam globalSettingPageParam) throws Exception {
        Paging<GlobalSettingEntity> globalSettingEntityList = globalSettingService.getGlobalSettingServicePageList(globalSettingPageParam);
        return ApiResult.ok(globalSettingEntityList);
    }

    @PostMapping("/count")
    @ApiOperation(value = "求 系统的博客选项设置 对象的记录数")
    public ApiResult<Integer> countGlobalSettingController(@Valid @RequestBody GlobalSettingCountParam globalSettingCountParam) throws Exception {
        Integer count = globalSettingService.countGlobalSettingService(globalSettingCountParam);
        return ApiResult.ok(count);
    }


}
