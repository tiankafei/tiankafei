package org.tiankafei.base.base.util;

import org.tiankafei.base.base.enums.BaseEnum;
import org.tiankafei.base.base.exceptions.BaseException;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件处理工具类
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
public class FileUtil {

    private FileUtil() {

    }

    /**
     * 拷贝文件
     *
     * @param filePath       文件路径
     * @param targetFilePath 目标文件路径
     * @throws BaseException 自定义异常
     */
    public static void copyFile(String filePath, String targetFilePath) throws BaseException {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(new File(filePath));
            fo = new FileOutputStream(new File(targetFilePath));
            //得到对应的文件通道
            in = fi.getChannel();
            //得到对应的文件通道
            out = fo.getChannel();
            //连接两个通道，并且从in通道读取，然后写入out通道
            in.transferTo(0, in.size(), out);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            try {
                DataStreamUtil.closeInputStream(fi);
                DataStreamUtil.closeOutputStream(fo);
                DataStreamUtil.closeChannel(in);
                DataStreamUtil.closeChannel(out);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BaseException(e.getMessage());
            }
        }
    }

    /**
     * 写一个文件
     *
     * @param filePath 文件路径
     * @param list     要写如的内容集合
     * @throws BaseException 自定义异常
     */
    public static void writerFile(String filePath, List<String> list) throws BaseException {
        OutputStreamWriter fs = null;
        try {
            fs = new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8");
            for (int i = 0; i < list.size(); i++) {
                fs.write(list.get(i) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            try {
                closeWriter(fs);
            } catch (Exception e) {
                throw new BaseException(e.getMessage());
            }
        }
    }

    /**
     * 根据传过来的路径创建目录或文件
     *
     * @param path 目录路径
     * @throws BaseException 自定义异常
     */
    public static void create(String path) throws BaseException {
        File file = new File(path);
        if (file.isDirectory()) {
            createDirectory(path);
        } else if (file.isFile()) {
            try {
                createFile(path);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BaseException(e.getMessage());
            }
        }
    }

    /**
     * 创建目录
     *
     * @param directoryPath 需要创建目录的路径
     */
    public static void createDirectory(String directoryPath) {
        File file = new File(directoryPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 创建文件
     *
     * @param filePath 文件路径
     * @throws BaseException 自定义异常
     */
    public static void createFile(String filePath) throws BaseException {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                throw new BaseException(e.getMessage());
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param filePath 文件路径
     */
    public static void delteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 递归删除目录中的所有目录和文件
     *
     * @param directoryPath 目录路径
     */
    public static void deleteRecursiveFile(String directoryPath) {
        File file = new File(directoryPath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (int i = 0, lem = files.length; i < lem; i++) {
                if (files[i].isDirectory()) {
                    deleteRecursiveFile(files[i].getPath());
                }
                files[i].delete();
            }
            file.delete();
        }
    }

    /**
     * 读txt或者csv格式的文件
     *
     * @param filePath 文件路径
     * @return 返回读取文件的结果集
     * @throws BaseException 自定义异常
     */
    public static List<String> readFileTxtAndCsv(String filePath) throws BaseException {
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            List<String> strList = new ArrayList<String>();
            File file = new File(filePath);
            if (file.isFile()) {
                String fileName = file.getName().toLowerCase();
                //是txt或者csv格式的文件
                if (fileName.endsWith(BaseEnum.FILE_SUFFIX_TXT.getValue()) || fileName.endsWith(BaseEnum.FILE_SUFFIX_CSV.getValue())) {
                    reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
                    bufferedReader = new BufferedReader(reader);
                    String lineTxt = null;
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        strList.add(lineTxt);
                    }
                }
            }
            return strList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            try {
                closeReader(bufferedReader);
                closeReader(reader);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BaseException(e.getMessage());
            }
        }
    }

    /**
     * 把byte数组写入文件
     *
     * @param byteArray byte数组
     * @param filePath  文件路径
     * @throws BaseException 自定义异常
     */
    public static void writeByteFile(byte[] byteArray, String filePath) throws BaseException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(filePath));
            fileOutputStream.write(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            DataStreamUtil.closeOutputStream(fileOutputStream);
        }
    }

    /**
     * 把对象写入输出流当中
     *
     * @param objectOutputStream 对象输出流
     * @param object             要写入的对象
     * @throws BaseException 自定义异常
     */
    public static void writeObjectOutputStream(ObjectOutputStream objectOutputStream, Object object) throws BaseException {
        try {
            if (objectOutputStream != null) {
                objectOutputStream.writeObject(object);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            DataStreamUtil.closeOutputStream(objectOutputStream);
        }
    }

    /**
     * 字符串写文件
     *
     * @param filePath 文件路径
     * @param textList 要写的字符串集合
     * @throws BaseException 自定义异常
     */
    public static void writeTextFile(String filePath, List<String> textList) throws BaseException {
        writeTextFile(filePath, textList, true);
    }

    /**
     * 字符串写文件
     *
     * @param filePath  文件路径
     * @param textList  要写的字符串集合
     * @param clearFlag 为true,继续添加，为false清空后添加
     * @throws BaseException 自定义异常
     */
    public static void writeTextFile(String filePath, List<String> textList, boolean clearFlag) throws BaseException {
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath, clearFlag), "UTF-8");
            for (int i = 0, lem = textList.size(); i < lem; i++) {
                outputStreamWriter.write(textList.get(i) + "\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            closeWriter(outputStreamWriter);
        }
    }

    /**
     * 字符串写文件
     *
     * @param filePath 文件路径
     * @param text     要写的字符串
     * @throws BaseException 自定义异常
     */
    public static void writeTextFile(String filePath, String text) throws BaseException {
        writeTextFile(filePath, text, true);
    }

    /**
     * 字符串写文件
     *
     * @param filePath  文件路径
     * @param text      要写的字符串
     * @param clearFlag 为true,继续添加，为false清空后添加
     * @throws BaseException 自定义异常
     */
    public static void writeTextFile(String filePath, String text, boolean clearFlag) throws BaseException {
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath, clearFlag), "UTF-8");
            outputStreamWriter.write(text + "\n");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            closeWriter(outputStreamWriter);
        }
    }

    /**
     * 关闭输入流
     *
     * @param reader 要关闭输入流
     * @throws BaseException 自定义异常
     */
    public static void closeReader(Reader reader) throws BaseException {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 关闭输出流
     *
     * @param writer 需要关闭的输出流
     * @throws BaseException 自定义异常
     */
    public static void closeWriter(Writer writer) throws BaseException {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 读取图片对象
     *
     * @param imageIconPath 图片路径
     * @return 图片对象
     * @throws BaseException 自定义异常
     */
    public static Image readImage(String imageIconPath) throws BaseException {
        try {
            InputStream inputStream = FileUtil.class.getResourceAsStream(imageIconPath);
            Image image = ImageIO.read(inputStream);

            return image;
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage() + "读取图片发生异常！");
        }
    }

}
