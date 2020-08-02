package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.DeptInfoEntity;
import org.tiankafei.user.mapper.DeptInfoMapper;
import org.tiankafei.user.param.DeptInfoCheckParam;
import org.tiankafei.user.param.DeptInfoCountParam;
import org.tiankafei.user.param.DeptInfoDeleteParam;
import org.tiankafei.user.param.DeptInfoListParam;
import org.tiankafei.user.param.DeptInfoPageParam;
import org.tiankafei.user.service.DeptInfoService;
import org.tiankafei.user.vo.DeptInfoVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统部门表信息 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class DeptInfoServiceImpl extends BaseServiceImpl<DeptInfoMapper, DeptInfoEntity> implements DeptInfoService {

    @Autowired
    private DeptInfoMapper deptInfoMapper;


    /**
     * 校验 系统部门表信息 是否已经存在
     *
     * @param deptInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkDeptInfoServiceExists(DeptInfoCheckParam deptInfoCheckParam) throws Exception {
        LambdaQueryWrapper<DeptInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (deptInfoCheckParam != null) {

        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统部门表信息
     *
     * @param deptInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addDeptInfoService(DeptInfoVo deptInfoVo) throws Exception {
        DeptInfoEntity deptInfoEntity = new DeptInfoEntity();
        BeanUtils.copyProperties(deptInfoVo, deptInfoEntity);
        super.save(deptInfoEntity);
        return deptInfoEntity.getId();
    }

    /**
     * 保存 系统部门表信息 集合
     *
     * @param deptInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddDeptInfoService(List<DeptInfoVo> deptInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(deptInfoVoList)) {
            List<DeptInfoEntity> deptInfoEntityList = Lists.newArrayList();
            for (DeptInfoVo deptInfoVo : deptInfoVoList) {
                DeptInfoEntity deptInfoEntity = new DeptInfoEntity();
                BeanUtils.copyProperties(deptInfoVo, deptInfoEntity);
                deptInfoEntityList.add(deptInfoEntity);
            }
            super.saveBatch(deptInfoEntityList);

            return deptInfoEntityList.stream().map(deptInfoEntity -> deptInfoEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统部门表信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteDeptInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 删除 系统部门表信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteDeptInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统部门表信息
     *
     * @param deptInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteDeptInfoService(DeptInfoDeleteParam deptInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<DeptInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (deptInfoDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统部门表信息
     *
     * @param deptInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateDeptInfoService(DeptInfoVo deptInfoVo) throws Exception {
        DeptInfoEntity deptInfoEntity = new DeptInfoEntity();
        BeanUtils.copyProperties(deptInfoVo, deptInfoEntity);
        return super.updateById(deptInfoEntity);
    }

    /**
     * 根据ID获取 系统部门表信息 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public DeptInfoVo getDeptInfoServiceById(Serializable id) throws Exception {
        DeptInfoEntity deptInfoEntity = super.getById(id);
        DeptInfoVo deptInfoVo = new DeptInfoVo();
        BeanUtils.copyProperties(deptInfoEntity, deptInfoVo);
        return deptInfoVo;
    }

    /**
     * 获取 系统部门表信息 对象列表
     *
     * @param deptInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<DeptInfoVo> getDeptInfoServiceList(DeptInfoListParam deptInfoListParam) throws Exception {
        return deptInfoMapper.getDeptInfoServiceList(deptInfoListParam);
    }

    /**
     * 获取 系统部门表信息 分页对象列表
     *
     * @param deptInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<DeptInfoVo> getDeptInfoServicePageList(DeptInfoPageParam deptInfoPageParam) throws Exception {
        Page page = setPageParam(deptInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<DeptInfoVo> iPage = deptInfoMapper.getDeptInfoServicePageList(page, deptInfoPageParam);
        List<Long> idList = iPage.getRecords().stream().map(deptInfoVo -> deptInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<DeptInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            DeptInfoListParam deptInfoListParam = new DeptInfoListParam();
            deptInfoListParam.setIdList(idList);
            List<DeptInfoVo> deptInfoVoList = this.getDeptInfoServiceList(deptInfoListParam);
            paging.setRecords(deptInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 系统部门表信息 总记录数
     *
     * @param deptInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countDeptInfoService(DeptInfoCountParam deptInfoCountParam) throws Exception {
        LambdaQueryWrapper<DeptInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (deptInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
