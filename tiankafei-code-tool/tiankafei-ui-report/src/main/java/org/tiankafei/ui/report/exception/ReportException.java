package org.tiankafei.ui.report.exception;

/**
 * 报表界面异常
 *
 * @author tiankafei
 * @since 1.0
 */
public class ReportException extends Exception {

    public ReportException() {
        super();
    }

    public ReportException(String message) {
        super(message);
    }

    public ReportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReportException(Throwable cause) {
        super(cause);
    }

    protected ReportException(String message, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
