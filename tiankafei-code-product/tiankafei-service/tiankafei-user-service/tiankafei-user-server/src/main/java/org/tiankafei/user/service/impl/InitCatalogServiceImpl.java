package org.tiankafei.user.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.model.CatalogDto;
import org.tiankafei.user.service.DictInfoService;
import org.tiankafei.user.service.DictTableService;
import org.tiankafei.user.service.InitCatalogService;
import org.tiankafei.user.vo.DictInfoVo;
import org.tiankafei.user.vo.DictTableVo;

/**
 * 初始化目录代码表
 *
 * @author tiankafei
 */
@Slf4j
@Service
public class InitCatalogServiceImpl implements InitCatalogService {

    @Autowired
    private DictInfoService dictInfoService;

    @Autowired
    private DictTableService dictTableService;

    @Autowired
    private DefaultIdentifierGenerator defaultIdentifierGenerator;

    @Override
    public void initIndustry() throws Exception {
        String filePath = "D:\\data\\tabula-P020190716349644060705.txt";

        boolean flag = false;

        List<String> dataList = FileUtils.readLines(new File(filePath), "UTF-8");

        List<CatalogDto> catalogsList = Lists.newArrayList();

        CatalogDto firstCatalogs = new CatalogDto();
        CatalogDto secondCatalogs = new CatalogDto();
        CatalogDto thirdSatalogs = new CatalogDto();
        CatalogDto fourthCatalogs = new CatalogDto();

        CatalogDto beforeRowCatalogs = null;

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
                    firstCatalogs = new CatalogDto();
                    firstCatalogs.setCode(first);
                    firstCatalogs.setName(name);
                    firstCatalogs.setDescription(description);
                    catalogsList.add(firstCatalogs);

                    beforeRowCatalogs = firstCatalogs;
                } else {
                    flag1 = true;
                }

                if (StringUtils.isNotBlank(second)) {
                    secondCatalogs = new CatalogDto();
                    secondCatalogs.setCode(second);
                    secondCatalogs.setName(name);
                    secondCatalogs.setDescription(description);
                    firstCatalogs.getSub().add(secondCatalogs);

                    beforeRowCatalogs = secondCatalogs;
                } else {
                    flag2 = true;
                }

                if (StringUtils.isNotBlank(third)) {
                    thirdSatalogs = new CatalogDto();
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

                    fourthCatalogs = new CatalogDto();
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


        DictInfoVo dictInfoVo = new DictInfoVo();
        dictInfoVo.setDictCode("0043");
        dictInfoVo.setDictName("国民经济行业分类");
        dictInfoVo.setStatus(Boolean.TRUE);
        dictInfoVo.setDescription(dictInfoVo.getDictName());
        dictInfoVo.setRemarks(dictInfoVo.getDictName());
        dictInfoVo.setUseType("1");
        dictInfoVo.setVersion(20210524);
        dictInfoService.addDictInfoService(dictInfoVo);

        initAdd(catalogsList, dictInfoVo);
    }

    @Override
    public void initAdministrativeDivisions() throws Exception {
        String directory = "D:\\data";
        File file = new File(directory);
        File[] yearFiles = file.listFiles();
        for (File yearFile : yearFiles) {
            String yearName = yearFile.getName();
            if (yearName.endsWith("年")) {

                DictInfoVo dictInfoVo = new DictInfoVo();
                dictInfoVo.setDictCode(yearName);
                dictInfoVo.setDictName(yearName + "行政区划");
                dictInfoVo.setStatus(Boolean.TRUE);
                dictInfoVo.setDescription(dictInfoVo.getDictName());
                dictInfoVo.setRemarks(dictInfoVo.getDictName());
                dictInfoVo.setUseType("1");
                dictInfoVo.setVersion(20210520);
                dictInfoService.addDictInfoService(dictInfoVo);

                File[] provinceFiles = yearFile.listFiles();
                List<CatalogDto> catalogDtos = Lists.newArrayList();
                for (File provinceFile : provinceFiles) {
                    String provinceName = provinceFile.getName();
                    File[] cityFiles = provinceFile.listFiles();

                    CatalogDto provinceCatalogDto = null;
                    for (File cityFile : cityFiles) {
                        String cityName = cityFile.getName();
                        String newCityName = cityName.replace("(", "-").replace(")", "");

                        CatalogDto cityCatalogDto = new CatalogDto();
                        cityCatalogDto.setCode(newCityName.split("-")[0]);
                        cityCatalogDto.setName(newCityName.split("-")[1]);

                        if (provinceCatalogDto == null) {
                            String provinceFilePath = cityFile.getPath() + File.separator + provinceName + ".json";
                            File file1 = new File(provinceFilePath);
                            if (file1.exists()) {
                                String str = FileUtils.readFileToString(file1, "utf-8");
                                provinceCatalogDto = JSONObject.parseObject(str, CatalogDto.class);
                                provinceCatalogDto.setSub(Lists.newArrayList());
                            }
                        }

                        String cityFilePath = cityFile.getPath() + File.separator + cityName + ".json";
                        File file2 = new File(cityFilePath);
                        if (!file2.exists()) {
                            cityFilePath = cityFile.getPath() + File.separator + cityName + "-null.json";
                            file2 = new File(cityFilePath);
                        }
                        if (file2.exists()) {
                            String str = FileUtils.readFileToString(file2, "utf-8");
                            List<CatalogDto> townCatalogDtos = JSONArray.parseArray(str, CatalogDto.class);
                            cityCatalogDto.setSub(townCatalogDtos);
                        }

                        provinceCatalogDto.getSub().add(cityCatalogDto);
                    }

                    catalogDtos.add(provinceCatalogDto);
                }

                initAdd(catalogDtos, dictInfoVo);
            }
        }
    }

