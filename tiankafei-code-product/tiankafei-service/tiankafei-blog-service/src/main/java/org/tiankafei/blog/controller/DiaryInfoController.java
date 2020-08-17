package org.tiankafei.blog.controller;

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
import org.tiankafei.blog.param.DiaryInfoCheckParam;
import org.tiankafei.blog.param.DiaryInfoCountParam;
import org.tiankafei.blog.param.DiaryInfoDeleteParam;
import org.tiankafei.blog.param.DiaryInfoListParam;
import org.tiankafei.blog.param.DiaryInfoPageParam;
import org.tiankafei.blog.service.DiaryInfoService;
import org.tiankafei.blog.vo.DiaryInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统的博客日记 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/diaryInfo")
@Api(value = "系统的博客日记 API", tags = {"系统的博客日记"})
public class DiaryInfoController extends BaseController {

    @Autowired
    private DiaryInfoService diaryInfoService;

    /**
     * 校验 系统的博客日记 是否已经存在
     *
     * @param diaryInfoCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统的博客日记 对象是否存在")
    public ApiResult<Boolean> checkDiaryInfoControllerExists(@Valid @RequestBody DiaryInfoCheckParam diaryInfoCheckParam) throws Exception {
        Boolean flag = diaryInfoService.checkDiaryInfoServiceExists(diaryInfoCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 系统的博客日记
     *
     * @param diaryInfoVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 系统的博客日记")
    public ApiResult<Long> addDiaryInfoController(@Valid @RequestBody DiaryInfoVo diaryInfoVo) throws Exception {
        Long id = diaryInfoService.addDiaryInfoService(diaryInfoVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 系统的博客日记
     *
     * @param diaryInfoVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统的博客日记")
    public ApiResult<List<Long>> batchAddDiaryInfoController(@Valid @RequestBody List<DiaryInfoVo> diaryInfoVoList) throws Exception {
        List<Long> idList = diaryInfoService.batchAddDiaryInfoService(diaryInfoVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 系统的博客日记
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统的博客日记")
    public ApiResult<Boolean> deleteDiaryInfoController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = diaryInfoService.deleteDiaryInfoService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 系统的博客日记
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统的博客日记")
    public ApiResult<Boolean> batchDeleteDiaryInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = diaryInfoService.batchDeleteDiaryInfoService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 系统的博客日记
     *
     * @param diaryInfoDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统的博客日记")
    public ApiResult<Boolean> conditionDeleteDiaryInfoController(@Valid @RequestBody DiaryInfoDeleteParam diaryInfoDeleteParam) throws Exception {
        boolean flag = diaryInfoService.conditionDeleteDiaryInfoService(diaryInfoDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 系统的博客日记
     *
     * @param diaryInfoVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 系统的博客日记")
    public ApiResult<Boolean> updateDiaryInfoController(@Valid @RequestBody DiaryInfoVo diaryInfoVo) throws Exception {
        boolean flag = diaryInfoService.updateDiaryInfoService(diaryInfoVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 系统的博客日记 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 系统的博客日记 对象")
    public ApiResult<DiaryInfoVo> getDiaryInfoController(@PathVariable(value = "id") String id) throws Exception {
        DiaryInfoVo diaryInfoVo = diaryInfoService.getDiaryInfoServiceById(id);
        return ApiResult.ok(diaryInfoVo);
    }

    /**
     * 获取 系统的博客日记 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 系统的博客日记 对象全部列表")
    public ApiResult<List<DiaryInfoVo>> getDiaryInfoControllerAllList() throws Exception {
        List<DiaryInfoVo> diaryInfoVoList = diaryInfoService.getDiaryInfoServiceList(new DiaryInfoListParam());
        return ApiResult.ok(diaryInfoVoList);
    }

    /**
     * 获取 系统的博客日记 对象列表
     *
     * @param diaryInfoListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统的博客日记 对象列表")
    public ApiResult<List<DiaryInfoVo>> getDiaryInfoControllerList(@Valid @RequestBody DiaryInfoListParam diaryInfoListParam) throws Exception {
        List<DiaryInfoVo> diaryInfoVoList = diaryInfoService.getDiaryInfoServiceList(diaryInfoListParam);
        return ApiResult.ok(diaryInfoVoList);
    }

    /**
     * 获取 系统的博客日记 分页对象列表
     *
     * @param diaryInfoPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统的博客日记 分页对象列表")
    public ApiResult<Paging<DiaryInfoVo>> getDiaryInfoControllerPageList(@Valid @RequestBody DiaryInfoPageParam diaryInfoPageParam) throws Exception {
        Paging<DiaryInfoVo> diaryInfoVoList = diaryInfoService.getDiaryInfoServicePageList(diaryInfoPageParam);
        return ApiResult.ok(diaryInfoVoList);
    }

    /**
     * 计算 系统的博客日记 总记录数
     *
     * @param diaryInfoCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 系统的博客日记 对象的记录数")
    public ApiResult<Integer> countDiaryInfoController(@Valid @RequestBody DiaryInfoCountParam diaryInfoCountParam) throws Exception {
        Integer count = diaryInfoService.countDiaryInfoService(diaryInfoCountParam);
        return ApiResult.ok(count);
    }


}

