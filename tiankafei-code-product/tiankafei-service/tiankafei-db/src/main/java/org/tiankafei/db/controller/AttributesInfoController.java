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
import org.tiankafei.db.param.AttributesInfoCheckParam;
import org.tiankafei.db.param.AttributesInfoCountParam;
import org.tiankafei.db.param.AttributesInfoDeleteParam;
import org.tiankafei.db.param.AttributesInfoListParam;
import org.tiankafei.db.param.AttributesInfoPageParam;
import org.tiankafei.db.service.AttributesInfoService;
import org.tiankafei.db.vo.AttributesInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 功能的属性注册表 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/attributesInfo")
@Api(value = "功能的属性注册表 API", tags = {"功能的属性注册表"})
public class AttributesInfoController extends BaseController {

    @Autowired
    private AttributesInfoService attributesInfoService;

    /**
     * 校验 功能的属性注册表 是否已经存在
     *
     * @param attributesInfoCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 功能的属性注册表 对象是否存在")
    @PreAuthorize(hasPermi = "attributes:info:check")
    @Log(title = "功能的属性注册表", businessType = BusinessType.CHECK)
    public ApiResult<Boolean> checkAttributesInfoControllerExists(@Valid @RequestBody AttributesInfoCheckParam attributesInfoCheckParam) throws Exception {
        Boolean flag = attributesInfoService.checkAttributesInfoServiceExists(attributesInfoCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 功能的属性注册表
     *
     * @param attributesInfoVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 功能的属性注册表")
    @PreAuthorize(hasPermi = "attributes:info:add")
    @Log(title = "功能的属性注册表", businessType = BusinessType.INSERT)
    public ApiResult<Long> addAttributesInfoController(@Valid @RequestBody AttributesInfoVo attributesInfoVo) throws Exception {
        Long id = attributesInfoService.addAttributesInfoService(attributesInfoVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 功能的属性注册表
     *
     * @param attributesInfoVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 功能的属性注册表")
    @PreAuthorize(hasPermi = "attributes:info:batchAdd")
    @Log(title = "功能的属性注册表", businessType = BusinessType.BATCH_INSERT)
    public ApiResult<List<Long>> batchAddAttributesInfoController(@Valid @RequestBody List<AttributesInfoVo> attributesInfoVoList) throws Exception {
        List<Long> idList = attributesInfoService.batchAddAttributesInfoService(attributesInfoVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 功能的属性注册表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 功能的属性注册表")
    @PreAuthorize(hasPermi = "attributes:info:delete")
    @Log(title = "功能的属性注册表", businessType = BusinessType.DELETE)
    public ApiResult<Boolean> deleteAttributesInfoController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = attributesInfoService.deleteAttributesInfoService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 功能的属性注册表
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 功能的属性注册表")
    @PreAuthorize(hasPermi = "attributes:info:batchDelete")
    @Log(title = "功能的属性注册表", businessType = BusinessType.BATCH_DELETE)
    public ApiResult<Boolean> batchDeleteAttributesInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = attributesInfoService.batchDeleteAttributesInfoService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 功能的属性注册表
     *
     * @param attributesInfoDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 功能的属性注册表")
    @PreAuthorize(hasPermi = "attributes:info:conditionDelete")
    @Log(title = "功能的属性注册表", businessType = BusinessType.CONDITION_DELETE)
    public ApiResult<Boolean> conditionDeleteAttributesInfoController(@Valid @RequestBody AttributesInfoDeleteParam attributesInfoDeleteParam) throws Exception {
        boolean flag = attributesInfoService.conditionDeleteAttributesInfoService(attributesInfoDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 功能的属性注册表
     *
     * @param attributesInfoVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 功能的属性注册表")
    @PreAuthorize(hasPermi = "attributes:info:update")
    @Log(title = "功能的属性注册表", businessType = BusinessType.UPDATE)
    public ApiResult<Boolean> updateAttributesInfoController(@Valid @RequestBody AttributesInfoVo attributesInfoVo) throws Exception {
        boolean flag = attributesInfoService.updateAttributesInfoService(attributesInfoVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 功能的属性注册表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 功能的属性注册表 对象")
    @PreAuthorize(hasPermi = "attributes:info:get")
    @Log(title = "功能的属性注册表", businessType = BusinessType.INFO)
    public ApiResult<AttributesInfoVo> getAttributesInfoController(@PathVariable(value = "id") String id) throws Exception {
        AttributesInfoVo attributesInfoVo = attributesInfoService.getAttributesInfoServiceById(id);
        return ApiResult.ok(attributesInfoVo);
    }

    /**
     * 获取 功能的属性注册表 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 功能的属性注册表 对象全部列表")
    @PreAuthorize(hasPermi = "attributes:info:allList")
    @Log(title = "功能的属性注册表", businessType = BusinessType.ALL_LIST)
    public ApiResult<List<AttributesInfoVo>> getAttributesInfoControllerAllList() throws Exception {
        List<AttributesInfoVo> attributesInfoVoList = attributesInfoService.getAttributesInfoServiceList(new AttributesInfoListParam());
        return ApiResult.ok(attributesInfoVoList);
    }

    /**
     * 获取 功能的属性注册表 对象列表
     *
     * @param attributesInfoListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 功能的属性注册表 对象列表")
    @PreAuthorize(hasPermi = "attributes:info:list")
    @Log(title = "功能的属性注册表", businessType = BusinessType.LIST)
    public ApiResult<List<AttributesInfoVo>> getAttributesInfoControllerList(@Valid @RequestBody AttributesInfoListParam attributesInfoListParam) throws Exception {
        List<AttributesInfoVo> attributesInfoVoList = attributesInfoService.getAttributesInfoServiceList(attributesInfoListParam);
        return ApiResult.ok(attributesInfoVoList);
    }

    /**
     * 获取 功能的属性注册表 分页对象列表
     *
     * @param attributesInfoPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 功能的属性注册表 分页对象列表")
    @PreAuthorize(hasPermi = "attributes:info:pageList")
    @Log(title = "功能的属性注册表", businessType = BusinessType.PAGE_LIST)
    public ApiResult<Paging<AttributesInfoVo>> getAttributesInfoControllerPageList(@Valid @RequestBody AttributesInfoPageParam attributesInfoPageParam) throws Exception {
        Paging<AttributesInfoVo> attributesInfoVoList = attributesInfoService.getAttributesInfoServicePageList(attributesInfoPageParam);
        return ApiResult.ok(attributesInfoVoList);
    }

    /**
     * 计算 功能的属性注册表 总记录数
     *
     * @param attributesInfoCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 功能的属性注册表 对象的记录数")
    @PreAuthorize(hasPermi = "attributes:info:count")
    @Log(title = "功能的属性注册表", businessType = BusinessType.COUNT)
    public ApiResult<Integer> countAttributesInfoController(@Valid @RequestBody AttributesInfoCountParam attributesInfoCountParam) throws Exception {
        Integer count = attributesInfoService.countAttributesInfoService(attributesInfoCountParam);
        return ApiResult.ok(count);
    }


}

