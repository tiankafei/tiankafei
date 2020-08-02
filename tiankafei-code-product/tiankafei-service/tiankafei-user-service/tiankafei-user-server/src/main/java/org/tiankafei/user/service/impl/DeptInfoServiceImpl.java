package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.DeptInfoEntity;
import org.tiankafei.user.mapper.DeptInfoMapper;
import org.tiankafei.user.param.DeptInfoListParam;
import org.tiankafei.user.param.DeptInfoPageParam;
import org.tiankafei.user.service.DeptInfoService;
import org.tiankafei.user.vo.DeptInfoVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

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
public class DeptInfoServiceImpl extends BaseServiceImpl<DeptInfoMapper, DeptInfoEntity> implements DeptInfoService {

    @Autowired
    private DeptInfoMapper deptInfoMapper;

    @Override
    public boolean checkSysDepartmentExists(DeptInfoListParam deptInfoListParam) throws Exception {
        LambdaQueryWrapper<DeptInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysDepartment(DeptInfoVo deptInfoVo) throws Exception {
        DeptInfoEntity deptInfoEntity = new DeptInfoEntity();
        BeanUtils.copyProperties(deptInfoVo, deptInfoEntity);
        super.save(deptInfoEntity);
        return deptInfoEntity.getId();
    }

    @Override
    public boolean addSysDepartmentList(List<DeptInfoVo> deptInfoVoList) throws Exception {
        if (deptInfoVoList != null && !deptInfoVoList.isEmpty()) {
            List<DeptInfoEntity> sysDepartmentList = new ArrayList<>();
            for (DeptInfoVo deptInfoVo : deptInfoVoList) {
                DeptInfoEntity deptInfoEntity = new DeptInfoEntity();
                BeanUtils.copyProperties(deptInfoVo, deptInfoEntity);
                sysDepartmentList.add(deptInfoEntity);
            }
            super.saveBatch(sysDepartmentList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysDepartment(DeptInfoVo deptInfoVo) throws Exception {
        DeptInfoEntity deptInfoEntity = new DeptInfoEntity();
        BeanUtils.copyProperties(deptInfoVo, deptInfoEntity);
        return super.updateById(deptInfoEntity);
    }

    @Override
    public boolean deleteSysDepartment(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysDepartment(DeptInfoListParam deptInfoListParam) throws Exception {
        LambdaQueryWrapper<DeptInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public DeptInfoVo getSysDepartmentById(Serializable id) throws Exception {
        //SysDepartmentQueryVo sysDepartmentQueryVo = sysDepartmentMapper.getSysDepartmentById(id);

        DeptInfoEntity deptInfoEntity = super.getById(id);
        DeptInfoVo deptInfoVo = new DeptInfoVo();
        BeanUtils.copyProperties(deptInfoEntity, deptInfoVo);
        return deptInfoVo;
    }

    @Override
    public Paging<DeptInfoVo> getSysDepartmentPageList(DeptInfoPageParam deptInfoPageParam) throws Exception {
        //IPage<SysDepartmentQueryVo> iPage = sysDepartmentMapper.getSysDepartmentPageList(page, sysDepartmentPageQueryParam);

        Page page = setPageParam(deptInfoPageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<DeptInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<DeptInfoVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<DeptInfoVo> getSysDepartmentList(DeptInfoListParam deptInfoListParam) throws Exception {
        List<DeptInfoVo> deptInfoVoList = deptInfoMapper.getSysDepartmentList(deptInfoListParam);
        return deptInfoVoList;
    }

    @Override
    public int countSysDepartment(DeptInfoListParam deptInfoListParam) throws Exception {
        LambdaQueryWrapper<DeptInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}