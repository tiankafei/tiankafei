package cn.tiankafei.base;

import cn.tiankafei.base.util.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

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
            for (int i = 0, lem = files.length; i < lem; i++) {
                if (files[i].isDirectory()) {
                    String directoryName = files[i].getName();
                    if (directoryName.contains("unknown") || directoryName.contains("${")) {
                        FileUtil.deleteRecursiveFile(files[i].getPath());
                        System.out.println(files[i].getPath());
                    } else {
                        deleteRecursiveFile(files[i].getPath());
                    }
                } else if (files[i].isFile()) {
                    if (files[i].getName().endsWith(".lastUpdated")
                            || files[i].getName().endsWith(".sha1-in-progress")
                            || files[i].getName().endsWith("-lastUpdated.properties")) {
                        System.out.println(files[i].getPath());
                        files[i].delete();
                    }
                }
            }
        }
    }

}
