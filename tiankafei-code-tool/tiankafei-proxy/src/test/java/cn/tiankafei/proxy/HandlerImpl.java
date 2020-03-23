package cn.tiankafei.proxy;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class HandlerImpl implements IHandler {

    @Override
    public Object process(String param) {
        return "带有接口的执行处理......" + param;
    }
}
