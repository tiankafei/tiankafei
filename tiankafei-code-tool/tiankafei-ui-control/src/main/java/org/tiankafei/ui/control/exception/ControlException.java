package org.tiankafei.ui.control.exception;

/**
 * 组件界面异常
 *
 * @author tiankafei
 * @since 1.0
 */
public class ControlException extends Exception {

    public ControlException() {
        super();
    }

    public ControlException(String message) {
        super(message);
    }

    public ControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControlException(Throwable cause) {
        super(cause);
    }

    protected ControlException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
