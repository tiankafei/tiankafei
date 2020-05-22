package cn.tiankafei.base.sort.proxy;

import cn.tiankafei.base.sort.SortProxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 代理模式：底层使用装饰着模式实现
 * 这是一个总代理
 *
 * @Author 魏双双
 * @Date 2019/12/2
 * @Version V1.0
 **/
public class StandSortProxy {

    private List<SortProxy> proxyList = new ArrayList<>();

    public StandSortProxy addProxy(SortProxy sortProxy) {
        proxyList.add(sortProxy);
        return this;
    }

    public void execute() {
        for (int index = 0, length = proxyList.size(); index < length; index++) {
            proxyList.get(index).execute();
        }
    }

}
