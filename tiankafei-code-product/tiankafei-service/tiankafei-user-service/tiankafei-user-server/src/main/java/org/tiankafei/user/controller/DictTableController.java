package org.tiankafei.user.controller;

import com.ruoyi.common.core.web.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.param.DictTableCheckParam;
import org.tiankafei.user.param.DictTableCountParam;
import org.tiankafei.user.param.DictTableDeleteParam;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.service.DictTableService;
import org.tiankafei.user.vo.DictTableVo;
import com.ruoyi.common.core.web.domain.ApiResult;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 系统数据字典的数据表 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/dictTable")
@Api(value = "系统数据字典的数据表 API", tags = {"系统数据字典的数据表"})
public class DictTableController extends BaseController {

    @Autowired
    private DictTableService dictTableService;

    /**
     * 校验 系统数据字典的数据表 是否已经存在
     *
     * @param dictTableCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典的数据表 对象是否存在")
    public ApiResult<Boolean> checkDictTableControllerExists(@Valid @RequestBody DictTableCheckParam dictTableCheckParam) throws Exception {
        Boolean flag = dictTableService.checkDictTableServiceExists(dictTableCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 系统数据字典的数据表")
    public ApiResult<Long> addDictTableController(@Valid @RequestBody DictTableVo dictTableVo) throws Exception {
        Long id = dictTableService.addDictTableService(dictTableVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 系统数据字典的数据表
     *
     * @param dictTableVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统数据字典的数据表")
    public ApiResult<List<Long>> batchAddDictTableController(@Valid @RequestBody List<DictTableVo> dictTableVoList) throws Exception {
        List<Long> idList = dictTableService.batchAddDictTableService(dictTableVoList);
        return ApiResult.ok(idList);
    }

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
    public ApiResult<Boolean> deleteDictTableController(@PathVariable(value = "dataTable") String dataTable, @PathVariable(value = "id") String id) throws Exception {
        boolean flag = dictTableService.deleteDictTableService(dataTable, id);
        return ApiResult.ok(flag);
    }

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
    public ApiResult<Boolean> batchDeleteDictTableController(
            @ApiParam(name = "dataTable", value = "字典数据表") @RequestParam("dataTable") String dataTable,
            @ApiParam(name = "ids", value = "要删除的字典数据的代码，多个用逗号分隔") @RequestParam("ids") String ids) throws Exception {
        boolean flag = dictTableService.batchDeleteDictTableService(dataTable, ids);
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 系统数据字典的数据表
     *
     * @param dictTableDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统数据字典的数据表")
    public ApiResult<Boolean> conditionDeleteDictTableController(@Valid @RequestBody DictTableDeleteParam dictTableDeleteParam) throws Exception {
        boolean flag = dictTableService.conditionDeleteDictTableService(dictTableDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 系统数据字典的数据表
     *
     * @param dictTableVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "更新 系统数据字典的数据表")
    public ApiResult<Boolean> updateDictTableController(@Valid @RequestBody DictTableVo dictTableVo) throws Exception {
        boolean flag = dictTableService.updateDictTableService(dictTableVo);
        return ApiResult.ok(flag);
    }

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
    public ApiResult<DictTableVo> getDictTableController(@PathVariable(value = "dataTable") String dataTable, @PathVariable(value = "id") String id) throws Exception {
        DictTableVo dictTableVo = dictTableService.getDictTableServiceById(dataTable, id);
        return ApiResult.ok(dictTableVo);
    }

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param dataTable
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 系统数据字典的数据表 对象全部列表")
    public ApiResult<List<DictTableVo>> getDictTableControllerAllList(@PathVariable(value = "dataTable") String dataTable) throws Exception {
        DictTableListParam dictTableListParam = new DictTableListParam();
        dictTableListParam.setDataTable(dataTable);
        List<DictTableVo> dictTableVoList = dictTableService.getDictTableServiceList(dictTableListParam);
        return ApiResult.ok(dictTableVoList);
    }

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param dictTableListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典的数据表 对象列表")
    public ApiResult<List<DictTableVo>> getDictTableControllerList(@Valid @RequestBody DictTableListParam dictTableListParam) throws Exception {
        List<DictTableVo> dictTableVoList = dictTableService.getDictTableServiceList(dictTableListParam);
        return ApiResult.ok(dictTableVoList);
    }

    /**
     * 获取 系统数据字典的数据表 分页对象列表
     *
     * @param dictTablePageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典的数据表 分页对象列表")
    public ApiResult<Paging<DictTableVo>> getDictTableControllerPageList(@Valid @RequestBody DictTablePageParam dictTablePageParam) throws Exception {
        Paging<DictTableVo> dictTableVoList = dictTableService.getDictTableServicePageList(dictTablePageParam);
        return ApiResult.ok(dictTableVoList);
    }

    /**
     * 计算 系统数据字典的数据表 总记录数
     *
     * @param dictTableCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 系统数据字典的数据表 对象的记录数")
    public ApiResult<Integer> countDictTableController(@Valid @RequestBody DictTableCountParam dictTableCountParam) throws Exception {
        Integer count = dictTableService.countDictTableService(dictTableCountParam);
        return ApiResult.ok(count);
    }


}

