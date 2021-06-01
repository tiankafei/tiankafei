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
import org.tiankafei.rule.param.RuleViewCheckParam;
import org.tiankafei.rule.param.RuleViewCountParam;
import org.tiankafei.rule.param.RuleViewDeleteParam;
import org.tiankafei.rule.param.RuleViewListParam;
import org.tiankafei.rule.param.RuleViewPageParam;
import org.tiankafei.rule.service.RuleViewService;
import org.tiankafei.rule.vo.RuleViewVo;
import org.tiankafei.web.common.param.IdsParam;

/**
 * <p>
 * 系统规则设计表达式显示对象 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/ruleView")
@Api(value = "系统规则设计表达式显示对象 API", tags = {"系统规则设计表达式显示对象"})
public class RuleViewController extends BaseController {

    @Autowired
    private RuleViewService ruleViewService;

    /**
     * 校验 系统规则设计表达式显示对象 是否已经存在
     *
     * @param ruleViewCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统规则设计表达式显示对象 对象是否存在")
    public ApiResult<Boolean> checkRuleViewControllerExists(@Valid @RequestBody RuleViewCheckParam ruleViewCheckParam) throws Exception {
        Boolean flag = ruleViewService.checkRuleViewServiceExists(ruleViewCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 系统规则设计表达式显示对象
     *
     * @param ruleViewVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 系统规则设计表达式显示对象")
    public ApiResult<Long> addRuleViewController(@Valid @RequestBody RuleViewVo ruleViewVo) throws Exception {
        Long id = ruleViewService.addRuleViewService(ruleViewVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 系统规则设计表达式显示对象
     *
     * @param ruleViewVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统规则设计表达式显示对象")
    public ApiResult<List<Long>> batchAddRuleViewController(@Valid @RequestBody List<RuleViewVo> ruleViewVoList) throws Exception {
        List<Long> idList = ruleViewService.batchAddRuleViewService(ruleViewVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 系统规则设计表达式显示对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统规则设计表达式显示对象")
    public ApiResult<Boolean> deleteRuleViewController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = ruleViewService.deleteRuleViewService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 系统规则设计表达式显示对象
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统规则设计表达式显示对象")
    public ApiResult<Boolean> batchDeleteRuleViewController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = ruleViewService.batchDeleteRuleViewService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 系统规则设计表达式显示对象
     *
     * @param ruleViewDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统规则设计表达式显示对象")
    public ApiResult<Boolean> conditionDeleteRuleViewController(@Valid @RequestBody RuleViewDeleteParam ruleViewDeleteParam) throws Exception {
        boolean flag = ruleViewService.conditionDeleteRuleViewService(ruleViewDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 系统规则设计表达式显示对象
     *
     * @param ruleViewVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 系统规则设计表达式显示对象")
    public ApiResult<Boolean> updateRuleViewController(@Valid @RequestBody RuleViewVo ruleViewVo) throws Exception {
        boolean flag = ruleViewService.updateRuleViewService(ruleViewVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 系统规则设计表达式显示对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 系统规则设计表达式显示对象 对象")
    public ApiResult<RuleViewVo> getRuleViewController(@PathVariable(value = "id") String id) throws Exception {
        RuleViewVo ruleViewVo = ruleViewService.getRuleViewServiceById(id);
        return ApiResult.ok(ruleViewVo);
    }

    /**
     * 获取 系统规则设计表达式显示对象 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 系统规则设计表达式显示对象 对象全部列表")
    public ApiResult<List<RuleViewVo>> getRuleViewControllerAllList() throws Exception {
        List<RuleViewVo> ruleViewVoList = ruleViewService.getRuleViewServiceList(new RuleViewListParam());
        return ApiResult.ok(ruleViewVoList);
    }

    /**
     * 获取 系统规则设计表达式显示对象 对象列表
     *
     * @param ruleViewListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统规则设计表达式显示对象 对象列表")
    public ApiResult<List<RuleViewVo>> getRuleViewControllerList(@Valid @RequestBody RuleViewListParam ruleViewListParam) throws Exception {
        List<RuleViewVo> ruleViewVoList = ruleViewService.getRuleViewServiceList(ruleViewListParam);
        return ApiResult.ok(ruleViewVoList);
    }

    /**
     * 获取 系统规则设计表达式显示对象 分页对象列表
     *
     * @param ruleViewPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统规则设计表达式显示对象 分页对象列表")
    public ApiResult<Paging<RuleViewVo>> getRuleViewControllerPageList(@Valid @RequestBody RuleViewPageParam ruleViewPageParam) throws Exception {
        Paging<RuleViewVo> ruleViewVoList = ruleViewService.getRuleViewServicePageList(ruleViewPageParam);
        return ApiResult.ok(ruleViewVoList);
    }

    /**
     * 计算 系统规则设计表达式显示对象 总记录数
     *
     * @param ruleViewCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 系统规则设计表达式显示对象 对象的记录数")
    public ApiResult<Integer> countRuleViewController(@Valid @RequestBody RuleViewCountParam ruleViewCountParam) throws Exception {
        Integer count = ruleViewService.countRuleViewService(ruleViewCountParam);
        return ApiResult.ok(count);
    }


}

