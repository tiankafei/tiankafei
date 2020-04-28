package cn.tiankafei.spring.service.impl;

import cn.tiankafei.spring.dao.impl.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public void save(){
        studentDao.save();
    }
}