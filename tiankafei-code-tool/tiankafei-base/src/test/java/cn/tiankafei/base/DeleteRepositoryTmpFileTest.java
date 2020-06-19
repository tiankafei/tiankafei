package cn.tiankafei.base;

import cn.tiankafei.base.util.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.stream.Stream;

public class DeleteRepositoryTmpFileTest {

    @Before
    public void steup() {

    }

    /**
     * @Param: []
     * @Return: void
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    @Test
    public void deleteRepositoryFile() {
        String repositoryPath = "D:\\software\\maven\\maven-repository-3.6.3";
        deleteRecursiveFile(repositoryPath);
    }

    /**
     * 递归删除目录中的所有目录和文件
     *
     * @Param: [directoryPath]
     * @Return: void
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private void deleteRecursiveFile(String directoryPath) {
        File file = new File(directoryPath);
        if (file.exists()) {
            File[] files = file.listFiles();
            Stream.of(files).parallel().forEach((fi) -> {
                if (fi.isDirectory()) {
                    String directoryName = fi.getName();
                    if (directoryName.contains("unknown") || directoryName.contains("${")) {
                        FileUtil.deleteRecursiveFile(fi.getPath());
                        System.out.println(fi.getPath());
                    } else {
                        deleteRecursiveFile(fi.getPath());
                    }
                } else if (fi.isFile()) {
                    if (fi.getName().endsWith(".lastUpdated")
                            || fi.getName().endsWith(".sha1-in-progress")
                            || fi.getName().endsWith("-lastUpdated.properties")) {
                        System.out.println(fi.getPath());
                        fi.delete();
                    }
                }
            });
        }
    }

}
