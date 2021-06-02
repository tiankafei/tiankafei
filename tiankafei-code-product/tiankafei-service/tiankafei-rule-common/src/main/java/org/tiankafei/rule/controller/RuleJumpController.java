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
import org.tiankafei.rule.entity.RuleJumpEntity;
import org.tiankafei.rule.param.RuleJumpCheckParam;
import org.tiankafei.rule.param.RuleJumpCountParam;
import org.tiankafei.rule.param.RuleJumpDeleteParam;
import org.tiankafei.rule.param.RuleJumpPageParam;
import org.tiankafei.rule.param.RuleJumpListParam;
import org.tiankafei.rule.service.RuleJumpService;
import org.tiankafei.rule.vo.RuleJumpVo;
import com.ruoyi.common.core.web.domain.ApiResult;
import com.ruoyi.common.core.web.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 跳转规则记录的数据唯一标识 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/ruleJump")
@Api(value = "跳转规则记录的数据唯一标识 API", tags = {"跳转规则记录的数据唯一标识"})
public class RuleJumpController extends BaseController {

    @Autowired
    private RuleJumpService ruleJumpService;

/**
 * 校验 跳转规则记录的数据唯一标识 是否已经存在
 *
 * @param ruleJumpCheckParam
 * @return
 * @throws Exception
 */
	@PostMapping("/check")
	@ApiOperation(value = "校验 跳转规则记录的数据唯一标识 对象是否存在")
	public ApiResult<Boolean> checkRuleJumpControllerExists(@Valid @RequestBody RuleJumpCheckParam ruleJumpCheckParam) throws Exception {
		Boolean flag = ruleJumpService.checkRuleJumpServiceExists(ruleJumpCheckParam);
		return ApiResult.ok(flag);
	}

/**
 * 保存 跳转规则记录的数据唯一标识
 *
 * @param ruleJumpVo
 * @return
 * @throws Exception
 */
	@PostMapping
	@ApiOperation(value = "添加 跳转规则记录的数据唯一标识")
	public ApiResult<Long> addRuleJumpController(@Valid @RequestBody RuleJumpVo ruleJumpVo) throws Exception {
		Long id = ruleJumpService.addRuleJumpService(ruleJumpVo);
		return ApiResult.ok(id);
	}

/**
 * 批量保存 跳转规则记录的数据唯一标识
 *
 * @param ruleJumpVoList
 * @return
 * @throws Exception
 */
	@PostMapping("/batch")
	@ApiOperation(value = "批量添加 跳转规则记录的数据唯一标识")
	public ApiResult<List<Long>> batchAddRuleJumpController(@Valid @RequestBody List<RuleJumpVo> ruleJumpVoList) throws Exception {
		List<Long> idList = ruleJumpService.batchAddRuleJumpService(ruleJumpVoList);
		return ApiResult.ok(idList);
	}

/**
 * 删除 跳转规则记录的数据唯一标识
 *
 * @param id
 * @return
 * @throws Exception
 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除 跳转规则记录的数据唯一标识")
	public ApiResult<Boolean> deleteRuleJumpController(@PathVariable(value = "id") String id) throws Exception {
		boolean flag = ruleJumpService.deleteRuleJumpService(id);
		return ApiResult.ok(flag);
	}

/**
 * 批量删除 跳转规则记录的数据唯一标识
 *
 * @param idsParam
 * @return
 * @throws Exception
 */
	@DeleteMapping("/batch")
	@ApiOperation(value = "批量删除 跳转规则记录的数据唯一标识")
	public ApiResult<Boolean> batchDeleteRuleJumpController(@Valid @RequestBody IdsParam idsParam) throws Exception {
		boolean flag = ruleJumpService.batchDeleteRuleJumpService(idsParam.getIds());
		return ApiResult.ok(flag);
	}

/**
 * 根据条件删除 跳转规则记录的数据唯一标识
 *
 * @param ruleJumpDeleteParam
 * @return
 * @throws Exception
 */
	@DeleteMapping("/condition")
	@ApiOperation(value = "条件删除 跳转规则记录的数据唯一标识")
	public ApiResult<Boolean> conditionDeleteRuleJumpController(@Valid @RequestBody RuleJumpDeleteParam ruleJumpDeleteParam) throws Exception {
		boolean flag = ruleJumpService.conditionDeleteRuleJumpService(ruleJumpDeleteParam);
		return ApiResult.ok(flag);
	}

/**
 * 修改 跳转规则记录的数据唯一标识
 *
 * @param ruleJumpVo
 * @return
 * @throws Exception
 */
	@PatchMapping
	@ApiOperation(value = "修改 跳转规则记录的数据唯一标识")
	public ApiResult<Boolean> updateRuleJumpController(@Valid @RequestBody RuleJumpVo ruleJumpVo) throws Exception {
		boolean flag = ruleJumpService.updateRuleJumpService(ruleJumpVo);
		return ApiResult.ok(flag);
	}

/**
 * 根据ID获取 跳转规则记录的数据唯一标识 对象
 *
 * @param id
 * @return
 * @throws Exception
 */
	@GetMapping("/{id}")
	@ApiOperation(value = "根据ID获取 跳转规则记录的数据唯一标识 对象")
	public ApiResult<RuleJumpVo> getRuleJumpController(@PathVariable(value = "id") String id) throws Exception {
		RuleJumpVo ruleJumpVo = ruleJumpService.getRuleJumpServiceById(id);
		return ApiResult.ok(ruleJumpVo);
	}

/**
 * 获取 跳转规则记录的数据唯一标识 对象列表
 *
 * @return
 * @throws Exception
 */
	@GetMapping
	@ApiOperation(value = "获取 跳转规则记录的数据唯一标识 对象全部列表")
	public ApiResult<List<RuleJumpVo>> getRuleJumpControllerAllList() throws Exception {
		List<RuleJumpVo> ruleJumpVoList = ruleJumpService.getRuleJumpServiceList(new RuleJumpListParam());
		return ApiResult.ok(ruleJumpVoList);
	}

/**
 * 获取 跳转规则记录的数据唯一标识 对象列表
 *
 * @param ruleJumpListParam
 * @return
 * @throws Exception
 */
	@PostMapping("/list")
	@ApiOperation(value = "获取 跳转规则记录的数据唯一标识 对象列表")
	public ApiResult<List<RuleJumpVo>> getRuleJumpControllerList(@Valid @RequestBody RuleJumpListParam ruleJumpListParam) throws Exception {
		List<RuleJumpVo> ruleJumpVoList = ruleJumpService.getRuleJumpServiceList(ruleJumpListParam);
		return ApiResult.ok(ruleJumpVoList);
	}

/**
 * 获取 跳转规则记录的数据唯一标识 分页对象列表
 *
 * @param ruleJumpPageParam
 * @return
 * @throws Exception
 */
	@PostMapping("/pageList")
	@ApiOperation(value = "获取 跳转规则记录的数据唯一标识 分页对象列表")
	public ApiResult<Paging<RuleJumpVo>> getRuleJumpControllerPageList(@Valid @RequestBody RuleJumpPageParam ruleJumpPageParam) throws Exception {
		Paging<RuleJumpVo> ruleJumpVoList = ruleJumpService.getRuleJumpServicePageList(ruleJumpPageParam);
		return ApiResult.ok(ruleJumpVoList);
	}

/**
 * 计算 跳转规则记录的数据唯一标识 总记录数
 *
 * @param ruleJumpCountParam
 * @return
 * @throws Exception
 */
	@PostMapping("/count")
	@ApiOperation(value = "求 跳转规则记录的数据唯一标识 对象的记录数")
	public ApiResult<Integer> countRuleJumpController(@Valid @RequestBody RuleJumpCountParam ruleJumpCountParam) throws Exception {
		Integer count = ruleJumpService.countRuleJumpService(ruleJumpCountParam);
		return ApiResult.ok(count);
	}


}

