package org.tiankafei.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.service.DictTableService;
import org.tiankafei.user.vo.DictTableVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统数据字典的数据表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/sysDictTable")
@Api(value = "系统数据字典的数据表 API", tags = "系统数据字典的数据表 功能维护")
public class DictTableController extends BaseController {

    @Autowired
    private DictTableService dictTableService;

    /**
     * 校验 系统数据字典的数据表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统数据字典的数据表 是否已经存在", notes = "校验 系统数据字典的数据表 是否已经存在")
    public ApiResult<Boolean> checkSysDictTableExists(@Valid @RequestBody DictTableListParam dictTableListParam) throws Exception {
        Boolean flag = dictTableService.checkSysDictTableExists(dictTableListParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 系统数据字典的数据表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 系统数据字典的数据表 对象", notes = "添加 系统数据字典的数据表")
    public ApiResult<String> addSysDictTable(@Valid @RequestBody DictTableVo dictTableVo) throws Exception {
        Object id = dictTableService.addSysDictTable(dictTableVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 系统数据字典的数据表 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 系统数据字典的数据表 对象", notes = "修改 系统数据字典的数据表")
    public ApiResult<Boolean> updateSysDictTable(@Valid @RequestBody DictTableVo dictTableVo) throws Exception {
        boolean flag = dictTableService.updateSysDictTable(dictTableVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 系统数据字典的数据表 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 系统数据字典的数据表 对象", notes = "删除 系统数据字典的数据表")
    public ApiResult<Boolean> deleteSysDictTable(
            @ApiParam(name = "dataTable", value = "字典数据表") @RequestParam("dataTable") String dataTable,
            @ApiParam(name = "ids", value = "要删除的字典数据的代码，多个用逗号分隔") @RequestParam("ids") String ids) throws Exception {
        boolean flag = dictTableService.deleteSysDictTable(dataTable, ids);
        return ApiResult.ok(flag);
    }

    /**
     * 获取 系统数据字典的数据表 对象详情
     */
    @GetMapping("/info/{dataTable}/{id}")
    @ApiOperation(value = "获取 系统数据字典的数据表 对象详情", notes = "获取 系统数据字典的数据表 对象详情")
    public ApiResult<DictTableVo> getSysDictTable(@PathVariable("dataTable") String dataTable, @PathVariable("id") String id) throws Exception {
        DictTableVo dictTableVo = dictTableService.getSysDictTableById(dataTable, id);
        return ApiResult.ok(dictTableVo);
    }

    /**
     * 获取 系统数据字典的数据表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统数据字典的数据表 分页列表", notes = "获取 系统数据字典的数据表 分页列表")
    public ApiResult<Paging<DictTableVo>> getSysDictTablePageList(@Valid @RequestBody DictTablePageParam dictTablePageParam) throws Exception {
        Paging<DictTableVo> paging = dictTableService.getSysDictTablePageList(dictTablePageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 获取 系统数据字典的数据表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统数据字典的数据表 列表", notes = "获取 系统数据字典的数据表 列表")
    public ApiResult<List<DictTableVo>> getSysDictTableList(@Valid @RequestBody DictTableListParam dictTableListParam) throws Exception {
        List<DictTableVo> paging = dictTableService.getSysDictTableList(dictTableListParam);
        return ApiResult.ok(paging);
    }

    /**
     * 计算 系统数据字典的数据表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 系统数据字典的数据表 总记录数", notes = "计算 系统数据字典的数据表 总记录数")
    public ApiResult<Integer> countSysDictTable(@Valid @RequestBody DictTableListParam dictTableListParam) throws Exception {
        int count = dictTableService.countSysDictTable(dictTableListParam);
        return ApiResult.ok(count);
    }

}