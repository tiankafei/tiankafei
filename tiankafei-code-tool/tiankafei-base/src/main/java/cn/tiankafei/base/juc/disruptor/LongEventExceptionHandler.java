package cn.tiankafei.base.juc.disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventExceptionHandler implements EventHandler<LongEvent> {

    public static long count = 0;

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        count++;
        System.out.println("[" + Thread.currentThread().getName() + "]" + event + " 序号：" + sequence);
        throw new Exception("执行错了");
    }
}
