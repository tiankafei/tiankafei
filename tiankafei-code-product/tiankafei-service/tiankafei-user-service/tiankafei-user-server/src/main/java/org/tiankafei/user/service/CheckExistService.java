package org.tiankafei.user.service;

import org.apache.commons.lang3.StringUtils;
import org.tiankafei.web.common.exception.UserException;

/**
 * @author tiankafei
 * @since 1.0
 */
public interface CheckExistService {

    /**
     * 新增时验证系统用户是否存在
     *
     * @param keywords
     * @return
     * @throws UserException
     */
    Boolean checkAddSysUserExists(String keywords) throws UserException;

    /**
     * 编辑时验证系统用户是否存在
     *
     * @param keywords
     * @param oldKeywords
     * @return
     * @throws UserException
     */
    default Boolean checkUpdateSysUserExists(String keywords, String oldKeywords) throws UserException {
        boolean emailChangeFlag = Boolean.FALSE;
        if (StringUtils.isNotEmpty(oldKeywords)) {
            emailChangeFlag = !oldKeywords.equals(keywords);
        } else if (StringUtils.isNotEmpty(keywords)) {
            emailChangeFlag = !keywords.equals(oldKeywords);
        }
        if (emailChangeFlag) {
            return checkAddSysUserExists(keywords);
        }
        return Boolean.FALSE;
    }

    /**
     * 获取用户标识，
     *
     * @return
     */
    Integer getUserFlag();

}
