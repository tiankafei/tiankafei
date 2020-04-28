package cn.tiankafei.spring.dao.impl;

import cn.tiankafei.spring.bean.Student;
import cn.tiankafei.spring.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends BaseDao<Student> {

    @Override
    public void save() {
        System.out.println("保存学生");
    }
}