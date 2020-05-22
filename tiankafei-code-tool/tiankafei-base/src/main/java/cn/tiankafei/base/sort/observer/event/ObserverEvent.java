package cn.tiankafei.base.sort.observer.event;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 观察者使用的事件
 *
 * @ClassName ObserverEvent
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class ObserverEvent<T> {

    /**
     * 事件源对象
     */
    private T source;
}
