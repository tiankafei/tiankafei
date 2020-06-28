package org.tiankafei.springdemo.service.impl;

import org.tiankafei.springdemo.dao.impl.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public void save(){
        teacherDao.save();
    }
}