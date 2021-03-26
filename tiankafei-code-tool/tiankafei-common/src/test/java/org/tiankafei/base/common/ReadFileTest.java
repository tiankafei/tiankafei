package org.tiankafei.base.common;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ReadFileTest {

    @Test
    public void test2() {
        String filePath = "C:\\Users\\tiankafei\\Desktop\\guixiaxinxi33628-biao2.csv";
        String newFilePath = "C:\\Users\\tiankafei\\Desktop\\guixiaxinxi33628-biao22.csv";
        File newFile = new File(newFilePath);
        try {
            List<String> newList = Lists.newArrayList();

            LineIterator lineIterator = FileUtils.lineIterator(new File(filePath), "GBK");
            int count = 0;
            while (lineIterator.hasNext()) {
                String line = lineIterator.nextLine();
                List<String> dataList = new ArrayList(Arrays.asList(line.split(",")));
                if (dataList.size() != 27) {
                    continue;
                }
                if (count == 0) {
                    dataList.add(3, "zzjgdm");
                } else {
                    String value = dataList.get(2);
                    dataList.add(3, value);
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (String newLine : dataList) {
                    stringBuilder.append(",").append(newLine);
                }
                stringBuilder.delete(0, 1);
                newList.add(stringBuilder.toString());
                count++;
            }

            FileUtils.writeLines(newFile, "GBK", newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        String filePath = "C:\\Users\\tiankafei\\Desktop\\guishangxinxi34275-biao1.csv";
        String newFilePath = "C:\\Users\\tiankafei\\Desktop\\guishangxinxi34275-biao11.csv";
        File newFile = new File(newFilePath);
        try {
            List<String> newList = Lists.newArrayList();

            LineIterator lineIterator = FileUtils.lineIterator(new File(filePath), "GBK");
            int count = 0;
            while (lineIterator.hasNext()) {
                String line = lineIterator.nextLine();
                System.out.println(count + "--------------" + line);
                List<String> dataList = new ArrayList(Arrays.asList(line.split(",")));
                System.out.println(dataList.size());
                if (dataList.size() != 27) {
                    continue;
                }
                if (count == 0) {
                    dataList.add(3, "dcdxxtm");
                } else {
                    String value = dataList.get(2);
                    dataList.add(3, value);
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (String newLine : dataList) {
                    stringBuilder.append(",").append(newLine);
                }
                stringBuilder.delete(0, 1);
                newList.add(stringBuilder.toString());
                count++;
            }

            FileUtils.writeLines(newFile, "GBK", newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
