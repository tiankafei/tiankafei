package org.tiankafei.nexus.request;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class HttpUtil {

    private static OkHttpClient okHttpClient = new OkHttpClient();

    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 异步阻塞（同步）执行分析方法
     *
     * @param url   分析方法的url
     * @param param 分析方法的入参-json
     * @return      分析放的结果-json
     */
    public static String asyncBlockExecuteAnalysis(String url, String param) {
        String[] resultArray = new String[]{null};
        CountDownLatch countDownLatch = new CountDownLatch(1);
        executeAnalysis(url, param, new NexusCallBack(countDownLatch) {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String res = response.body().string();
                    resultArray[0] = res;
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultArray[0];
    }

    private static void executeAnalysis(String url, String param, NexusCallBack nexusCallBack) {
        RequestBody body = RequestBody.create(param, APPLICATION_JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(nexusCallBack);
    }

}
