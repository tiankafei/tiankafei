package org.tiankafei.nexus;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.nexus.model.*;
import org.tiankafei.nexus.request.HttpUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class TestMain {

    private static AtomicInteger atomicInteger = new AtomicInteger(9);

    public static void main(String[] args) {
        String node = "cn/com/thtf";
        int tid = atomicInteger.get();
        String url = "http://10.10.50.201:8081/service/extdirect";
        String cookie = "";

        PerParamDTO perParamDTO = new PerParamDTO(url, node, tid, cookie);
        List<String> nodeList = Arrays.asList("gx-collection", "", "", "");
        perParamDTO.setNodeList(nodeList);

        requestRoot(perParamDTO);


    }

    public static void requestRoot(PerParamDTO perParamDTO) {
        RootParamDTO rootParamDTO = new RootParamDTO();
        rootParamDTO.setTid(perParamDTO.getTid());

        ParamRepositoryNameDTO paramRepositoryNameDTO = new ParamRepositoryNameDTO();
        paramRepositoryNameDTO.setNode(perParamDTO.getNode());
        rootParamDTO.getData().add(paramRepositoryNameDTO);

        String res = HttpUtil.syncBlockExecuteAnalysis(perParamDTO.getCookie(), perParamDTO.getUrl(), JSON.toJSONString(rootParamDTO));
        RootResultDTO rootResultDTO = JSON.parseObject(res, RootResultDTO.class);

        RootResultStatusDTO result = rootResultDTO.getResult();
        if (!result.isSuccess()) {
            return;
        }
        List<ResultRepositoryNameDTO> data = result.getData();
        data.stream().filter(resultRepositoryNameDTO -> {
            String id = resultRepositoryNameDTO.getId();
            List<String> nodeList = perParamDTO.getNodeList();
            boolean flag = false;
            for (String node : nodeList) {
                if (StringUtils.isBlank(node)) {
                    continue;
                }
                flag = id.endsWith(node);
                if (flag) {
                    break;
                }
            }
            return flag;
        }).forEach(resultRepositoryNameDTO -> {
            RootParamDTO tmpRootParamDTO = new RootParamDTO();
            tmpRootParamDTO.setTid(atomicInteger.getAndAdd(1));

            ParamRepositoryNameDTO tmpParamRepositoryNameDTO = new ParamRepositoryNameDTO();
            tmpParamRepositoryNameDTO.setNode(resultRepositoryNameDTO.getId());
            tmpRootParamDTO.getData().add(tmpParamRepositoryNameDTO);

            String str = HttpUtil.syncBlockExecuteAnalysis(perParamDTO.getCookie(), perParamDTO.getUrl(), JSON.toJSONString(tmpRootParamDTO));
            RootResultDTO tmpRootResultDTO = JSON.parseObject(str, RootResultDTO.class);
            RootResultStatusDTO resultStatusDTO = tmpRootResultDTO.getResult();
            if(resultStatusDTO.isSuccess()){
                Map<String, List<ResultRepositoryNameDTO>> collectMap = resultStatusDTO.getData().stream().filter(resultRepositoryNameDTO1 -> {
                    return "component".equals(resultRepositoryNameDTO1.getType());
                }).collect(Collectors.groupingBy(TestMain::getVersion));

                Set<Map.Entry<String, List<ResultRepositoryNameDTO>>> entries = collectMap.entrySet();
                for (Map.Entry<String, List<ResultRepositoryNameDTO>> entry : entries) {
                    List<ResultRepositoryNameDTO> valueList = entry.getValue();
                    if(valueList.size() > perParamDTO.getMaxCount()){
                        valueList = valueList.stream().sorted(TestMain::sort).collect(Collectors.toList());
                        for (int index = perParamDTO.getMaxCount(), lenth = valueList.size(); index < lenth; index++) {
                            ResultRepositoryNameDTO resultRepositoryNameDTO1 = valueList.get(index);

                            DeleteRepositoryNameDTO deleteRepositoryNameDTO = new DeleteRepositoryNameDTO();
                            deleteRepositoryNameDTO.setId(resultRepositoryNameDTO1.getComponentId());
                            deleteRepositoryNameDTO.setGroup(perParamDTO.getNode().replaceAll("/", "."));
                            deleteRepositoryNameDTO.setVersion(resultRepositoryNameDTO1.getText());
                            deleteRepositoryNameDTO.setName(resultRepositoryNameDTO.getText());

                            DeleteParamDTO deleteParamDTO = new DeleteParamDTO();
                            deleteParamDTO.setTid(atomicInteger.getAndAdd(1));
                            deleteParamDTO.getData().add(JSON.toJSONString(deleteRepositoryNameDTO, SerializerFeature.WriteMapNullValue));

                            String deleteStr = HttpUtil.syncBlockExecuteAnalysis(perParamDTO.getCookie(), perParamDTO.getUrl(), JSON.toJSONString(deleteParamDTO));
                            DeleteResultDTO deleteResultDTO = JSON.parseObject(deleteStr, DeleteResultDTO.class);
                            DeleteStatusResultDTO result1 = deleteResultDTO.getResult();
                            if(result1.isSuccess()){

                            }else{
                                log.info("删除仓库失败，删除的仓库是：{}，版本为：{}，失败原因：{}", deleteRepositoryNameDTO.getName(), deleteRepositoryNameDTO.getVersion(), result1.getMessage());
                            }
                        }
                    }
                }
            }
        });
    }

    private static int sort(ResultRepositoryNameDTO repositoryNameDTO1, ResultRepositoryNameDTO repositoryNameDTO2){
        return repositoryNameDTO2.getText().compareTo(repositoryNameDTO1.getText());
    }

    private static String getVersion(ResultRepositoryNameDTO repositoryNameDTO){
        String text = repositoryNameDTO.getText();
        return text.substring(0, text.indexOf("-"));
    }

}
