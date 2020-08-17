package org.tiankafei.user.feign;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.tiankafei.user.param.DictTableCheckParam;
import org.tiankafei.user.param.DictTableCountParam;
import org.tiankafei.user.param.DictTableDeleteParam;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.vo.DictTableVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.vo.Paging;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-service", contextId = "sysDictTable", path = "/dictTable")
public interface DictTableFeign {

    /**
     * 校验 系统数据字典的数据表 是否已经存在
     *
     * @param dictTableCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典的数据表 对象是否存在")
    ApiResult<Boolean> checkDictTableControllerExists(@Valid @RequestBody DictTableCheckParam dictTableCheckParam) throws Exception;

    /**
     * 保存 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 系统数据字典的数据表")
    ApiResult<Long> addDictTableController(@Valid @RequestBody DictTableVo dictTableVo) throws Exception;

    /**
     * 批量保存 系统数据字典的数据表
     *
     * @param dictTableVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统数据字典的数据表")
    ApiResult<List<Long>> batchAddDictTableController(@Valid @RequestBody List<DictTableVo> dictTableVoList) throws Exception;

    /**
     * 删除 系统数据字典的数据表
     *
     * @param dataTable
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统数据字典的数据表")
    ApiResult<Boolean> deleteDictTableController(@PathVariable(value = "dataTable") String dataTable, @PathVariable(value = "id") String id) throws Exception;

    /**
     * 批量删除 系统数据字典的数据表
     *
     * @param dataTable
     * @param ids
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统数据字典的数据表")
    ApiResult<Boolean> batchDeleteDictTableController(
            @ApiParam(name = "dataTable", value = "字典数据表") @RequestParam("dataTable") String dataTable,
            @ApiParam(name = "ids", value = "要删除的字典数据的代码，多个用逗号分隔") @RequestParam("ids") String ids) throws Exception;

    /**
     * 根据条件删除 系统数据字典的数据表
     *
     * @param dictTableDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统数据字典的数据表")
    ApiResult<Boolean> conditionDeleteDictTableController(@Valid @RequestBody DictTableDeleteParam dictTableDeleteParam) throws Exception;

    /**
     * 修改 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "更新 系统数据字典的数据表")
    ApiResult<Boolean> updateDictTableController(@Valid @RequestBody DictTableVo dictTableVo) throws Exception;

    /**
     * 根据ID获取 系统数据字典的数据表 对象
     *
     * @param dataTable
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 系统数据字典的数据表 对象")
    ApiResult<DictTableVo> getDictTableController(@PathVariable(value = "dataTable") String dataTable, @PathVariable(value = "id") String id) throws Exception;

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param dataTable
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 系统数据字典的数据表 对象全部列表")
    ApiResult<List<DictTableVo>> getDictTableControllerAllList(@PathVariable(value = "dataTable") String dataTable) throws Exception;

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典的数据表 对象列表")
    ApiResult<List<DictTableVo>> getDictTableControllerList(@Valid @RequestBody DictTableListParam dictTableListParam) throws Exception;

    /**
     * 获取 系统数据字典的数据表 分页对象列表
     *
     * @param dictTablePageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典的数据表 分页对象列表")
    ApiResult<Paging<DictTableVo>> getDictTableControllerPageList(@Valid @RequestBody DictTablePageParam dictTablePageParam) throws Exception;

    /**
     * 计算 系统数据字典的数据表 总记录数
     *
     * @param dictTableCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 系统数据字典的数据表 对象的记录数")
    ApiResult<Integer> countDictTableController(@Valid @RequestBody DictTableCountParam dictTableCountParam) throws Exception;

}
