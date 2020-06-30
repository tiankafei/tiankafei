package org.tiankafei.user.service;

/**
 * 验证用户属性是否存在
 * @author tiankafei
 */
@FunctionalInterface
public interface CheckUserInfoExists {

    /**
     * 校验用户属性是否已经存在
     * @param str
     * @return
     * @throws Exception
     */
    boolean checkUserInfoExists(String str) throws Exception;

}
