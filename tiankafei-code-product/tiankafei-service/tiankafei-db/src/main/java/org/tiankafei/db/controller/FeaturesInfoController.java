package org.tiankafei.db.controller;

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
import org.tiankafei.db.param.FeaturesInfoCheckParam;
import org.tiankafei.db.param.FeaturesInfoCountParam;
import org.tiankafei.db.param.FeaturesInfoDeleteParam;
import org.tiankafei.db.param.FeaturesInfoListParam;
import org.tiankafei.db.param.FeaturesInfoPageParam;
import org.tiankafei.db.service.FeaturesInfoService;
import org.tiankafei.db.vo.FeaturesInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 功能注册表 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/featuresInfo")
@Api(value = "功能注册表 API", tags = {"功能注册表"})
public class FeaturesInfoController extends BaseController {

    @Autowired
    private FeaturesInfoService featuresInfoService;

    /**
     * 校验 功能注册表 是否已经存在
     *
     * @param featuresInfoCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 功能注册表 对象是否存在")
    @PreAuthorize(hasPermi = "features:info:check")
    @Log(title = "功能注册表", businessType = BusinessType.CHECK)
    public ApiResult<Boolean> checkFeaturesInfoControllerExists(@Valid @RequestBody FeaturesInfoCheckParam featuresInfoCheckParam) throws Exception {
        Boolean flag = featuresInfoService.checkFeaturesInfoServiceExists(featuresInfoCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 功能注册表
     *
     * @param featuresInfoVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 功能注册表")
    @PreAuthorize(hasPermi = "features:info:add")
    @Log(title = "功能注册表", businessType = BusinessType.INSERT)
    public ApiResult<Integer> addFeaturesInfoController(@Valid @RequestBody FeaturesInfoVo featuresInfoVo) throws Exception {
        Integer id = featuresInfoService.addFeaturesInfoService(featuresInfoVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 功能注册表
     *
     * @param featuresInfoVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 功能注册表")
    @PreAuthorize(hasPermi = "features:info:batchAdd")
    @Log(title = "功能注册表", businessType = BusinessType.BATCH_INSERT)
    public ApiResult<List<Integer>> batchAddFeaturesInfoController(@Valid @RequestBody List<FeaturesInfoVo> featuresInfoVoList) throws Exception {
        List<Integer> idList = featuresInfoService.batchAddFeaturesInfoService(featuresInfoVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 功能注册表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 功能注册表")
    @PreAuthorize(hasPermi = "features:info:delete")
    @Log(title = "功能注册表", businessType = BusinessType.DELETE)
    public ApiResult<Boolean> deleteFeaturesInfoController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = featuresInfoService.deleteFeaturesInfoService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 功能注册表
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 功能注册表")
    @PreAuthorize(hasPermi = "features:info:batchDelete")
    @Log(title = "功能注册表", businessType = BusinessType.BATCH_DELETE)
    public ApiResult<Boolean> batchDeleteFeaturesInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = featuresInfoService.batchDeleteFeaturesInfoService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 功能注册表
     *
     * @param featuresInfoDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 功能注册表")
    @PreAuthorize(hasPermi = "features:info:conditionDelete")
    @Log(title = "功能注册表", businessType = BusinessType.CONDITION_DELETE)
    public ApiResult<Boolean> conditionDeleteFeaturesInfoController(@Valid @RequestBody FeaturesInfoDeleteParam featuresInfoDeleteParam) throws Exception {
        boolean flag = featuresInfoService.conditionDeleteFeaturesInfoService(featuresInfoDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 功能注册表
     *
     * @param featuresInfoVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 功能注册表")
    @PreAuthorize(hasPermi = "features:info:update")
    @Log(title = "功能注册表", businessType = BusinessType.UPDATE)
    public ApiResult<Boolean> updateFeaturesInfoController(@Valid @RequestBody FeaturesInfoVo featuresInfoVo) throws Exception {
        boolean flag = featuresInfoService.updateFeaturesInfoService(featuresInfoVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 功能注册表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 功能注册表 对象")
    @PreAuthorize(hasPermi = "features:info:get")
    @Log(title = "功能注册表", businessType = BusinessType.INFO)
    public ApiResult<FeaturesInfoVo> getFeaturesInfoController(@PathVariable(value = "id") String id) throws Exception {
        FeaturesInfoVo featuresInfoVo = featuresInfoService.getFeaturesInfoServiceById(id);
        return ApiResult.ok(featuresInfoVo);
    }

    /**
     * 获取 功能注册表 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 功能注册表 对象全部列表")
    @PreAuthorize(hasPermi = "features:info:allList")
    @Log(title = "功能注册表", businessType = BusinessType.ALL_LIST)
    public ApiResult<List<FeaturesInfoVo>> getFeaturesInfoControllerAllList() throws Exception {
        List<FeaturesInfoVo> featuresInfoVoList = featuresInfoService.getFeaturesInfoServiceList(new FeaturesInfoListParam());
        return ApiResult.ok(featuresInfoVoList);
    }

    /**
     * 获取 功能注册表 对象列表
     *
     * @param featuresInfoListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 功能注册表 对象列表")
    @PreAuthorize(hasPermi = "features:info:list")
    @Log(title = "功能注册表", businessType = BusinessType.LIST)
    public ApiResult<List<FeaturesInfoVo>> getFeaturesInfoControllerList(@Valid @RequestBody FeaturesInfoListParam featuresInfoListParam) throws Exception {
        List<FeaturesInfoVo> featuresInfoVoList = featuresInfoService.getFeaturesInfoServiceList(featuresInfoListParam);
        return ApiResult.ok(featuresInfoVoList);
    }

    /**
     * 获取 功能注册表 分页对象列表
     *
     * @param featuresInfoPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 功能注册表 分页对象列表")
    @PreAuthorize(hasPermi = "features:info:pageList")
    @Log(title = "功能注册表", businessType = BusinessType.PAGE_LIST)
    public ApiResult<Paging<FeaturesInfoVo>> getFeaturesInfoControllerPageList(@Valid @RequestBody FeaturesInfoPageParam featuresInfoPageParam) throws Exception {
        Paging<FeaturesInfoVo> featuresInfoVoList = featuresInfoService.getFeaturesInfoServicePageList(featuresInfoPageParam);
        return ApiResult.ok(featuresInfoVoList);
    }

    /**
     * 计算 功能注册表 总记录数
     *
     * @param featuresInfoCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 功能注册表 对象的记录数")
    @PreAuthorize(hasPermi = "features:info:count")
    @Log(title = "功能注册表", businessType = BusinessType.COUNT)
    public ApiResult<Integer> countFeaturesInfoController(@Valid @RequestBody FeaturesInfoCountParam featuresInfoCountParam) throws Exception {
        Integer count = featuresInfoService.countFeaturesInfoService(featuresInfoCountParam);
        return ApiResult.ok(count);
    }


}

