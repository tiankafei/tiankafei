package cn.tiankafei.springmvc.exception;

/**
 * @Author 魏双双
 * @Date 2020/5/19
 * @Version V1.0
 **/
public class ValidationException extends Exception {

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

}
