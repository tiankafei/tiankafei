package org.tiankafei.poi;

import lombok.Data;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ParsePdfUtil {

    class Catalogs {
        private String code;
        private String name;
        private String description;
        private List<Catalogs> sub = Lists.newArrayList();

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Catalogs> getSub() {
            return sub;
        }

        public void setSub(List<Catalogs> sub) {
            this.sub = sub;
        }

        @Override
        public String toString() {
            return getCode() + "," + getName();
        }
    }

    @Test
    public void test() throws Exception {
        boolean flag = false;

        String filePath = "D:\\data\\tabula-P020190716349644060705.txt";
        List<String> dataList = FileUtils.readLines(new File(filePath), "UTF-8");

        List<Catalogs> catalogsList = Lists.newArrayList();

        Catalogs firstCatalogs = new Catalogs();
        Catalogs secondCatalogs = new Catalogs();
        Catalogs thirdSatalogs = new Catalogs();
        Catalogs fourthCatalogs = new Catalogs();

        Catalogs beforeRowCatalogs = null;

        for (int index = 0, length = dataList.size(); index < length; index++) {
            String line = dataList.get(index);
            if (line.contains("代,码")) {
                flag = false;
            } else if (line.contains("大类,中类,小类")) {
                flag = true;
                continue;
            }
            if (flag) {
                line = replace(line);
                line = processLine(line);
                List<String> asList = Arrays.asList(line.split(",", -1));
                System.out.println(asList.size() + "---" + asList);

                String first = asList.get(0);
                String second = asList.get(1);
                String third = asList.get(2);
                String fourth = asList.get(3);
                String name = asList.get(4);
                String description = "";
                if (asList.size() > 5) {
                    description = asList.get(5);
                    description = description.replaceAll("\"", "");
                }

                boolean flag1 = false;
                boolean flag2 = false;
                boolean flag3 = false;
                boolean flag4 = false;

                if (!"\"\"".equals(first)) {
                    firstCatalogs = new Catalogs();
                    firstCatalogs.setCode(first);
                    firstCatalogs.setName(name);
                    firstCatalogs.setDescription(description);
                    catalogsList.add(firstCatalogs);

                    beforeRowCatalogs = firstCatalogs;
                } else {
                    flag1 = true;
                }

                if (StringUtils.isNotBlank(second)) {
                    secondCatalogs = new Catalogs();
                    secondCatalogs.setCode(second);
                    secondCatalogs.setName(name);
                    secondCatalogs.setDescription(description);
                    firstCatalogs.getSub().add(secondCatalogs);

                    beforeRowCatalogs = secondCatalogs;
                } else {
                    flag2 = true;
                }

                if (StringUtils.isNotBlank(third)) {
                    thirdSatalogs = new Catalogs();
                    thirdSatalogs.setCode(third);
                    thirdSatalogs.setName(name);
                    thirdSatalogs.setDescription(description);
                    secondCatalogs.getSub().add(thirdSatalogs);

                    beforeRowCatalogs = thirdSatalogs;
                } else {
                    flag3 = true;
                }

                if (StringUtils.isNotBlank(fourth)) {
                    if(!flag3){
                        thirdSatalogs.setDescription(null);
                    }

                    fourthCatalogs = new Catalogs();
                    fourthCatalogs.setCode(fourth);
                    fourthCatalogs.setName(name);
                    fourthCatalogs.setDescription(description);
                    thirdSatalogs.getSub().add(fourthCatalogs);

                    beforeRowCatalogs = fourthCatalogs;
                } else {
                    flag4 = true;
                }

                if (flag1 && flag2 && flag3 && flag4) {
                    if (beforeRowCatalogs != null) {
                        beforeRowCatalogs.setDescription(beforeRowCatalogs.getDescription() + description);
                    } else {
                        throw new Exception("出错了！");
                    }
                }
            }
        }

        System.out.println(catalogsList);
    }

    private String processLine(String line) {
        List<String> asList = Arrays.asList(line.split(",", -1));
        if (asList.size() == 7) {
            String str4 = asList.get(4);
            String str5 = asList.get(5);
            String str6 = asList.get(6);
            if (StringUtils.isBlank(str4) && StringUtils.isNotBlank(str5)) {
                asList.set(4, str5);
                asList.set(5, "");
                StringBuffer stringBuffer = new StringBuffer();
                for (int index = 0; index < asList.size() - 2; index++) {
                    stringBuffer.append(asList.get(index)).append(",");
                }
                return stringBuffer.toString();
            } else if (StringUtils.isBlank(str5) && StringUtils.isBlank(str6)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int index = 0; index < asList.size() - 2; index++) {
                    stringBuffer.append(asList.get(index)).append(",");
                }
                return stringBuffer.toString();
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                for (int index = 0; index < asList.size() - 1; index++) {
                    stringBuffer.append(asList.get(index)).append(index == asList.size() - 2 ? "" : ",");
                }
                return stringBuffer.toString();
            }
        } else if (asList.size() == 8) {
            String str5 = asList.get(5);
            String str6 = asList.get(6);
            String str7 = asList.get(7);
            if (StringUtils.isBlank(str6) && StringUtils.isBlank(str7)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int index = 0; index < asList.size() - 3; index++) {
                    stringBuffer.append(asList.get(index)).append(",");
                }
                return stringBuffer.toString();
            } else if (StringUtils.isBlank(str5) && StringUtils.isNotBlank(str6)) {
                asList.set(5, str6);
                asList.set(6, "");
                StringBuffer stringBuffer = new StringBuffer();
                for (int index = 0; index < asList.size() - 2; index++) {
                    stringBuffer.append(asList.get(index)).append(index == asList.size() - 3 ? "" : ",");
                }
                return stringBuffer.toString();
            } else {
                System.out.println(8 + "---" + line);
            }
        }

        return line;
    }

    private String replace(String line) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        for (int index = 1, length = line.length(); index <= length; index++) {
            String substring = line.substring(index - 1, index);
            if ("\"".equals(substring)) {
                stringBuffer.append(substring);
                int endIndex = findNextIndex(index, line);
                if (endIndex != -1) {
                    String substring1 = line.substring(index, endIndex);
                    stringBuffer.append(substring1.replaceAll(",", "，"));
                    index = endIndex;
                } else {
                    throw new Exception("没有找到与之对应的\"");
                }
            } else {
                stringBuffer.append(substring);
            }
        }
        return stringBuffer.toString();
    }

    private int findNextIndex(int start, String line) {
        for (int index = start + 1, length = line.length(); index <= length; index++) {
            String substring = line.substring(index - 1, index);
            if ("\"".equals(substring)) {
                return index;
            }
        }
        return -1;
    }

}
