package org.tiankafei.email.dto;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 身份校验对象
 *
 * @author tiankafei
 */
public class MyAuthenticatorDTO extends Authenticator {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 构建身份校验对象
     */
    public MyAuthenticatorDTO() {

    }

    /**
     * 构建身份校验对象
     *
     * @param username 用户名
     * @param password 密码
     */
    public MyAuthenticatorDTO(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    /**
     * 获取身份校验对象
     */
    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}