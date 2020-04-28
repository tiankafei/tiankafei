package cn.tiankafei.spring.dao.impl;

import cn.tiankafei.spring.bean.Teacher;
import cn.tiankafei.spring.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao extends BaseDao<Teacher> {

    @Override
    public void save() {
        System.out.println("保存老师");
    }
}