package org.tiankafei.ui.design.exception;

/**
 * UI界面异常
 *
 * @author tiankafei
 * @since 1.0
 */
public class DesignException extends Exception {

    public DesignException() {
        super();
    }

    public DesignException(String message) {
        super(message);
    }

    public DesignException(String message, Throwable cause) {
        super(message, cause);
    }

    public DesignException(Throwable cause) {
        super(cause);
    }

    protected DesignException(String message, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
