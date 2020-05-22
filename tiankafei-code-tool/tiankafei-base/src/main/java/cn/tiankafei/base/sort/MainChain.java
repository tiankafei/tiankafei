package cn.tiankafei.base.sort;

import cn.tiankafei.base.sort.chain.BubbleSortChain;
import cn.tiankafei.base.sort.chain.InsertionSortChain;
import cn.tiankafei.base.sort.chain.MergeSortChain;
import cn.tiankafei.base.sort.chain.QuickSortChain;
import cn.tiankafei.base.sort.chain.SelectionSortChain;
import cn.tiankafei.base.sort.chain.ShellSortChain;
import cn.tiankafei.base.sort.chain.StandSortChain;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2019/12/2
 * @Version V1.0
 **/
@Slf4j
public class MainChain implements MainInterface {

    /**
     * 责任链模式运行
     */
    @Override
    public void execute() {
        log.info("使用责任链模式运行开始=========================================================");
        //声明责任链管理类
        StandSortChain standSortChain = new StandSortChain();
        //添加责任链
        standSortChain.add(new BubbleSortChain());
        standSortChain.add(new InsertionSortChain());
        standSortChain.add(new MergeSortChain());
        standSortChain.add(new QuickSortChain());
        standSortChain.add(new SelectionSortChain());
        standSortChain.add(new ShellSortChain());
        standSortChain.execute();
        log.info("使用责任链模式运行结束=========================================================");
    }

}
