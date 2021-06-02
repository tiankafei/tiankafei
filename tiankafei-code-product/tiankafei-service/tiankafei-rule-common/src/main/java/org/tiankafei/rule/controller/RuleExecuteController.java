package org.tiankafei.rule.controller;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.rule.entity.RuleExecuteEntity;
import org.tiankafei.rule.param.RuleExecuteCheckParam;
import org.tiankafei.rule.param.RuleExecuteCountParam;
import org.tiankafei.rule.param.RuleExecuteDeleteParam;
import org.tiankafei.rule.param.RuleExecutePageParam;
import org.tiankafei.rule.param.RuleExecuteListParam;
import org.tiankafei.rule.service.RuleExecuteService;
import org.tiankafei.rule.vo.RuleExecuteVo;
import com.ruoyi.common.core.web.domain.ApiResult;
import com.ruoyi.common.core.web.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 规则设计执行的对象 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/ruleExecute")
@Api(value = "规则设计执行的对象 API", tags = {"规则设计执行的对象"})
public class RuleExecuteController extends BaseController {

    @Autowired
    private RuleExecuteService ruleExecuteService;

/**
 * 校验 规则设计执行的对象 是否已经存在
 *
 * @param ruleExecuteCheckParam
 * @return
 * @throws Exception
 */
	@PostMapping("/check")
	@ApiOperation(value = "校验 规则设计执行的对象 对象是否存在")
	public ApiResult<Boolean> checkRuleExecuteControllerExists(@Valid @RequestBody RuleExecuteCheckParam ruleExecuteCheckParam) throws Exception {
		Boolean flag = ruleExecuteService.checkRuleExecuteServiceExists(ruleExecuteCheckParam);
		return ApiResult.ok(flag);
	}

/**
 * 保存 规则设计执行的对象
 *
 * @param ruleExecuteVo
 * @return
 * @throws Exception
 */
	@PostMapping
	@ApiOperation(value = "添加 规则设计执行的对象")
	public ApiResult<Long> addRuleExecuteController(@Valid @RequestBody RuleExecuteVo ruleExecuteVo) throws Exception {
		Long id = ruleExecuteService.addRuleExecuteService(ruleExecuteVo);
		return ApiResult.ok(id);
	}

/**
 * 批量保存 规则设计执行的对象
 *
 * @param ruleExecuteVoList
 * @return
 * @throws Exception
 */
	@PostMapping("/batch")
	@ApiOperation(value = "批量添加 规则设计执行的对象")
	public ApiResult<List<Long>> batchAddRuleExecuteController(@Valid @RequestBody List<RuleExecuteVo> ruleExecuteVoList) throws Exception {
		List<Long> idList = ruleExecuteService.batchAddRuleExecuteService(ruleExecuteVoList);
		return ApiResult.ok(idList);
	}

/**
 * 删除 规则设计执行的对象
 *
 * @param id
 * @return
 * @throws Exception
 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除 规则设计执行的对象")
	public ApiResult<Boolean> deleteRuleExecuteController(@PathVariable(value = "id") String id) throws Exception {
		boolean flag = ruleExecuteService.deleteRuleExecuteService(id);
		return ApiResult.ok(flag);
	}

/**
 * 批量删除 规则设计执行的对象
 *
 * @param idsParam
 * @return
 * @throws Exception
 */
	@DeleteMapping("/batch")
	@ApiOperation(value = "批量删除 规则设计执行的对象")
	public ApiResult<Boolean> batchDeleteRuleExecuteController(@Valid @RequestBody IdsParam idsParam) throws Exception {
		boolean flag = ruleExecuteService.batchDeleteRuleExecuteService(idsParam.getIds());
		return ApiResult.ok(flag);
	}

/**
 * 根据条件删除 规则设计执行的对象
 *
 * @param ruleExecuteDeleteParam
 * @return
 * @throws Exception
 */
	@DeleteMapping("/condition")
	@ApiOperation(value = "条件删除 规则设计执行的对象")
	public ApiResult<Boolean> conditionDeleteRuleExecuteController(@Valid @RequestBody RuleExecuteDeleteParam ruleExecuteDeleteParam) throws Exception {
		boolean flag = ruleExecuteService.conditionDeleteRuleExecuteService(ruleExecuteDeleteParam);
		return ApiResult.ok(flag);
	}

/**
 * 修改 规则设计执行的对象
 *
 * @param ruleExecuteVo
 * @return
 * @throws Exception
 */
	@PatchMapping
	@ApiOperation(value = "修改 规则设计执行的对象")
	public ApiResult<Boolean> updateRuleExecuteController(@Valid @RequestBody RuleExecuteVo ruleExecuteVo) throws Exception {
		boolean flag = ruleExecuteService.updateRuleExecuteService(ruleExecuteVo);
		return ApiResult.ok(flag);
	}

/**
 * 根据ID获取 规则设计执行的对象 对象
 *
 * @param id
 * @return
 * @throws Exception
 */
	@GetMapping("/{id}")
	@ApiOperation(value = "根据ID获取 规则设计执行的对象 对象")
	public ApiResult<RuleExecuteVo> getRuleExecuteController(@PathVariable(value = "id") String id) throws Exception {
		RuleExecuteVo ruleExecuteVo = ruleExecuteService.getRuleExecuteServiceById(id);
		return ApiResult.ok(ruleExecuteVo);
	}

/**
 * 获取 规则设计执行的对象 对象列表
 *
 * @return
 * @throws Exception
 */
	@GetMapping
	@ApiOperation(value = "获取 规则设计执行的对象 对象全部列表")
	public ApiResult<List<RuleExecuteVo>> getRuleExecuteControllerAllList() throws Exception {
		List<RuleExecuteVo> ruleExecuteVoList = ruleExecuteService.getRuleExecuteServiceList(new RuleExecuteListParam());
		return ApiResult.ok(ruleExecuteVoList);
	}

/**
 * 获取 规则设计执行的对象 对象列表
 *
 * @param ruleExecuteListParam
 * @return
 * @throws Exception
 */
	@PostMapping("/list")
	@ApiOperation(value = "获取 规则设计执行的对象 对象列表")
	public ApiResult<List<RuleExecuteVo>> getRuleExecuteControllerList(@Valid @RequestBody RuleExecuteListParam ruleExecuteListParam) throws Exception {
		List<RuleExecuteVo> ruleExecuteVoList = ruleExecuteService.getRuleExecuteServiceList(ruleExecuteListParam);
		return ApiResult.ok(ruleExecuteVoList);
	}

/**
 * 获取 规则设计执行的对象 分页对象列表
 *
 * @param ruleExecutePageParam
 * @return
 * @throws Exception
 */
	@PostMapping("/pageList")
	@ApiOperation(value = "获取 规则设计执行的对象 分页对象列表")
	public ApiResult<Paging<RuleExecuteVo>> getRuleExecuteControllerPageList(@Valid @RequestBody RuleExecutePageParam ruleExecutePageParam) throws Exception {
		Paging<RuleExecuteVo> ruleExecuteVoList = ruleExecuteService.getRuleExecuteServicePageList(ruleExecutePageParam);
		return ApiResult.ok(ruleExecuteVoList);
	}

/**
 * 计算 规则设计执行的对象 总记录数
 *
 * @param ruleExecuteCountParam
 * @return
 * @throws Exception
 */
	@PostMapping("/count")
	@ApiOperation(value = "求 规则设计执行的对象 对象的记录数")
	public ApiResult<Integer> countRuleExecuteController(@Valid @RequestBody RuleExecuteCountParam ruleExecuteCountParam) throws Exception {
		Integer count = ruleExecuteService.countRuleExecuteService(ruleExecuteCountParam);
		return ApiResult.ok(count);
	}


}

