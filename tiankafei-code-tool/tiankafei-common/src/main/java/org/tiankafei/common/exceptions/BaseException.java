package org.tiankafei.common.exceptions;

import org.apache.commons.lang3.StringUtils;

/**
 * 基础异常类
 *
 * @author tiankafei
 * @since 1.0
 **/
public class BaseException extends Exception {

    private static final long serialVersionUID = -1426467267319901929L;

    /**
     * 异常消息
     */
    private String message;

    private static final String MESSAGE_MESSAGE = "系统出现错误！";

    /**
     * 构造异常类对象
     */
    public BaseException() {
        super(MESSAGE_MESSAGE);
    }

    /**
     * 构造异常类对象
     *
     * @param message 异常消息
     */
    public BaseException(String message) {
        super(message);
        if (StringUtils.isEmpty(message)) {
            message = MESSAGE_MESSAGE;
        }
        this.message = message;
    }

    /**
     * 构造异常类对象
     *
     * @param message   异常消息
     * @param throwable 抛出的异常
     */
    public BaseException(String message, Throwable throwable) {
        super(message, throwable);
        if (StringUtils.isEmpty(message)) {
            message = MESSAGE_MESSAGE;
        }
        this.message = message;
    }

    /**
     * 获取异常消息
     */
    @Override
    public String getMessage() {
        return message;
    }

}
