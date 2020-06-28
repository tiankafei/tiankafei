package org.tiankafei.springdemo.dao.impl;

import org.tiankafei.springdemo.bean.Teacher;
import org.tiankafei.springdemo.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao extends BaseDao<Teacher> {

    @Override
    public void save() {
        System.out.println("保存老师");
    }
}