package org.tiankafei.web.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.tiankafei.base.datetime.DateTimeUtil;
import org.tiankafei.base.enums.DateTimeEnum;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.base.util.DataStreamUtil;
import org.tiankafei.base.util.FileUtil;
import org.tiankafei.base.util.UuidUtil;

/**
 * 文件上传工具类
 *
 * @author tiankafei
 */
public class UploadAndDownloadFileUtil {

    private UploadAndDownloadFileUtil() {

    }

    /**
     * 上传文件到服务器
     *
     * @param byteArray   要上传文件的字节
     * @param targetDir   目标目录
     * @param newFilename 文件后缀名
     * @throws BaseException 自定义异常
     */
    public static void uploadFileToServer(byte[] byteArray, String targetDir, String newFilename) throws BaseException {
        try {
            //创建目录
            FileUtil.createDirectory(targetDir);

            //文件上传的路径
            String targetFilePath = targetDir + File.separator + newFilename;

            //上传文件
            uploadFile(byteArray, targetFilePath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 上传文件到服务器
     *
     * @param byteArray  要上传文件的字节
     * @param targetDir  目标目录
     * @param suffixName 文件后缀名
     * @param timestamp  当前时间，组装新的文件名使用
     * @return 新的文件名
     * @throws BaseException 自定义异常
     */
    public static String uploadFileToServer(byte[] byteArray, String targetDir, String suffixName, Timestamp timestamp) throws BaseException {
        try {
            //创建目录
            FileUtil.createDirectory(targetDir);

            //开始上传=====================
            String newFilename = DateTimeUtil.timestampToString(timestamp, DateTimeEnum.YYYYMMDDHHMMSS.getCode()) + "_" + UuidUtil.getUuid(8) + suffixName;

            //文件上传的路径
            String targetFilePath = targetDir + File.separator + newFilename;

            //上传文件
            uploadFile(byteArray, targetFilePath);

            return newFilename;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 上传文件
     *
     * @param byteArray      要上传文件的字节
     * @param targetFilePath 要上传文件的目录路径
     * @throws BaseException 自定义异常
     */
    private static void uploadFile(byte[] byteArray, String targetFilePath) throws BaseException {
        FileOutputStream fileOutputStream = null;
        try {
            //创建输出
            fileOutputStream = new FileOutputStream(targetFilePath);
            //写入
            fileOutputStream.write(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            try {
                DataStreamUtil.closeOutputStream(fileOutputStream);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BaseException(e.getMessage());
            }
        }
    }

    /**
     * 下载文件到本地
     *
     * @param response            jsp内置对象，向页面写内容
     * @param downloadFileTempDir 要下载的文件在服务器上生成的临时目录
     * @param suffixName          要下载的文件后缀名
     * @param timestamp           获取当前时间
     * @throws BaseException 自定义异常
     */
    public static void downloadFileToLocal(HttpServletResponse response, String downloadFileTempDir, String suffixName, Timestamp timestamp) throws BaseException {
        try {
            boolean deleteFlag = true;
            //下载文件
            downloadFileToLocal(response, downloadFileTempDir, suffixName, timestamp, deleteFlag);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 下载文件到本地
     *
     * @param response            jsp内置对象，向页面写内容
     * @param downloadFileTempDir 要下载文件的临时路径
     * @param suffixName          后缀
     * @param timestamp           获取当前时间
     * @param deleteFlag          下载完成后是否要删除该文件
     * @throws BaseException 自定义异常
     */
    public static void downloadFileToLocal(HttpServletResponse response, String downloadFileTempDir, String suffixName, Timestamp timestamp, boolean deleteFlag) throws BaseException {
        try {
            //要下载的文件名
            String downloadFileName = DateTimeUtil.timestampToString(timestamp, DateTimeEnum.YYYYMMDDHHMMSS.getCode()) + "_" + UuidUtil.getUuid(8) + "." + suffixName;

            //要下载的文件在服务器上生成的临时目录
            String downloadFileTempFilePath = downloadFileTempDir + File.separator + downloadFileName;
            //下载文件
            downloadFile(response, downloadFileTempFilePath);

            if (deleteFlag) {
                File file = new File(downloadFileTempDir);
                //生成文件的临时目录里如果没有其他文件或目录则删除该目录
                if (file.listFiles().length <= 0) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 下载文件
     *
     * @param response jsp响应对象
     * @param filePath 要下载的文件路径
     * @throws BaseException 自定义异常
     */
    private static void downloadFile(HttpServletResponse response, String filePath) throws BaseException {
        ServletOutputStream servletOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            //下载的文件名
            String downloadFileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1, filePath.length());
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
            response.setHeader("Content-Disposition", "attachment; fileName=" + downloadFileName);

            File file = new File(filePath);
            fileInputStream = new FileInputStream(file);

            //3.通过response获取ServletOutputStream对象(out)
            servletOutputStream = response.getOutputStream();
            int b = 0;
            byte[] buffer = new byte[512];
            while (b != -1) {
                b = fileInputStream.read(buffer);
                //4.写到输出流(out)中
                servletOutputStream.write(buffer, 0, b);
            }
            //删除文件
            FileUtil.delteFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            try {
                DataStreamUtil.closeInputStream(fileInputStream);
                DataStreamUtil.closeOutputStream(servletOutputStream);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BaseException(e.getMessage());
            }
        }
    }

}
