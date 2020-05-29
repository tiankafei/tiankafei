package cn.tiankafei.aviator.extend.exception;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class AviatorException extends Throwable {

    public AviatorException() {
        super();
    }

    public AviatorException(String message) {
        super(message);
    }

    public AviatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AviatorException(Throwable cause) {
        super(cause);
    }

    protected AviatorException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
