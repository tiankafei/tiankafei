package org.tiankafei.ui.jface.exception;

/**
 * UI界面异常
 *
 * @author tiankafei
 * @since 1.0
 */
public class JfaceException extends Exception {

    public JfaceException() {
        super();
    }

    public JfaceException(String message) {
        super(message);
    }

    public JfaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public JfaceException(Throwable cause) {
        super(cause);
    }

    protected JfaceException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
