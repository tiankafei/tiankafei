package org.tiankafei.rule.controller;

import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.ApiResult;
import com.ruoyi.common.core.web.page.Paging;
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
import org.tiankafei.rule.param.RuleDatasetAliasCheckParam;
import org.tiankafei.rule.param.RuleDatasetAliasCountParam;
import org.tiankafei.rule.param.RuleDatasetAliasDeleteParam;
import org.tiankafei.rule.param.RuleDatasetAliasListParam;
import org.tiankafei.rule.param.RuleDatasetAliasPageParam;
import org.tiankafei.rule.service.RuleDatasetAliasService;
import org.tiankafei.rule.vo.RuleDatasetAliasVo;
import org.tiankafei.web.common.param.IdsParam;

/**
 * <p>
 * 规则数据集的别名 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/ruleDatasetAlias")
@Api(value = "规则数据集的别名 API", tags = {"规则数据集的别名"})
public class RuleDatasetAliasController extends BaseController {

    @Autowired
    private RuleDatasetAliasService ruleDatasetAliasService;

    /**
     * 校验 规则数据集的别名 是否已经存在
     *
     * @param ruleDatasetAliasCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 规则数据集的别名 对象是否存在")
    public ApiResult<Boolean> checkRuleDatasetAliasControllerExists(@Valid @RequestBody RuleDatasetAliasCheckParam ruleDatasetAliasCheckParam) throws Exception {
        Boolean flag = ruleDatasetAliasService.checkRuleDatasetAliasServiceExists(ruleDatasetAliasCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 规则数据集的别名
     *
     * @param ruleDatasetAliasVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 规则数据集的别名")
    public ApiResult<Long> addRuleDatasetAliasController(@Valid @RequestBody RuleDatasetAliasVo ruleDatasetAliasVo) throws Exception {
        Long id = ruleDatasetAliasService.addRuleDatasetAliasService(ruleDatasetAliasVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 规则数据集的别名
     *
     * @param ruleDatasetAliasVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 规则数据集的别名")
    public ApiResult<List<Long>> batchAddRuleDatasetAliasController(@Valid @RequestBody List<RuleDatasetAliasVo> ruleDatasetAliasVoList) throws Exception {
        List<Long> idList = ruleDatasetAliasService.batchAddRuleDatasetAliasService(ruleDatasetAliasVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 规则数据集的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 规则数据集的别名")
    public ApiResult<Boolean> deleteRuleDatasetAliasController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = ruleDatasetAliasService.deleteRuleDatasetAliasService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 规则数据集的别名
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 规则数据集的别名")
    public ApiResult<Boolean> batchDeleteRuleDatasetAliasController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = ruleDatasetAliasService.batchDeleteRuleDatasetAliasService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 规则数据集的别名
     *
     * @param ruleDatasetAliasDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 规则数据集的别名")
    public ApiResult<Boolean> conditionDeleteRuleDatasetAliasController(@Valid @RequestBody RuleDatasetAliasDeleteParam ruleDatasetAliasDeleteParam) throws Exception {
        boolean flag = ruleDatasetAliasService.conditionDeleteRuleDatasetAliasService(ruleDatasetAliasDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 规则数据集的别名
     *
     * @param ruleDatasetAliasVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 规则数据集的别名")
    public ApiResult<Boolean> updateRuleDatasetAliasController(@Valid @RequestBody RuleDatasetAliasVo ruleDatasetAliasVo) throws Exception {
        boolean flag = ruleDatasetAliasService.updateRuleDatasetAliasService(ruleDatasetAliasVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 规则数据集的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 规则数据集的别名 对象")
    public ApiResult<RuleDatasetAliasVo> getRuleDatasetAliasController(@PathVariable(value = "id") String id) throws Exception {
        RuleDatasetAliasVo ruleDatasetAliasVo = ruleDatasetAliasService.getRuleDatasetAliasServiceById(id);
        return ApiResult.ok(ruleDatasetAliasVo);
    }

    /**
     * 获取 规则数据集的别名 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 规则数据集的别名 对象全部列表")
    public ApiResult<List<RuleDatasetAliasVo>> getRuleDatasetAliasControllerAllList() throws Exception {
        List<RuleDatasetAliasVo> ruleDatasetAliasVoList = ruleDatasetAliasService.getRuleDatasetAliasServiceList(new RuleDatasetAliasListParam());
        return ApiResult.ok(ruleDatasetAliasVoList);
    }

    /**
     * 获取 规则数据集的别名 对象列表
     *
     * @param ruleDatasetAliasListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 规则数据集的别名 对象列表")
    public ApiResult<List<RuleDatasetAliasVo>> getRuleDatasetAliasControllerList(@Valid @RequestBody RuleDatasetAliasListParam ruleDatasetAliasListParam) throws Exception {
        List<RuleDatasetAliasVo> ruleDatasetAliasVoList = ruleDatasetAliasService.getRuleDatasetAliasServiceList(ruleDatasetAliasListParam);
        return ApiResult.ok(ruleDatasetAliasVoList);
    }

    /**
     * 获取 规则数据集的别名 分页对象列表
     *
     * @param ruleDatasetAliasPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 规则数据集的别名 分页对象列表")
    public ApiResult<Paging<RuleDatasetAliasVo>> getRuleDatasetAliasControllerPageList(@Valid @RequestBody RuleDatasetAliasPageParam ruleDatasetAliasPageParam) throws Exception {
        Paging<RuleDatasetAliasVo> ruleDatasetAliasVoList = ruleDatasetAliasService.getRuleDatasetAliasServicePageList(ruleDatasetAliasPageParam);
        return ApiResult.ok(ruleDatasetAliasVoList);
    }

    /**
     * 计算 规则数据集的别名 总记录数
     *
     * @param ruleDatasetAliasCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 规则数据集的别名 对象的记录数")
    public ApiResult<Integer> countRuleDatasetAliasController(@Valid @RequestBody RuleDatasetAliasCountParam ruleDatasetAliasCountParam) throws Exception {
        Integer count = ruleDatasetAliasService.countRuleDatasetAliasService(ruleDatasetAliasCountParam);
        return ApiResult.ok(count);
    }


}

