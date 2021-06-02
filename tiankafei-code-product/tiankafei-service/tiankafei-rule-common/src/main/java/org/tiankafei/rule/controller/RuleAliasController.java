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
import org.tiankafei.rule.entity.RuleAliasEntity;
import org.tiankafei.rule.param.RuleAliasCheckParam;
import org.tiankafei.rule.param.RuleAliasCountParam;
import org.tiankafei.rule.param.RuleAliasDeleteParam;
import org.tiankafei.rule.param.RuleAliasPageParam;
import org.tiankafei.rule.param.RuleAliasListParam;
import org.tiankafei.rule.service.RuleAliasService;
import org.tiankafei.rule.vo.RuleAliasVo;
import com.ruoyi.common.core.web.domain.ApiResult;
import com.ruoyi.common.core.web.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 规则的别名 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/ruleAlias")
@Api(value = "规则的别名 API", tags = {"规则的别名"})
public class RuleAliasController extends BaseController {

    @Autowired
    private RuleAliasService ruleAliasService;

/**
 * 校验 规则的别名 是否已经存在
 *
 * @param ruleAliasCheckParam
 * @return
 * @throws Exception
 */
	@PostMapping("/check")
	@ApiOperation(value = "校验 规则的别名 对象是否存在")
	public ApiResult<Boolean> checkRuleAliasControllerExists(@Valid @RequestBody RuleAliasCheckParam ruleAliasCheckParam) throws Exception {
		Boolean flag = ruleAliasService.checkRuleAliasServiceExists(ruleAliasCheckParam);
		return ApiResult.ok(flag);
	}

/**
 * 保存 规则的别名
 *
 * @param ruleAliasVo
 * @return
 * @throws Exception
 */
	@PostMapping
	@ApiOperation(value = "添加 规则的别名")
	public ApiResult<Long> addRuleAliasController(@Valid @RequestBody RuleAliasVo ruleAliasVo) throws Exception {
		Long id = ruleAliasService.addRuleAliasService(ruleAliasVo);
		return ApiResult.ok(id);
	}

/**
 * 批量保存 规则的别名
 *
 * @param ruleAliasVoList
 * @return
 * @throws Exception
 */
	@PostMapping("/batch")
	@ApiOperation(value = "批量添加 规则的别名")
	public ApiResult<List<Long>> batchAddRuleAliasController(@Valid @RequestBody List<RuleAliasVo> ruleAliasVoList) throws Exception {
		List<Long> idList = ruleAliasService.batchAddRuleAliasService(ruleAliasVoList);
		return ApiResult.ok(idList);
	}

/**
 * 删除 规则的别名
 *
 * @param id
 * @return
 * @throws Exception
 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除 规则的别名")
	public ApiResult<Boolean> deleteRuleAliasController(@PathVariable(value = "id") String id) throws Exception {
		boolean flag = ruleAliasService.deleteRuleAliasService(id);
		return ApiResult.ok(flag);
	}

/**
 * 批量删除 规则的别名
 *
 * @param idsParam
 * @return
 * @throws Exception
 */
	@DeleteMapping("/batch")
	@ApiOperation(value = "批量删除 规则的别名")
	public ApiResult<Boolean> batchDeleteRuleAliasController(@Valid @RequestBody IdsParam idsParam) throws Exception {
		boolean flag = ruleAliasService.batchDeleteRuleAliasService(idsParam.getIds());
		return ApiResult.ok(flag);
	}

/**
 * 根据条件删除 规则的别名
 *
 * @param ruleAliasDeleteParam
 * @return
 * @throws Exception
 */
	@DeleteMapping("/condition")
	@ApiOperation(value = "条件删除 规则的别名")
	public ApiResult<Boolean> conditionDeleteRuleAliasController(@Valid @RequestBody RuleAliasDeleteParam ruleAliasDeleteParam) throws Exception {
		boolean flag = ruleAliasService.conditionDeleteRuleAliasService(ruleAliasDeleteParam);
		return ApiResult.ok(flag);
	}

/**
 * 修改 规则的别名
 *
 * @param ruleAliasVo
 * @return
 * @throws Exception
 */
	@PatchMapping
	@ApiOperation(value = "修改 规则的别名")
	public ApiResult<Boolean> updateRuleAliasController(@Valid @RequestBody RuleAliasVo ruleAliasVo) throws Exception {
		boolean flag = ruleAliasService.updateRuleAliasService(ruleAliasVo);
		return ApiResult.ok(flag);
	}

/**
 * 根据ID获取 规则的别名 对象
 *
 * @param id
 * @return
 * @throws Exception
 */
	@GetMapping("/{id}")
	@ApiOperation(value = "根据ID获取 规则的别名 对象")
	public ApiResult<RuleAliasVo> getRuleAliasController(@PathVariable(value = "id") String id) throws Exception {
		RuleAliasVo ruleAliasVo = ruleAliasService.getRuleAliasServiceById(id);
		return ApiResult.ok(ruleAliasVo);
	}

/**
 * 获取 规则的别名 对象列表
 *
 * @return
 * @throws Exception
 */
	@GetMapping
	@ApiOperation(value = "获取 规则的别名 对象全部列表")
	public ApiResult<List<RuleAliasVo>> getRuleAliasControllerAllList() throws Exception {
		List<RuleAliasVo> ruleAliasVoList = ruleAliasService.getRuleAliasServiceList(new RuleAliasListParam());
		return ApiResult.ok(ruleAliasVoList);
	}

/**
 * 获取 规则的别名 对象列表
 *
 * @param ruleAliasListParam
 * @return
 * @throws Exception
 */
	@PostMapping("/list")
	@ApiOperation(value = "获取 规则的别名 对象列表")
	public ApiResult<List<RuleAliasVo>> getRuleAliasControllerList(@Valid @RequestBody RuleAliasListParam ruleAliasListParam) throws Exception {
		List<RuleAliasVo> ruleAliasVoList = ruleAliasService.getRuleAliasServiceList(ruleAliasListParam);
		return ApiResult.ok(ruleAliasVoList);
	}

/**
 * 获取 规则的别名 分页对象列表
 *
 * @param ruleAliasPageParam
 * @return
 * @throws Exception
 */
	@PostMapping("/pageList")
	@ApiOperation(value = "获取 规则的别名 分页对象列表")
	public ApiResult<Paging<RuleAliasVo>> getRuleAliasControllerPageList(@Valid @RequestBody RuleAliasPageParam ruleAliasPageParam) throws Exception {
		Paging<RuleAliasVo> ruleAliasVoList = ruleAliasService.getRuleAliasServicePageList(ruleAliasPageParam);
		return ApiResult.ok(ruleAliasVoList);
	}

/**
 * 计算 规则的别名 总记录数
 *
 * @param ruleAliasCountParam
 * @return
 * @throws Exception
 */
	@PostMapping("/count")
	@ApiOperation(value = "求 规则的别名 对象的记录数")
	public ApiResult<Integer> countRuleAliasController(@Valid @RequestBody RuleAliasCountParam ruleAliasCountParam) throws Exception {
		Integer count = ruleAliasService.countRuleAliasService(ruleAliasCountParam);
		return ApiResult.ok(count);
	}


}

