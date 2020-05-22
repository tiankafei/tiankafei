package cn.tiankafei.base.sort;

import cn.tiankafei.base.sort.proxy.BubbleSortProxy;
import cn.tiankafei.base.sort.proxy.InsertionSortProxy;
import cn.tiankafei.base.sort.proxy.MergeSortProxy;
import cn.tiankafei.base.sort.proxy.QuickSortProxy;
import cn.tiankafei.base.sort.proxy.SelectionSortProxy;
import cn.tiankafei.base.sort.proxy.ShellSortProxy;
import cn.tiankafei.base.sort.proxy.StandSortProxy;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2019/12/2
 * @Version V1.0
 **/
@Slf4j
public class MainProxy implements MainInterface {

    /**
     * 代理模式运行
     */
    @Override
    public void execute() {
        log.info("使用代理模式运行开始=========================================================");
        //声明总代理
        StandSortProxy standSortProxy = new StandSortProxy();
        //添加代理
        standSortProxy.addProxy(new BubbleSortProxy());
        standSortProxy.addProxy(new InsertionSortProxy());
        standSortProxy.addProxy(new MergeSortProxy());
        standSortProxy.addProxy(new QuickSortProxy());
        standSortProxy.addProxy(new SelectionSortProxy());
        standSortProxy.addProxy(new ShellSortProxy());
        standSortProxy.execute();
        log.info("使用代理模式运行结束=========================================================");
    }

}
