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
import org.tiankafei.rule.param.RuleDesignCheckParam;
import org.tiankafei.rule.param.RuleDesignCountParam;
import org.tiankafei.rule.param.RuleDesignDeleteParam;
import org.tiankafei.rule.param.RuleDesignListParam;
import org.tiankafei.rule.param.RuleDesignPageParam;
import org.tiankafei.rule.service.RuleDesignService;
import org.tiankafei.rule.vo.RuleDesignVo;
import org.tiankafei.web.common.param.IdsParam;

/**
 * <p>
 * 系统规则设计对象 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/ruleDesign")
@Api(value = "系统规则设计对象 API", tags = {"系统规则设计对象"})
public class RuleDesignController extends BaseController {

    @Autowired
    private RuleDesignService ruleDesignService;

    /**
     * 校验 系统规则设计对象 是否已经存在
     *
     * @param ruleDesignCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统规则设计对象 对象是否存在")
    public ApiResult<Boolean> checkRuleDesignControllerExists(@Valid @RequestBody RuleDesignCheckParam ruleDesignCheckParam) throws Exception {
        Boolean flag = ruleDesignService.checkRuleDesignServiceExists(ruleDesignCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 系统规则设计对象
     *
     * @param ruleDesignVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 系统规则设计对象")
    public ApiResult<Long> addRuleDesignController(@Valid @RequestBody RuleDesignVo ruleDesignVo) throws Exception {
        Long id = ruleDesignService.addRuleDesignService(ruleDesignVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 系统规则设计对象
     *
     * @param ruleDesignVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统规则设计对象")
    public ApiResult<List<Long>> batchAddRuleDesignController(@Valid @RequestBody List<RuleDesignVo> ruleDesignVoList) throws Exception {
        List<Long> idList = ruleDesignService.batchAddRuleDesignService(ruleDesignVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 系统规则设计对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统规则设计对象")
    public ApiResult<Boolean> deleteRuleDesignController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = ruleDesignService.deleteRuleDesignService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 系统规则设计对象
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统规则设计对象")
    public ApiResult<Boolean> batchDeleteRuleDesignController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = ruleDesignService.batchDeleteRuleDesignService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 系统规则设计对象
     *
     * @param ruleDesignDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统规则设计对象")
    public ApiResult<Boolean> conditionDeleteRuleDesignController(@Valid @RequestBody RuleDesignDeleteParam ruleDesignDeleteParam) throws Exception {
        boolean flag = ruleDesignService.conditionDeleteRuleDesignService(ruleDesignDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 系统规则设计对象
     *
     * @param ruleDesignVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 系统规则设计对象")
    public ApiResult<Boolean> updateRuleDesignController(@Valid @RequestBody RuleDesignVo ruleDesignVo) throws Exception {
        boolean flag = ruleDesignService.updateRuleDesignService(ruleDesignVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 系统规则设计对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 系统规则设计对象 对象")
    public ApiResult<RuleDesignVo> getRuleDesignController(@PathVariable(value = "id") String id) throws Exception {
        RuleDesignVo ruleDesignVo = ruleDesignService.getRuleDesignServiceById(id);
        return ApiResult.ok(ruleDesignVo);
    }

    /**
     * 获取 系统规则设计对象 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 系统规则设计对象 对象全部列表")
    public ApiResult<List<RuleDesignVo>> getRuleDesignControllerAllList() throws Exception {
        List<RuleDesignVo> ruleDesignVoList = ruleDesignService.getRuleDesignServiceList(new RuleDesignListParam());
        return ApiResult.ok(ruleDesignVoList);
    }

    /**
     * 获取 系统规则设计对象 对象列表
     *
     * @param ruleDesignListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统规则设计对象 对象列表")
    public ApiResult<List<RuleDesignVo>> getRuleDesignControllerList(@Valid @RequestBody RuleDesignListParam ruleDesignListParam) throws Exception {
        List<RuleDesignVo> ruleDesignVoList = ruleDesignService.getRuleDesignServiceList(ruleDesignListParam);
        return ApiResult.ok(ruleDesignVoList);
    }

    /**
     * 获取 系统规则设计对象 分页对象列表
     *
     * @param ruleDesignPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统规则设计对象 分页对象列表")
    public ApiResult<Paging<RuleDesignVo>> getRuleDesignControllerPageList(@Valid @RequestBody RuleDesignPageParam ruleDesignPageParam) throws Exception {
        Paging<RuleDesignVo> ruleDesignVoList = ruleDesignService.getRuleDesignServicePageList(ruleDesignPageParam);
        return ApiResult.ok(ruleDesignVoList);
    }

    /**
     * 计算 系统规则设计对象 总记录数
     *
     * @param ruleDesignCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 系统规则设计对象 对象的记录数")
    public ApiResult<Integer> countRuleDesignController(@Valid @RequestBody RuleDesignCountParam ruleDesignCountParam) throws Exception {
        Integer count = ruleDesignService.countRuleDesignService(ruleDesignCountParam);
        return ApiResult.ok(count);
    }


}

