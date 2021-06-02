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
import org.tiankafei.rule.param.RuleDataAliasCheckParam;
import org.tiankafei.rule.param.RuleDataAliasCountParam;
import org.tiankafei.rule.param.RuleDataAliasDeleteParam;
import org.tiankafei.rule.param.RuleDataAliasListParam;
import org.tiankafei.rule.param.RuleDataAliasPageParam;
import org.tiankafei.rule.service.RuleDataAliasService;
import org.tiankafei.rule.vo.RuleDataAliasVo;
import org.tiankafei.web.common.param.IdsParam;

/**
 * <p>
 * 规则中用到的数据的别名 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/ruleDataAlias")
@Api(value = "规则中用到的数据的别名 API", tags = {"规则中用到的数据的别名"})
public class RuleDataAliasController extends BaseController {

    @Autowired
    private RuleDataAliasService ruleDataAliasService;

    /**
     * 校验 规则中用到的数据的别名 是否已经存在
     *
     * @param ruleDataAliasCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 规则中用到的数据的别名 对象是否存在")
    public ApiResult<Boolean> checkRuleDataAliasControllerExists(@Valid @RequestBody RuleDataAliasCheckParam ruleDataAliasCheckParam) throws Exception {
        Boolean flag = ruleDataAliasService.checkRuleDataAliasServiceExists(ruleDataAliasCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 规则中用到的数据的别名
     *
     * @param ruleDataAliasVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 规则中用到的数据的别名")
    public ApiResult<Long> addRuleDataAliasController(@Valid @RequestBody RuleDataAliasVo ruleDataAliasVo) throws Exception {
        Long id = ruleDataAliasService.addRuleDataAliasService(ruleDataAliasVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 规则中用到的数据的别名
     *
     * @param ruleDataAliasVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 规则中用到的数据的别名")
    public ApiResult<List<Long>> batchAddRuleDataAliasController(@Valid @RequestBody List<RuleDataAliasVo> ruleDataAliasVoList) throws Exception {
        List<Long> idList = ruleDataAliasService.batchAddRuleDataAliasService(ruleDataAliasVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 规则中用到的数据的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 规则中用到的数据的别名")
    public ApiResult<Boolean> deleteRuleDataAliasController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = ruleDataAliasService.deleteRuleDataAliasService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 规则中用到的数据的别名
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 规则中用到的数据的别名")
    public ApiResult<Boolean> batchDeleteRuleDataAliasController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = ruleDataAliasService.batchDeleteRuleDataAliasService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 规则中用到的数据的别名
     *
     * @param ruleDataAliasDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 规则中用到的数据的别名")
    public ApiResult<Boolean> conditionDeleteRuleDataAliasController(@Valid @RequestBody RuleDataAliasDeleteParam ruleDataAliasDeleteParam) throws Exception {
        boolean flag = ruleDataAliasService.conditionDeleteRuleDataAliasService(ruleDataAliasDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 规则中用到的数据的别名
     *
     * @param ruleDataAliasVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 规则中用到的数据的别名")
    public ApiResult<Boolean> updateRuleDataAliasController(@Valid @RequestBody RuleDataAliasVo ruleDataAliasVo) throws Exception {
        boolean flag = ruleDataAliasService.updateRuleDataAliasService(ruleDataAliasVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 规则中用到的数据的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 规则中用到的数据的别名 对象")
    public ApiResult<RuleDataAliasVo> getRuleDataAliasController(@PathVariable(value = "id") String id) throws Exception {
        RuleDataAliasVo ruleDataAliasVo = ruleDataAliasService.getRuleDataAliasServiceById(id);
        return ApiResult.ok(ruleDataAliasVo);
    }

    /**
     * 获取 规则中用到的数据的别名 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 规则中用到的数据的别名 对象全部列表")
    public ApiResult<List<RuleDataAliasVo>> getRuleDataAliasControllerAllList() throws Exception {
        List<RuleDataAliasVo> ruleDataAliasVoList = ruleDataAliasService.getRuleDataAliasServiceList(new RuleDataAliasListParam());
        return ApiResult.ok(ruleDataAliasVoList);
    }

    /**
     * 获取 规则中用到的数据的别名 对象列表
     *
     * @param ruleDataAliasListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 规则中用到的数据的别名 对象列表")
    public ApiResult<List<RuleDataAliasVo>> getRuleDataAliasControllerList(@Valid @RequestBody RuleDataAliasListParam ruleDataAliasListParam) throws Exception {
        List<RuleDataAliasVo> ruleDataAliasVoList = ruleDataAliasService.getRuleDataAliasServiceList(ruleDataAliasListParam);
        return ApiResult.ok(ruleDataAliasVoList);
    }

    /**
     * 获取 规则中用到的数据的别名 分页对象列表
     *
     * @param ruleDataAliasPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 规则中用到的数据的别名 分页对象列表")
    public ApiResult<Paging<RuleDataAliasVo>> getRuleDataAliasControllerPageList(@Valid @RequestBody RuleDataAliasPageParam ruleDataAliasPageParam) throws Exception {
        Paging<RuleDataAliasVo> ruleDataAliasVoList = ruleDataAliasService.getRuleDataAliasServicePageList(ruleDataAliasPageParam);
        return ApiResult.ok(ruleDataAliasVoList);
    }

    /**
     * 计算 规则中用到的数据的别名 总记录数
     *
     * @param ruleDataAliasCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 规则中用到的数据的别名 对象的记录数")
    public ApiResult<Integer> countRuleDataAliasController(@Valid @RequestBody RuleDataAliasCountParam ruleDataAliasCountParam) throws Exception {
        Integer count = ruleDataAliasService.countRuleDataAliasService(ruleDataAliasCountParam);
        return ApiResult.ok(count);
    }


}

