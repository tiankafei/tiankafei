package org.tiankafei.user.feign;

import com.ruoyi.common.core.web.page.Paging;
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
import com.ruoyi.common.core.web.domain.ApiResult;
import org.tiankafei.web.common.param.IdsParam;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-service", contextId = "sysDictInfo", path = "/dictInfo")
public interface DictInfoFeign {

    /**
     * 校验 系统数据字典表 是否已经存在
     *
     * @param dictInfoCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典表 对象是否存在")
    ApiResult<Boolean> checkDictInfoControllerExists(@Valid @RequestBody DictInfoCheckParam dictInfoCheckParam) throws Exception;

    /**
     * 保存 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 系统数据字典表")
    ApiResult<Long> addDictInfoController(@Valid @RequestBody DictInfoVo dictInfoVo) throws Exception;

    /**
     * 批量保存 系统数据字典表
     *
     * @param dictInfoVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统数据字典表")
    ApiResult<List<Long>> batchAddDictInfoController(@Valid @RequestBody List<DictInfoVo> dictInfoVoList) throws Exception;

    /**
     * 删除 系统数据字典表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统数据字典表")
    ApiResult<Boolean> deleteDictInfoController(@PathVariable(value = "id") String id) throws Exception;

    /**
     * 批量删除 系统数据字典表
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统数据字典表")
    ApiResult<Boolean> batchDeleteDictInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception;

    /**
     * 根据条件删除 系统数据字典表
     *
     * @param dictInfoDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统数据字典表")
    ApiResult<Boolean> conditionDeleteDictInfoController(@Valid @RequestBody DictInfoDeleteParam dictInfoDeleteParam) throws Exception;

    /**
     * 修改 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 系统数据字典表")
    ApiResult<Boolean> updateDictInfoController(@Valid @RequestBody DictInfoVo dictInfoVo) throws Exception;

    /**
     * 启用 系统数据字典表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/enable/{id}")
    @ApiOperation(value = "启用 系统数据字典表")
    ApiResult<Boolean> enableDictInfoController(@PathVariable(value = "id") String id) throws Exception;

    /**
     * 停用 系统数据字典表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/disable/{id}")
    @ApiOperation(value = "停用 系统数据字典表")
    ApiResult<Boolean> disableDictInfoController(@PathVariable(value = "id") String id) throws Exception;

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 系统数据字典表 对象")
    ApiResult<DictInfoVo> getDictInfoController(@PathVariable(value = "id") String id) throws Exception;

    /**
     * 获取 系统数据字典表 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 系统数据字典表 对象全部列表")
    ApiResult<List<DictInfoVo>> getDictInfoControllerAllList() throws Exception;

    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param dictInfoListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典表 对象列表")
    ApiResult<List<DictInfoVo>> getDictInfoControllerList(@Valid @RequestBody DictInfoListParam dictInfoListParam) throws Exception;

    /**
     * 获取 系统数据字典表 分页对象列表
     *
     * @param dictInfoPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典表 分页对象列表")
    ApiResult<Paging<DictInfoVo>> getDictInfoControllerPageList(@Valid @RequestBody DictInfoPageParam dictInfoPageParam) throws Exception;

    /**
     * 计算 系统数据字典表 总记录数
     *
     * @param dictInfoCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 系统数据字典表 对象的记录数")
    ApiResult<Integer> countDictInfoController(@Valid @RequestBody DictInfoCountParam dictInfoCountParam) throws Exception;

}
