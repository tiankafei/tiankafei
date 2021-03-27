package org.tiankafei.common.util;

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

    public static byte[] serialize(Object obj) {
        ByteArrayOutputStream out = null;
        Output output = null;

        try {
            out = new ByteArrayOutputStream();
            output = new Output(out, 1024);
            KRYO.writeClassAndObject(output, obj);
            return output.toBytes();
        } finally {
            DataStreamUtil.closeOutputStream(output);
            DataStreamUtil.closeOutputStream(out);
        }
    }

    public static Object deserialize(byte[] bytes) {
        Input input = null;
        try {
            input = new Input(bytes, 0, 1024);
            return KRYO.readClassAndObject(input);
        } finally {
            DataStreamUtil.closeInputStream(input);
        }
    }

}
