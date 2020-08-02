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
import org.tiankafei.user.param.DictTableCheckParam;
import org.tiankafei.user.param.DictTableCountParam;
import org.tiankafei.user.param.DictTableDeleteParam;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.vo.DictTableVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-service", contextId = "sysDictTable", path = "/user/dict-table-entity")
public interface DictTableFeign {

    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典的数据表 对象是否存在")
    ApiResult<Boolean> checkDictTableControllerExists(@Valid @RequestBody DictTableCheckParam dictTableCheckParam) throws Exception;

    @PostMapping
    @ApiOperation(value = "添加 系统数据字典的数据表")
    ApiResult<Long> addDictTableController(@Valid @RequestBody DictTableVo dictTableVo) throws Exception;

    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统数据字典的数据表")
    ApiResult<List<Long>> batchAddDictTableController(@Valid @RequestBody List<DictTableVo> dictTableVoList) throws Exception;

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统数据字典的数据表")
    ApiResult<Boolean> deleteDictTableController(@PathVariable(value = "id") String id) throws Exception;

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统数据字典的数据表")
    ApiResult<Boolean> batchDeleteDictTableController(@Valid @RequestBody IdsParam idsParam) throws Exception;

    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统数据字典的数据表")
    ApiResult<Boolean> conditionDeleteDictTableController(@Valid @RequestBody DictTableDeleteParam dictTableDeleteParam) throws Exception;

    @PatchMapping
    @ApiOperation(value = "更新 系统数据字典的数据表")
    ApiResult<Boolean> updateDictTableController(@Valid @RequestBody DictTableVo dictTableVo) throws Exception;

    @GetMapping("/{id}")
    @ApiOperation(value = "获取 系统数据字典的数据表 对象")
    ApiResult<DictTableVo> getDictTableController(@PathVariable(value = "id") String id) throws Exception;

    @GetMapping
    @ApiOperation(value = "获取 系统数据字典的数据表 对象全部列表")
    ApiResult<List<DictTableVo>> getDictTableControllerAllList() throws Exception;

    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典的数据表 对象列表")
    ApiResult<List<DictTableVo>> getDictTableControllerList(@Valid @RequestBody DictTableListParam dictTableListParam) throws Exception;

    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典的数据表 分页对象列表")
    ApiResult<Paging<DictTableVo>> getDictTableControllerPageList(@Valid @RequestBody DictTablePageParam dictTablePageParam) throws Exception;

    @PostMapping("/count")
    @ApiOperation(value = "求 系统数据字典的数据表 对象的记录数")
    ApiResult<Integer> countDictTableController(@Valid @RequestBody DictTableCountParam dictTableCountParam) throws Exception;

}
