package org.tiankafei.base.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.tiankafei.base.exceptions.BaseException;

/**
 * 文件处理工具类
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
public class ZipFileUtil {

    private ZipFileUtil() {

    }

    /**
     * 解压zip文件
     *
     * @param zipFilePath zip文件路径
     * @param targetDir   目录路径
     * @throws BaseException 自定义异常
     */
    public static void unZipFiles(String zipFilePath, String targetDir) throws BaseException {
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(zipFilePath);
            File pathFile = new File(targetDir);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            for (Enumeration<?> entries = zipFile.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                unZipFile(entry, zipFile, targetDir);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } finally {
            try {
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new BaseException(e.getMessage());
            }
        }
    }

    /**
     * 解压文件
     *
     * @param entry     压缩文件下一个文件对象
     * @param zip       zip文件对象
     * @param targetDir 目标目录
     * @throws BaseException 自定义异常
     */
    private static void unZipFile(ZipEntry entry, ZipFile zip, String targetDir) throws BaseException {
        InputStream in = null;
        OutputStream out = null;
        try {
            String zipEntryName = entry.getName();
            in = zip.getInputStream(entry);
            String outPath = (targetDir + File.separator + zipEntryName).replaceAll("\\*", "/");
            // 判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if (!file.exists()) {
                file.mkdirs();
            }
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isFile()) {
                out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DataStreamUtil.closeInputStream(in);
                DataStreamUtil.closeOutputStream(out);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BaseException(e.getMessage());
            }
        }
    }

    /**
     * 解压jar文件
     *
     * @param jarPath   要解压的jar文件
     * @param unzipPath 要解压的路径
     * @throws BaseException 自定义异常
     */
    public static void unZipJar(String jarPath, String unzipPath) throws BaseException {
        ArchiveInputStream archiveInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            File warFile = new File(jarPath);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(warFile));
            archiveInputStream = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.JAR, bufferedInputStream);

            JarArchiveEntry entry = null;
            while ((entry = (JarArchiveEntry) archiveInputStream.getNextEntry()) != null) {
                File file = new File(unzipPath, entry.getName());
                if (file.exists()) {
                    file.delete();
                }
                if (entry.isDirectory()) {
                    file.mkdir();
                } else {
                    OutputStream out = FileUtils.openOutputStream(file);
                    IOUtils.copy(archiveInputStream, out);
                    out.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage() + "未找到war文件");
        } catch (ArchiveException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage() + "不支持的压缩格式");
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage() + "文件写入发生错误");
        } finally {
            DataStreamUtil.closeInputStream(archiveInputStream);
            DataStreamUtil.closeInputStream(bufferedInputStream);
        }
    }

    /**
     * 压缩jar文件
     *
     * @param targetJarFile 要压缩的目标jar文件
     * @param zipDir        被压缩的目录
     * @throws BaseException 自定义异常
     */
    public static void zipJar(String targetJarFile, String zipDir) throws BaseException {
        BufferedOutputStream bufferedOutputStream = null;
        ArchiveOutputStream archiveOutputStream = null;
        try {
            File outFile = new File(targetJarFile);
            outFile.createNewFile();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outFile));
            archiveOutputStream = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.JAR, bufferedOutputStream);

            char str = '/';
            if (zipDir.charAt(zipDir.length() - 1) != str) {
                zipDir += str;
            }

            Iterator<File> files = FileUtils.iterateFiles(new File(zipDir), null, true);
            while (files.hasNext()) {
                File file = files.next();
                ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(file, file.getPath().replace(zipDir.replace("/", "\\"), ""));
                archiveOutputStream.putArchiveEntry(zipArchiveEntry);
                IOUtils.copy(new FileInputStream(file), archiveOutputStream);
                archiveOutputStream.closeArchiveEntry();
            }
            archiveOutputStream.finish();
            archiveOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage() + "创建文件失败");
        } catch (ArchiveException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage() + "不支持的压缩格式");
        } finally {
            DataStreamUtil.closeOutputStream(bufferedOutputStream);
            DataStreamUtil.closeOutputStream(archiveOutputStream);
        }
    }

}
