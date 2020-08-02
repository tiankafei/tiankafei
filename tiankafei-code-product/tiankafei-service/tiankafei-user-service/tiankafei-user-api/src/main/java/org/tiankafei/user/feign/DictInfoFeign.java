package org.tiankafei.user.feign;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.vo.DictInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

import javax.validation.Valid;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-service", contextId = "sysDictInfo", path = "/sysDictInfo")
public interface DictInfoFeign {

    /**
     * 校验 系统数据字典表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典表 是否已经存在", notes = "校验 系统数据字典表 是否已经存在")
    public ApiResult<Boolean> checkSysDictInfoExists(@Valid @RequestBody DictInfoListParam dictInfoListParam) throws Exception;

    /**
     * 添加 系统数据字典表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统数据字典表 对象", notes = "添加 系统数据字典表")
    public ApiResult<String> addSysDictInfo(@Valid @RequestBody DictInfoVo dictInfoVo) throws Exception;

    /**
     * 修改 系统数据字典表 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 系统数据字典表 对象", notes = "修改 系统数据字典表")
    public ApiResult<Boolean> updateSysDictInfo(@Valid @RequestBody DictInfoVo dictInfoVo) throws Exception;

    /**
     * 启用 系统数据字典表 对象
     */
    @GetMapping("/enable/{id}")
    @ApiOperation(value = "启用 系统数据字典表 对象", notes = "启用 系统数据字典表 对象")
    public ApiResult<Boolean> enable(@PathVariable String id) throws Exception;

    /**
     * 禁用 系统数据字典表 对象
     */
    @PostMapping("/disable/{id}")
    @ApiOperation(value = "禁用 系统数据字典表 对象", notes = "禁用 系统数据字典表 对象")
    public ApiResult<Boolean> disable(@PathVariable String id) throws Exception;

    /**
     * 删除 系统数据字典表 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 系统数据字典表 对象", notes = "删除 系统数据字典表")
    public ApiResult<Boolean> deleteSysDictInfo(@Valid @RequestBody IdsParam idsParam) throws Exception;

    /**
     * 获取 系统数据字典表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 系统数据字典表 对象详情", notes = "获取 系统数据字典表 对象详情")
    public ApiResult<DictInfoVo> getSysDictInfo(@PathVariable("id") String id) throws Exception;

    /**
     * 获取 系统数据字典表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典表 分页列表", notes = "获取 系统数据字典表 分页列表")
    public ApiResult<Paging<DictInfoVo>> getSysDictInfoPageList(@Valid @RequestBody DictInfoPageParam dictInfoPageParam) throws Exception;

    /**
     * 获取 系统数据字典表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典表 列表", notes = "获取 系统数据字典表 列表")
    public ApiResult<List<DictInfoVo>> getSysDictInfoList(@Valid @RequestBody DictInfoListParam dictInfoListParam) throws Exception;

    /**
     * 计算 系统数据字典表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统数据字典表 总记录数", notes = "计算 系统数据字典表 总记录数")
    public ApiResult<Integer> countSysDictInfo(@Valid @RequestBody DictInfoListParam dictInfoListParam) throws Exception;

}
