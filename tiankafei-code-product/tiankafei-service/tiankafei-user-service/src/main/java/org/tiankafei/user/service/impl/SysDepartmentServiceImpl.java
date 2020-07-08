package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.SysDepartmentEntity;
import org.tiankafei.user.mapper.SysDepartmentMapper;
import org.tiankafei.user.param.SysDepartmentPageQueryParam;
import org.tiankafei.user.param.SysDepartmentQueryParam;
import org.tiankafei.user.service.SysDepartmentService;
import org.tiankafei.user.vo.SysDepartmentQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 系统部门表信息 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysDepartmentServiceImpl extends BaseServiceImpl<SysDepartmentMapper, SysDepartmentEntity> implements SysDepartmentService {

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public boolean checkSysDepartmentExists(SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception {
        LambdaQueryWrapper<SysDepartmentEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysDepartment(SysDepartmentQueryVo sysDepartmentQueryVo) throws Exception {
        SysDepartmentEntity sysDepartmentEntity = new SysDepartmentEntity();
        BeanUtils.copyProperties(sysDepartmentQueryVo, sysDepartmentEntity);
        super.save(sysDepartmentEntity);
        return sysDepartmentEntity.getId();
    }

    @Override
    public boolean addSysDepartmentList(List<SysDepartmentQueryVo> sysDepartmentQueryVoList) throws Exception {
        if (sysDepartmentQueryVoList != null && !sysDepartmentQueryVoList.isEmpty()) {
            List<SysDepartmentEntity> sysDepartmentList = new ArrayList<>();
            for (SysDepartmentQueryVo sysDepartmentQueryVo : sysDepartmentQueryVoList) {
                SysDepartmentEntity sysDepartmentEntity = new SysDepartmentEntity();
                BeanUtils.copyProperties(sysDepartmentQueryVo, sysDepartmentEntity);
                sysDepartmentList.add(sysDepartmentEntity);
            }
            super.saveBatch(sysDepartmentList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysDepartment(SysDepartmentQueryVo sysDepartmentQueryVo) throws Exception {
        SysDepartmentEntity sysDepartmentEntity = new SysDepartmentEntity();
        BeanUtils.copyProperties(sysDepartmentQueryVo, sysDepartmentEntity);
        return super.updateById(sysDepartmentEntity);
    }

    @Override
    public boolean deleteSysDepartment(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysDepartment(SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception {
        LambdaQueryWrapper<SysDepartmentEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysDepartmentQueryVo getSysDepartmentById(Serializable id) throws Exception {
        SysDepartmentEntity sysDepartmentEntity = super.getById(id);
        SysDepartmentQueryVo sysDepartmentQueryVo = new SysDepartmentQueryVo();
        BeanUtils.copyProperties(sysDepartmentEntity, sysDepartmentQueryVo);
        return sysDepartmentQueryVo;
    }

    @Override
    public Paging<SysDepartmentQueryVo> getSysDepartmentPageList(SysDepartmentPageQueryParam sysDepartmentPageQueryParam) throws Exception {
        Page page = setPageParam(sysDepartmentPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysDepartmentEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysDepartmentQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysDepartmentQueryVo> getSysDepartmentList(SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception {
        List<SysDepartmentQueryVo> sysDepartmentQueryVoList = sysDepartmentMapper.getSysDepartmentList(sysDepartmentQueryParam);
        return sysDepartmentQueryVoList;
    }

    @Override
    public int countSysDepartment(SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception {
        LambdaQueryWrapper<SysDepartmentEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}