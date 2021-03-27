package org.tiankafei.common.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.Channel;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.exceptions.CommonException;

/**
 * 数据流的处理工具类
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
public class DataStreamUtil {

    private DataStreamUtil() {

    }

    /**
     * 文件转byte[]数组
     *
     * @param filePath 文件路径
     * @return byte数组
     */
    public static byte[] getByteArray(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return null;
        }
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            byte[] byteArray = new byte[inputStream.available()];
            inputStream.read(byteArray);
            return byteArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            closeInputStream(inputStream);
        }
    }

    /**
     * InputStream转byte[]数组
     *
     * @param inputStream 输入流
     * @return byte数组
     */
    public static byte[] getByteArray(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            int length;
            while ((length = inputStream.read()) != -1) {
                byteArrayOutputStream.write(length);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return byteArray;
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            closeInputStream(inputStream);
            closeOutputStream(byteArrayOutputStream);
        }
    }

    /**
     * Blob转byte[]数组
     *
     * @param blob blob对象
     * @return byte数组
     */
    public static byte[] getByteArray(Blob blob) {
        if (blob == null) {
            return null;
        }
        InputStream inputStream = null;
        try {
            inputStream = blob.getBinaryStream();

            byte[] byteArray = getByteArray(inputStream);
            return byteArray;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommonException("数据转换失败！");
        } finally {
            closeInputStream(inputStream);
        }
    }

    /**
     * object转byte[]数组
     *
     * @param object object对象
     * @return byte数组
     */
    public static byte[] getByteArray(Object object) {
        if (object == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return byteArray;
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            closeOutputStream(objectOutputStream);
            closeOutputStream(byteArrayOutputStream);
        }
    }

    /**
     * byte数组转Object
     *
     * @param byteArray byte数组
     * @return object对象
     */
    public static Object getByteToObject(byte[] byteArray) {
        Object object = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byteArray);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("缺少必要的功能模块！");
        } finally {
            closeInputStream(objectInputStream);
            closeInputStream(byteArrayInputStream);
        }
        return object;
    }

    /**
     * 对象复制
     *
     * @param object 要复制的对象
     * @return 复制后的对象
     */
    public static Object copyObject(Object object) {
        byte[] byteArray = getByteArray(object);
        object = getByteToObject(byteArray);
        return object;
    }

    /**
     * Blob转String
     *
     * @param blob blob对象
     * @return String字符串
     */
    public static String getBlobToString(Blob blob) {
        if (blob == null) {
            return null;
        }
        byte[] byteArray = getByteArray(blob);
        String content = new String(byteArray);
        return content;
    }

    /**
     * Clob转String
     *
     * @param clob clob对象
     * @return String字符串
     */
    public static String getClobToString(Clob clob) {
        if (clob == null) {
            return null;
        }
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(clob.getCharacterStream());
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommonException("数据转换失败！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            closeReader(bufferedReader);
        }
    }

    /**
     * Blob转BufferedImage
     *
     * @param blob blob对象
     * @return 图片缓存对象
     */
    public static BufferedImage getBlobToBufferedImage(Blob blob) {
        if (blob == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byte[] byteArray = getByteArray(blob);

            byteArrayInputStream = new ByteArrayInputStream(byteArray);
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问图片失败！");
        } finally {
            closeInputStream(byteArrayInputStream);
        }
    }

    /**
     * 把对象从输入流当中读出来
     *
     * @param objectInputStream 对象输入流
     * @return 对象
     */
    public static Object readObjectInputStream(ObjectInputStream objectInputStream) {
        try {
            if (objectInputStream != null) {
                return objectInputStream.readObject();
            }
            throw new CommonException("请检查与服务器的连接是否已经断开！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("缺少必要的功能模块！");
        } finally {
            closeInputStream(objectInputStream);
        }
    }

    /**
     * 关闭输入流
     *
     * @param reader 要关闭输入流
     */
    public static void closeReader(Reader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("读失败！");
        }
    }

    /**
     * 关闭输出流
     *
     * @param writer 需要关闭的输出流
     */
    public static void closeWriter(Writer writer) {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("写失败！");
        }
    }

    /**
     * 关闭输入流
     *
     * @param inputStream 需要关闭的输入流
     */
    public static void closeInputStream(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("输入失败！");
        }
    }

    /**
     * 关闭输出流
     *
     * @param outputStream 需要关闭的输出流
     */
    public static void closeOutputStream(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("输出失败！");
        }
    }

    /**
     * 关闭管道流
     *
     * @param channel 需要关闭的管道流
     */
    public static void closeChannel(Channel channel) {
        try {
            if (channel != null) {
                channel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("关闭文件失败！");
        }
    }

    /**
     * 关闭数据库句柄
     *
     * @param statement 需要关闭的数据库句柄
     */
    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommonException("关闭数据库句柄失败！");
        }
    }

    /**
     * 关闭数据库连接
     *
     * @param connection 需要关闭的数据库连接
     */
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CommonException("关闭数据库连接失败！");
        }
    }

}
