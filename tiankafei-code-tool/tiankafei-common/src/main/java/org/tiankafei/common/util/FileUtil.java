package org.tiankafei.common.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.enums.BaseEnum;

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
import java.nio.channels.FileChannel;
import java.util.List;
import org.tiankafei.common.exceptions.CommonException;

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
     */
    public static void copyFile(String filePath, String targetFilePath) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(filePath);
            fo = new FileOutputStream(targetFilePath);
            //得到对应的文件通道
            in = fi.getChannel();
            //得到对应的文件通道
            out = fo.getChannel();
            //连接两个通道，并且从in通道读取，然后写入out通道
            in.transferTo(0, in.size(), out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeChannel(in);
            DataStreamUtil.closeChannel(out);
            DataStreamUtil.closeOutputStream(fo);
            DataStreamUtil.closeInputStream(fi);
        }
    }

    /**
     * 写一个文件
     *
     * @param filePath 文件路径
     * @param list     要写如的内容集合
     */
    public static void writerFile(String filePath, List<String> list) {
        OutputStreamWriter fs = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath, true);
            fs = new OutputStreamWriter(out, "UTF-8");
            for (int i = 0; i < list.size(); i++) {
                fs.write(list.get(i) + "\n");
            }
            fs.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new CommonException("不支持的编码！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeWriter(fs);
            DataStreamUtil.closeOutputStream(out);
        }
    }

    /**
     * 根据传过来的路径创建目录或文件
     *
     * @param path 目录路径
     */
    public static void create(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            createDirectory(path);
        } else if (file.isFile()) {
            createFile(path);
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
     */
    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                throw new CommonException("创建文件失败！");
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
     */
    public static List<String> readFileTxtAndCsv(String filePath) {
        FileInputStream in = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            List<String> strList = Lists.newArrayList();
            File file = new File(filePath);
            if (file.isFile()) {
                String fileName = file.getName().toLowerCase();
                //是txt或者csv格式的文件
                boolean flag = StringUtils.endsWithIgnoreCase(fileName, BaseEnum.FILE_SUFFIX_TXT.getValue())
                        || StringUtils.endsWithIgnoreCase(fileName, BaseEnum.FILE_SUFFIX_CSV.getValue());
                if (flag) {
                    in = new FileInputStream(file);
                    reader = new InputStreamReader(in, "UTF-8");
                    bufferedReader = new BufferedReader(reader);
                    String lineTxt = null;
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        strList.add(lineTxt);
                    }
                }
            }
            return strList;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new CommonException("不支持的编码！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeReader(bufferedReader);
            DataStreamUtil.closeReader(reader);
            DataStreamUtil.closeInputStream(in);
        }
    }

    /**
     * 读取文件到byte数组
     *
     * @param filePath 要读取的文件
     * @return
     */
    public static byte[] readByteFile(String filePath) {
        // 定义一个输入流对象
        FileInputStream fis = null;
        // 定义一个存放输入流的缓冲对象
        BufferedInputStream bis = null;
        // 定义一个输出流，相当StringBuffer（），会根据读取数据的大小，调整byte的数组长度
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 把文件路径和文件名作为参数 告诉读取流
            fis = new FileInputStream(filePath);
            // 把文件读取流对象传递给缓存读取流对象
            bis = new BufferedInputStream(fis);
            // 获得缓存读取流开始的位置
            int len = 0;
            // 定义一个容量来盛放数据
            byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1) {
                // 如果有数据的话，就把数据添加到输出流
                //这里直接用字符串StringBuffer的append方法也可以接收
                baos.write(buf, 0, len);
            }
            // 把文件输出流的数据，放到字节数组
            byte[] buffer = baos.toByteArray();

            return buffer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeOutputStream(baos);
            DataStreamUtil.closeInputStream(bis);
            DataStreamUtil.closeInputStream(fis);
        }
    }

    /**
     * 把byte数组写入文件
     *
     * @param byteArray byte数组
     * @param filePath  文件路径
     */
    public static void writeByteFile(byte[] byteArray, String filePath) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(byteArray);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeOutputStream(fileOutputStream);
        }
    }

    /**
     * 把对象写入输出流当中
     *
     * @param objectOutputStream 对象输出流
     * @param object             要写入的对象
     */
    public static void writeObjectOutputStream(ObjectOutputStream objectOutputStream, Object object) {
        try {
            if (objectOutputStream != null) {
                objectOutputStream.writeObject(object);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeOutputStream(objectOutputStream);
        }
    }

    /**
     * 字符串写文件
     *
     * @param filePath 文件路径
     * @param textList 要写的字符串集合
     */
    public static void writeTextFile(String filePath, List<String> textList) {
        writeTextFile(filePath, textList, true);
    }

    /**
     * 字符串写文件
     *
     * @param filePath  文件路径
     * @param textList  要写的字符串集合
     * @param clearFlag 为true,继续添加，为false清空后添加
     */
    public static void writeTextFile(String filePath, List<String> textList, boolean clearFlag) {
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath, clearFlag);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            for (int i = 0, lem = textList.size(); i < lem; i++) {
                outputStreamWriter.write(textList.get(i) + "\n");
            }
            outputStreamWriter.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new CommonException("不支持的编码！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeWriter(outputStreamWriter);
            DataStreamUtil.closeOutputStream(fileOutputStream);
        }
    }

    /**
     * 字符串写文件
     *
     * @param filePath 文件路径
     * @param text     要写的字符串
     */
    public static void writeTextFile(String filePath, String text) {
        writeTextFile(filePath, text, true);
    }

    /**
     * 字符串写文件
     *
     * @param filePath  文件路径
     * @param text      要写的字符串
     * @param clearFlag 为true,继续添加，为false清空后添加
     */
    public static void writeTextFile(String filePath, String text, boolean clearFlag) {
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath, clearFlag);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            outputStreamWriter.write(text + "\n");
            outputStreamWriter.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new CommonException("不支持的编码！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeWriter(outputStreamWriter);
            DataStreamUtil.closeOutputStream(fileOutputStream);
        }
    }

    public static Image readImage(String imageIconPath) {
        return readImage(FileUtil.class.getClassLoader(), imageIconPath);
    }

    /**
     * 读取图片对象
     *
     * @param imageIconPath 图片路径
     * @return 图片对象
     */
    public static Image readImage(ClassLoader classLoader, String imageIconPath) {
        try {
            InputStream inputStream = classLoader.getResourceAsStream(imageIconPath);
            Image image = ImageIO.read(inputStream);

            return image;
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException(e.getMessage() + "读取图片发生异常！");
        }
    }

    public static String readJsonFile(String fileName) {
        return readJsonFile(FileUtil.class.getClassLoader(), fileName);
    }

    /**
     * 读取json文件
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String readJsonFile(ClassLoader classLoader, String fileName) {
        InputStream in = null;
        try {
            in = classLoader.getResourceAsStream(fileName);
            return readJsonFile(in);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException("读取" + fileName + "文件出错：" + e.getMessage());
        } finally {
            DataStreamUtil.closeInputStream(in);
        }
    }

    /**
     * 读取json文件
     *
     * @param in
     * @return
     */
    public static String readJsonFile(InputStream in) {
        Reader reader = null;
        try {
            reader = new InputStreamReader(in);
            StringBuffer stringBuffer = new StringBuffer();
            int ch = 0;
            while ((ch = reader.read()) != -1) {
                stringBuffer.append((char) ch);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeReader(reader);
        }
    }

    /**
     * 更改文件名
     *
     * @param filePath
     * @param sourceName
     * @param targetName
     */
    public static void updateFileName(String filePath, String sourceName, String targetName) {
        File file = new File(filePath);
        File[] files = file.listFiles();
        for (File subFile : files) {
            String path = subFile.getParent();
            String name = subFile.getName();

            while (name.contains(sourceName)) {
                name = name.replace(sourceName, targetName);
            }
            subFile.renameTo(new File(path + File.separator + name));
        }
    }

}
