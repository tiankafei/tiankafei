package org.tiankafei.user.feign;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.tiankafei.user.param.SysDictTablePageQueryParam;
import org.tiankafei.user.param.SysDictTableQueryParam;
import org.tiankafei.user.vo.SysDictTableQueryVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.vo.Paging;

import javax.validation.Valid;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-service", contextId = "sysDictTable")
public interface SysDictTableFeign {

    /**
     * 校验 系统数据字典的数据表 是否已经存在
     */
    @PostMapping("/sysDictTable/check")
    @ApiOperation(value = "校验 系统数据字典的数据表 是否已经存在", notes = "校验 系统数据字典的数据表 是否已经存在")
    public ApiResult<Boolean> checkSysDictTableExists(@Valid @RequestBody SysDictTableQueryParam sysDictTableQueryParam) throws Exception ;

    /**
     * 添加 系统数据字典的数据表 对象
     */
    @PostMapping("/sysDictTable/add")
    @ApiOperation(value = "添加 系统数据字典的数据表 对象", notes = "添加 系统数据字典的数据表")
    public ApiResult<String> addSysDictTable(@Valid @RequestBody SysDictTableQueryVo sysDictTableQueryVo) throws Exception ;

    /**
     * 修改 系统数据字典的数据表 对象
     */
    @PutMapping("/sysDictTable/update")
    @ApiOperation(value = "修改 系统数据字典的数据表 对象", notes = "修改 系统数据字典的数据表")
    public ApiResult<Boolean> updateSysDictTable(@Valid @RequestBody SysDictTableQueryVo sysDictTableQueryVo) throws Exception ;

    /**
     * 删除 系统数据字典的数据表 对象
     */
    @DeleteMapping("/sysDictTable/delete")
    @ApiOperation(value = "删除 系统数据字典的数据表 对象", notes = "删除 系统数据字典的数据表")
    public ApiResult<Boolean> deleteSysDictTable(
            @ApiParam(name = "dataTable", value = "字典数据表") @RequestParam("dataTable") String dataTable,
            @ApiParam(name = "ids", value = "要删除的字典数据的代码，多个用逗号分隔") @RequestParam("ids") String ids) throws Exception ;

    /**
     * 获取 系统数据字典的数据表 对象详情
     */
    @GetMapping("/sysDictTable/info/{dataTable}/{id}")
    @ApiOperation(value = "获取 系统数据字典的数据表 对象详情", notes = "获取 系统数据字典的数据表 对象详情")
    public ApiResult<SysDictTableQueryVo> getSysDictTable(@PathVariable("dataTable") String dataTable, @PathVariable("id") String id) throws Exception ;

    /**
     * 获取 系统数据字典的数据表 分页列表
     */
    @PostMapping("/sysDictTable/pageList")
    @ApiOperation(value = "获取 系统数据字典的数据表 分页列表", notes = "获取 系统数据字典的数据表 分页列表")
    public ApiResult<Paging<SysDictTableQueryVo>> getSysDictTablePageList(@Valid @RequestBody SysDictTablePageQueryParam sysDictTablePageQueryParam) throws Exception ;

    /**
     * 获取 系统数据字典的数据表 列表
     */
    @PostMapping("/sysDictTable/list")
    @ApiOperation(value = "获取 系统数据字典的数据表 列表", notes = "获取 系统数据字典的数据表 列表")
    public ApiResult<List<SysDictTableQueryVo>> getSysDictTableList(@Valid @RequestBody SysDictTableQueryParam sysDictTableQueryParam) throws Exception ;

    /**
     * 计算 系统数据字典的数据表 总记录数
     */
    @PostMapping("/sysDictTable/count")
    @ApiOperation(value = "计算 系统数据字典的数据表 总记录数", notes = "计算 系统数据字典的数据表 总记录数")
    public ApiResult<Integer> countSysDictTable(@Valid @RequestBody SysDictTableQueryParam sysDictTableQueryParam) throws Exception ;

}
