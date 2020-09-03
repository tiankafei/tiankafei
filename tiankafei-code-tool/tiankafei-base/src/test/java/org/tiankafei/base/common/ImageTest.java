package org.tiankafei.base.common;

import com.google.common.collect.Lists;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.base.util.FileUtil;

public class ImageTest {

    @Before
    public void steup() {

    }

    @Test
    @Ignore
    public void imageTest() {
        List<String> filePathList = Lists.newArrayList();
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\WebReport\\WEB-INF\\lib\\fr-chart-8.0");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\WebReport\\WEB-INF\\lib\\fr-core-8.0");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\WebReport\\WEB-INF\\lib\\fr-performance-8.0");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\WebReport\\WEB-INF\\lib\\fr-platform-8.0");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\WebReport\\WEB-INF\\lib\\fr-report-8.0");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\WebReport\\WEB-INF\\lib\\fr-third-8.0");

        filePathList.add("D:\\greensoftware\\FineReport_9.0\\lib\\fr-designer-chart-8.0");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\lib\\fr-designer-core-8.0");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\lib\\fr-designer-report-8.0");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\lib\\plugin-com.fr.plugin.chart.vancharts-0");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\lib\\plugin-com.fr.plugin.chart.vancharts-1");
        filePathList.add("D:\\greensoftware\\FineReport_9.0\\lib\\plugin-com.fr.plugin.reportfit-0");
        copyImageFilePath("finecell", filePathList);

//        filePathList.clear();
//        filePathList.add("E:\\svns\\information\\frame\\swing-jide\\jdaf_wizard_demo");
//        filePathList.add("E:\\svns\\information\\frame\\swing-jide\\jide_demo");
//        filePathList.add("E:\\svns\\information\\frame\\swing-jide\\jide_designer");
//        copyImageFilePath("jide", filePathList);
    }

    private static void copyImageFilePath(String directory, List<String> filePathList) {
        List<String> imageFilePathList = Lists.newArrayList();
        for (int index = 0, length = filePathList.size(); index < length; index++) {
            String filePath = filePathList.get(index);
            readImageFilePath(filePath, imageFilePathList);
        }

        Map<String, Integer> filePathMap = new HashMap<String, Integer>();
        String targetDirectory = "D:\\images" + File.separator + directory;
        File file = new File(targetDirectory);
        if (file.exists()) {
            FileUtil.deleteRecursiveFile(targetDirectory);
        }
        file.mkdirs();
        for (int index = 0, length = imageFilePathList.size(); index < length; index++) {
            String filePath = imageFilePathList.get(index);
            file = new File(filePath);
            String fileName = file.getName();
            String targetFilePath = targetDirectory + File.separator + fileName;
            if (filePathMap.containsKey(fileName)) {
                int fileIndex = filePathMap.get(fileName) + 1;
                filePathMap.put(fileName, fileIndex);

                String suffixName = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                String prefixName = fileName.substring(0, fileName.lastIndexOf("."));
                targetFilePath = targetDirectory + File.separator + prefixName + fileIndex + suffixName;
            } else {
                filePathMap.put(fileName, 0);
            }
            try {
                FileUtil.copyFile(filePath, targetFilePath);
            } catch (BaseException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readImageFilePath(String filePath, List<String> imageFilePathList) {
        if (StringUtils.isNotEmpty(filePath)) {
            File file = new File(filePath);
            if (file.exists() && file != null) {
                File[] files = file.listFiles();
                for (int index = 0, length = files.length; index < length; index++) {
                    String tempFilePath = files[index].getPath();
                    if (files[index].isFile()) {
                        if (tempFilePath.endsWith(".png") || tempFilePath.endsWith(".gif")) {
                            imageFilePathList.add(tempFilePath);
                        }
                    } else if (files[index].isDirectory()) {
                        readImageFilePath(tempFilePath, imageFilePathList);
                    }
                }
            }
        }
    }

}
