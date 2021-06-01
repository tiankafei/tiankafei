package org.tiankafei.rule.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.rule.service.IRuleService;


/**
 * @author tiankafei
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RuleServiceImpl implements IRuleService {
}
