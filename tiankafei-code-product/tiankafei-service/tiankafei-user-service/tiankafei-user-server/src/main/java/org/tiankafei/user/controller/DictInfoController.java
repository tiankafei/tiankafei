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
import org.tiankafei.user.param.DictInfoCheckParam;
import org.tiankafei.user.param.DictInfoCountParam;
import org.tiankafei.user.param.DictInfoDeleteParam;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.service.DictInfoService;
import org.tiankafei.user.vo.DictInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统数据字典表 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/user/dict-info-entity")
@Api(value = "系统数据字典表 API", tags = {"系统数据字典表"})
public class DictInfoController extends BaseController {

    @Autowired
    private DictInfoService dictInfoService;

    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典表 对象是否存在")
    public ApiResult<Boolean> checkDictInfoControllerExists(@Valid @RequestBody DictInfoCheckParam dictInfoCheckParam) throws Exception {
        Boolean flag = dictInfoService.checkDictInfoServiceExists(dictInfoCheckParam);
        return ApiResult.ok(flag);
    }

    @PostMapping
    @ApiOperation(value = "添加 系统数据字典表")
    public ApiResult<Long> addDictInfoController(@Valid @RequestBody DictInfoVo dictInfoVo) throws Exception {
        Long id = dictInfoService.addDictInfoService(dictInfoVo);
        return ApiResult.ok(id);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统数据字典表")
    public ApiResult<List<Long>> batchAddDictInfoController(@Valid @RequestBody List<DictInfoVo> dictInfoVoList) throws Exception {
        List<Long> idList = dictInfoService.batchAddDictInfoService(dictInfoVoList);
        return ApiResult.ok(idList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统数据字典表")
    public ApiResult<Boolean> deleteDictInfoController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = dictInfoService.deleteDictInfoService(id);
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统数据字典表")
    public ApiResult<Boolean> batchDeleteDictInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = dictInfoService.batchDeleteDictInfoService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统数据字典表")
    public ApiResult<Boolean> conditionDeleteDictInfoController(@Valid @RequestBody DictInfoDeleteParam dictInfoDeleteParam) throws Exception {
        boolean flag = dictInfoService.conditionDeleteDictInfoService(dictInfoDeleteParam);
        return ApiResult.ok(flag);
    }

    @PatchMapping
    @ApiOperation(value = "更新 系统数据字典表")
    public ApiResult<Boolean> updateDictInfoController(@Valid @RequestBody DictInfoVo dictInfoVo) throws Exception {
        boolean flag = dictInfoService.updateDictInfoService(dictInfoVo);
        return ApiResult.ok(flag);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取 系统数据字典表 对象")
    public ApiResult<DictInfoVo> getDictInfoController(@PathVariable(value = "id") String id) throws Exception {
        DictInfoVo dictInfoVo = dictInfoService.getDictInfoServiceById(id);
        return ApiResult.ok(dictInfoVo);
    }

    @GetMapping
    @ApiOperation(value = "获取 系统数据字典表 对象全部列表")
    public ApiResult<List<DictInfoVo>> getDictInfoControllerAllList() throws Exception {
        List<DictInfoVo> dictInfoVoList = dictInfoService.getDictInfoServiceList(null);
        return ApiResult.ok(dictInfoVoList);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典表 对象列表")
    public ApiResult<List<DictInfoVo>> getDictInfoControllerList(@Valid @RequestBody DictInfoListParam dictInfoListParam) throws Exception {
        List<DictInfoVo> dictInfoVoList = dictInfoService.getDictInfoServiceList(dictInfoListParam);
        return ApiResult.ok(dictInfoVoList);
    }

    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典表 分页对象列表")
    public ApiResult<Paging<DictInfoVo>> getDictInfoControllerPageList(@Valid @RequestBody DictInfoPageParam dictInfoPageParam) throws Exception {
        Paging<DictInfoVo> dictInfoVoList = dictInfoService.getDictInfoServicePageList(dictInfoPageParam);
        return ApiResult.ok(dictInfoVoList);
    }

    @PostMapping("/count")
    @ApiOperation(value = "求 系统数据字典表 对象的记录数")
    public ApiResult<Integer> countDictInfoController(@Valid @RequestBody DictInfoCountParam dictInfoCountParam) throws Exception {
        Integer count = dictInfoService.countDictInfoService(dictInfoCountParam);
        return ApiResult.ok(count);
    }


}

