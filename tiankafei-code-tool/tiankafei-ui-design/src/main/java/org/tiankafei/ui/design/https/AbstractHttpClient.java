package org.tiankafei.ui.design.https;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.exceptions.CommonException;
import org.tiankafei.common.util.DataStreamUtil;
import org.tiankafei.common.util.FileUtil;

/**
 * 基础http操作类
 *
 * @author tiankafei1
 */
public abstract class AbstractHttpClient {

    /**
     * url对象
     */
    private URL url;

    /**
     * 构造基础http操作类
     *
     * @param url 连接服务器的url地址
     */
    public AbstractHttpClient(String url) {
        if (StringUtils.isNotEmpty(url)) {
            try {
                this.url = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new CommonException(url + "：格式错误，请检查！");
            }
        }
    }

    /**
     * 提交访问url
     *
     * @param packageClassName 提交要反射的class包名
     * @param methodName       提交要反射的class方法名
     * @param objectArray      参数
     * @return http连接对象
     */
    protected HttpURLConnection submit(String packageClassName, String methodName, Object... objectArray) {
        try {
            //打开http连接
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setRequestProperty("Content-Type", "applicaiton/x-java-serialized-object");

            List<Object> dataList = Lists.newArrayList();
            dataList.add(packageClassName);
            dataList.add(methodName);
            for (int index = 0, length = objectArray.length; index < length; index++) {
                dataList.add(objectArray[index]);
            }
            //把数据传入对象写入输入流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(httpUrlConnection.getOutputStream());
            FileUtil.writeObjectOutputStream(objectOutputStream, dataList);

            return httpUrlConnection;
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("打开连接失败，请确认url是否能够访问！");
        }
    }

    /**
     * 接收http返回的对象
     *
     * @param httpUrlConnection http连接对象
     * @return http返回的对象
     */
    protected Object receive(HttpURLConnection httpUrlConnection) {
        try {
            //状态代码
            int statusCode = httpUrlConnection.getResponseCode();

            int minStatusCode = 200;
            int maxStatusCode = 300;
            if ((statusCode >= minStatusCode) && (statusCode <= maxStatusCode)) {

            }

            ObjectInputStream objectInputStream = new ObjectInputStream(httpUrlConnection.getInputStream());
            return DataStreamUtil.readObjectInputStream(objectInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("url数据返回失败，请检查！");
        }
    }

}
