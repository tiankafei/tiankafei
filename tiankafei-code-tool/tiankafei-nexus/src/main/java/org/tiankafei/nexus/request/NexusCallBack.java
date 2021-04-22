package org.tiankafei.nexus.request;

import okhttp3.Call;
import okhttp3.Callback;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public abstract class NexusCallBack implements Callback {

    private CountDownLatch countDownLatch;

    public NexusCallBack(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        System.out.println(e.getMessage());
        countDownLatch.countDown();
    }

}