    @Override
    public void initCatalog() throws Exception {
        String directory = "D:\\data\\catalogs";
        File file = new File(directory);
        File[] files = file.listFiles();
        for (File f : files) {
            String name = f.getName();
            String filePath = f.getPath() + File.separator + name + ".json";
            String str = FileUtils.readFileToString(new File(filePath), "utf-8");

            DictInfoVo dictInfoVo = new DictInfoVo();
            dictInfoVo.setDictCode(name.split("-")[0] + "00");
            dictInfoVo.setDictName(name.split("-")[1]);
            dictInfoVo.setStatus(Boolean.TRUE);
            dictInfoVo.setDescription(dictInfoVo.getDictName());
            dictInfoVo.setRemarks(dictInfoVo.getDictName());
            dictInfoVo.setUseType("1");
            dictInfoVo.setVersion(20210520);
            dictInfoService.addDictInfoService(dictInfoVo);

            List<CatalogDto> catalogDtos = JSONArray.parseArray(str, CatalogDto.class);
            initAdd(catalogDtos, dictInfoVo);
        }
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

    /**
     * 初始化新增
     *
     * @param catalogDtos
     * @param dictInfoVo
     * @throws Exception
     */
    private void initAdd(List<CatalogDto> catalogDtos, DictInfoVo dictInfoVo) throws Exception {
        processCatalogTree(catalogDtos, 0, null, null);

        List<DictTableVo> dataList = Lists.newArrayList();
        catalogTreeToList(catalogDtos, dataList, dictInfoVo);
        dictTableService.batchAddDictTableService(dataList);
        log.info("字典代码：{},字典名称{},数据表：{},版本：{}", dictInfoVo.getDictCode(), dictInfoVo.getDictName(), dictInfoVo.getDataTable(), dictInfoVo.getVersion());
    }

    private Long getId() {
        return defaultIdentifierGenerator.nextId(null);
    }

    /**
     * 处理树结构
     *
     * @param catalogDtos
     * @param level
     * @param parentId
     * @param allParentId
     */
    private void processCatalogTree(List<CatalogDto> catalogDtos, Integer level, Long parentId, String allParentId) {
        if (CollectionUtils.isNotEmpty(catalogDtos)) {
            for (int index = 0, length = catalogDtos.size(); index < length; index++) {
                Long id = getId();
                CatalogDto catalogDto = catalogDtos.get(index);
                catalogDto.setSerialNumber(index + 1);
                catalogDto.setLevel(level);
                catalogDto.setId(id);
                catalogDto.setParentId(parentId);

                catalogDto.setAllParentId(allParentId);

                String str = allParentId == null ? id + "" : catalogDto.getAllParentId() + "," + id;

                processCatalogTree(catalogDto.getSub(), level + 1, id, str);
            }
        }
    }

    private void catalogTreeToList(List<CatalogDto> catalogDtos, List<DictTableVo> dataList, DictInfoVo dictInfoVo) {
        if (CollectionUtils.isNotEmpty(catalogDtos)) {
            for (CatalogDto catalogDto : catalogDtos) {
                List<CatalogDto> sub = catalogDto.getSub();

                DictTableVo dictTableVo = new DictTableVo();
                BeanUtils.copyProperties(catalogDto, dictTableVo);
                dictTableVo.setDictId(dictInfoVo.getId());
                dictTableVo.setVersion(dictInfoVo.getVersion());
                dataList.add(dictTableVo);

                catalogTreeToList(sub, dataList, dictInfoVo);
            }
        }
    }

}
