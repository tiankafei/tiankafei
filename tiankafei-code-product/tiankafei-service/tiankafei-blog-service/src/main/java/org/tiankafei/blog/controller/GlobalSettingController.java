package org.tiankafei.blog.controller;

import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
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
import org.tiankafei.blog.param.GlobalSettingCheckParam;
import org.tiankafei.blog.param.GlobalSettingCountParam;
import org.tiankafei.blog.param.GlobalSettingDeleteParam;
import org.tiankafei.blog.param.GlobalSettingListParam;
import org.tiankafei.blog.param.GlobalSettingPageParam;
import org.tiankafei.blog.service.GlobalSettingService;
import org.tiankafei.blog.vo.GlobalSettingVo;
import com.ruoyi.common.core.web.domain.ApiResult;
import org.tiankafei.web.common.param.IdsParam;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 系统的博客选项设置 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/globalSetting")
@Api(value = "系统的博客选项设置 API", tags = {"系统的博客选项设置"})
public class GlobalSettingController extends BaseController {

    @Autowired
    private GlobalSettingService globalSettingService;

    /**
     * 校验 系统的博客选项设置 是否已经存在
     *
     * @param globalSettingCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的博客选项设置 对象是否存在")
    @PreAuthorize(hasPermi = "sys:global:setting:check")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.CHECK)
    public ApiResult<Boolean> checkGlobalSettingControllerExists(@Valid @RequestBody GlobalSettingCheckParam globalSettingCheckParam) throws Exception {
        Boolean flag = globalSettingService.checkGlobalSettingServiceExists(globalSettingCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 系统的博客选项设置
     *
     * @param globalSettingVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 系统的博客选项设置")
    @PreAuthorize(hasPermi = "sys:global:setting:add")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.INSERT)
    public ApiResult<Long> addGlobalSettingController(@Valid @RequestBody GlobalSettingVo globalSettingVo) throws Exception {
        Long id = globalSettingService.addGlobalSettingService(globalSettingVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 系统的博客选项设置
     *
     * @param globalSettingVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统的博客选项设置")
    @PreAuthorize(hasPermi = "sys:global:setting:batchAdd")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.BATCH_INSERT)
    public ApiResult<List<Long>> batchAddGlobalSettingController(@Valid @RequestBody List<GlobalSettingVo> globalSettingVoList) throws Exception {
        List<Long> idList = globalSettingService.batchAddGlobalSettingService(globalSettingVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 系统的博客选项设置
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统的博客选项设置")
    @PreAuthorize(hasPermi = "sys:global:setting:delete")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.DELETE)
    public ApiResult<Boolean> deleteGlobalSettingController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = globalSettingService.deleteGlobalSettingService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 系统的博客选项设置
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统的博客选项设置")
    @PreAuthorize(hasPermi = "sys:global:setting:batchDelete")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.BATCH_DELETE)
    public ApiResult<Boolean> batchDeleteGlobalSettingController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = globalSettingService.batchDeleteGlobalSettingService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 系统的博客选项设置
     *
     * @param globalSettingDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统的博客选项设置")
    @PreAuthorize(hasPermi = "sys:global:setting:conditionDelete")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.CONDITION_DELETE)
    public ApiResult<Boolean> conditionDeleteGlobalSettingController(@Valid @RequestBody GlobalSettingDeleteParam globalSettingDeleteParam) throws Exception {
        boolean flag = globalSettingService.conditionDeleteGlobalSettingService(globalSettingDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 系统的博客选项设置
     *
     * @param globalSettingVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 系统的博客选项设置")
    @PreAuthorize(hasPermi = "sys:global:setting:update")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.UPDATE)
    public ApiResult<Boolean> updateGlobalSettingController(@Valid @RequestBody GlobalSettingVo globalSettingVo) throws Exception {
        boolean flag = globalSettingService.updateGlobalSettingService(globalSettingVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 系统的博客选项设置 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 系统的博客选项设置 对象")
    @PreAuthorize(hasPermi = "sys:global:setting:info")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.INFO)
    public ApiResult<GlobalSettingVo> getGlobalSettingController(@PathVariable(value = "id") String id) throws Exception {
        GlobalSettingVo globalSettingVo = globalSettingService.getGlobalSettingServiceById(id);
        return ApiResult.ok(globalSettingVo);
    }

    /**
     * 获取 系统的博客选项设置 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 系统的博客选项设置 对象全部列表")
    @PreAuthorize(hasPermi = "sys:global:setting:AllList")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.ALL_LIST)
    public ApiResult<List<GlobalSettingVo>> getGlobalSettingControllerAllList() throws Exception {
        List<GlobalSettingVo> globalSettingVoList = globalSettingService.getGlobalSettingServiceList(new GlobalSettingListParam());
        return ApiResult.ok(globalSettingVoList);
    }

    /**
     * 获取 系统的博客选项设置 对象列表
     *
     * @param globalSettingListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的博客选项设置 对象列表")
    @PreAuthorize(hasPermi = "sys:global:setting:list")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.LIST)
    public ApiResult<List<GlobalSettingVo>> getGlobalSettingControllerList(@Valid @RequestBody GlobalSettingListParam globalSettingListParam) throws Exception {
        List<GlobalSettingVo> globalSettingVoList = globalSettingService.getGlobalSettingServiceList(globalSettingListParam);
        return ApiResult.ok(globalSettingVoList);
    }

    /**
     * 获取 系统的博客选项设置 分页对象列表
     *
     * @param globalSettingPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的博客选项设置 分页对象列表")
    @PreAuthorize(hasPermi = "sys:global:setting:pageList")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.PAGE_LIST)
    public ApiResult<Paging<GlobalSettingVo>> getGlobalSettingControllerPageList(@Valid @RequestBody GlobalSettingPageParam globalSettingPageParam) throws Exception {
        Paging<GlobalSettingVo> globalSettingVoList = globalSettingService.getGlobalSettingServicePageList(globalSettingPageParam);
        return ApiResult.ok(globalSettingVoList);
    }

    /**
     * 计算 系统的博客选项设置 总记录数
     *
     * @param globalSettingCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 系统的博客选项设置 对象的记录数")
    @PreAuthorize(hasPermi = "sys:global:setting:count")
    @Log(title = "系统的博客选项设置", businessType = BusinessType.COUNT)
    public ApiResult<Integer> countGlobalSettingController(@Valid @RequestBody GlobalSettingCountParam globalSettingCountParam) throws Exception {
        Integer count = globalSettingService.countGlobalSettingService(globalSettingCountParam);
        return ApiResult.ok(count);
    }


}

