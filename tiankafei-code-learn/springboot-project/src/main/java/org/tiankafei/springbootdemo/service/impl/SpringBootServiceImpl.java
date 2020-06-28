package org.tiankafei.springbootdemo.service.impl;

import org.tiankafei.springbootdemo.repository.SpringBootRepository;
import org.tiankafei.springbootdemo.service.SpringBootService;
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
