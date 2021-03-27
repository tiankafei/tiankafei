package org.tiankafei.common.util;

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
import org.tiankafei.common.exceptions.CommonException;

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
     */
    public static void unZipFiles(String zipFilePath, String targetDir) {
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
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("解压文件失败！");
        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    throw new CommonException("解压文件的最后操作失败！");
                }
            }
        }
    }

    /**
     * 解压文件
     *
     * @param entry     压缩文件下一个文件对象
     * @param zip       zip文件对象
     * @param targetDir 目标目录
     */
    private static void unZipFile(ZipEntry entry, ZipFile zip, String targetDir) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeInputStream(in);
            DataStreamUtil.closeOutputStream(out);
        }
    }

    /**
     * 解压jar文件
     *
     * @param jarPath   要解压的jar文件
     * @param unzipPath 要解压的路径
     */
    public static void unZipJar(String jarPath, String unzipPath) {
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
        } catch (ArchiveException e) {
            e.printStackTrace();
            throw new CommonException("不支持的压缩格式！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
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
     */
    public static void zipJar(String targetJarFile, String zipDir) {
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
        } catch (ArchiveException e) {
            e.printStackTrace();
            throw new CommonException("不支持的压缩格式！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeOutputStream(bufferedOutputStream);
            DataStreamUtil.closeOutputStream(archiveOutputStream);
        }
    }

}
