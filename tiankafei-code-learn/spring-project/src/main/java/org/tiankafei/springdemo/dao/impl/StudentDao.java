package org.tiankafei.springdemo.dao.impl;

import org.tiankafei.springdemo.bean.Student;
import org.tiankafei.springdemo.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends BaseDao<Student> {

    @Override
    public void save() {
        System.out.println("保存学生");
    }
}