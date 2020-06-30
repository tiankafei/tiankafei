package org.tiankafei.general.db.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.general.db.entity.FieldEntity;
import org.tiankafei.general.db.mapper.FieldMapper;
import org.tiankafei.general.db.service.FieldService;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class FieldServiceImpl extends BaseServiceImpl<FieldMapper, FieldEntity> implements FieldService {



}
