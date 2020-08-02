package org.tiankafei.user.feign;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tiankafei.user.param.DictInfoCheckParam;
import org.tiankafei.user.param.DictInfoCountParam;
import org.tiankafei.user.param.DictInfoDeleteParam;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.vo.DictInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-service", contextId = "sysDictInfo", path = "/user/dict-info-entity")
public interface DictInfoFeign {

    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典表 对象是否存在")
    ApiResult<Boolean> checkDictInfoControllerExists(@Valid @RequestBody DictInfoCheckParam dictInfoCheckParam) throws Exception;

    @PostMapping
    @ApiOperation(value = "添加 系统数据字典表")
    ApiResult<Long> addDictInfoController(@Valid @RequestBody DictInfoVo dictInfoVo) throws Exception;

    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统数据字典表")
    ApiResult<List<Long>> batchAddDictInfoController(@Valid @RequestBody List<DictInfoVo> dictInfoVoList) throws Exception;

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统数据字典表")
    ApiResult<Boolean> deleteDictInfoController(@PathVariable(value = "id") String id) throws Exception;

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统数据字典表")
    ApiResult<Boolean> batchDeleteDictInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception;

    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统数据字典表")
    ApiResult<Boolean> conditionDeleteDictInfoController(@Valid @RequestBody DictInfoDeleteParam dictInfoDeleteParam) throws Exception;

    @PatchMapping
    @ApiOperation(value = "更新 系统数据字典表")
    ApiResult<Boolean> updateDictInfoController(@Valid @RequestBody DictInfoVo dictInfoVo) throws Exception;

    @GetMapping("/{id}")
    @ApiOperation(value = "获取 系统数据字典表 对象")
    ApiResult<DictInfoVo> getDictInfoController(@PathVariable(value = "id") String id) throws Exception;

    @GetMapping
    @ApiOperation(value = "获取 系统数据字典表 对象全部列表")
    ApiResult<List<DictInfoVo>> getDictInfoControllerAllList() throws Exception;

    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典表 对象列表")
    ApiResult<List<DictInfoVo>> getDictInfoControllerList(@Valid @RequestBody DictInfoListParam dictInfoListParam) throws Exception;

    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典表 分页对象列表")
    ApiResult<Paging<DictInfoVo>> getDictInfoControllerPageList(@Valid @RequestBody DictInfoPageParam dictInfoPageParam) throws Exception;

    @PostMapping("/count")
    @ApiOperation(value = "求 系统数据字典表 对象的记录数")
    ApiResult<Integer> countDictInfoController(@Valid @RequestBody DictInfoCountParam dictInfoCountParam) throws Exception;

}
