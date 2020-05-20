package cn.tiankafei.springbootproject.service.impl;

import cn.tiankafei.springbootproject.repository.SpringBootRepository;
import cn.tiankafei.springbootproject.service.SpringBootService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 魏双双
 * @Date 2020/5/20
 * @Version V1.0
 **/
@Service
public class SpringBootServiceImpl implements SpringBootService {

    @Autowired
    private SpringBootRepository springBootRepository;

    @Override
    public List<Map<String, Object>> getAllData() {
        return springBootRepository.getAllData();
    }
}
