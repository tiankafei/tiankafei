package org.tiankafei.base.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Kryo序列化工具类
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
public class SerializationUtil {

    public final static Kryo KRYO = new Kryo();

    static {
        KRYO.setRegistrationRequired(false);
        KRYO.setMaxDepth(20);
    }

    public static byte[] serialize(Object obj) throws Exception {
        ByteArrayOutputStream out = null;
        Output output = null;
        try {
            out = new ByteArrayOutputStream();
            output = new Output(out, 1024);
            KRYO.writeClassAndObject(output, obj);
            return output.toBytes();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (null != out) {
                try {
                    out.close();
                    out = null;
                } catch (IOException e) {
                }
            }
            if (null != output) {
                output.close();
                output = null;
            }
        }
    }

    public static Object deserialize(byte[] bytes) throws Exception {
        Input input = null;
        try {
            input = new Input(bytes, 0, 1024);
            return KRYO.readClassAndObject(input);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (null != input) {
                input.close();
                input = null;
            }
        }
    }

}
