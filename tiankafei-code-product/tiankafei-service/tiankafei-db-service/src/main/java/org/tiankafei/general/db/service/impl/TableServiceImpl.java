package org.tiankafei.general.db.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.general.db.entity.TableEntity;
import org.tiankafei.general.db.mapper.TableMapper;
import org.tiankafei.general.db.service.TableService;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TableServiceImpl extends BaseServiceImpl<TableMapper, TableEntity> implements TableService {



}
