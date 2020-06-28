package org.tiankafei.springdemo.service.impl;

import org.tiankafei.springdemo.dao.impl.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceExt extends PersonService{

    @Autowired
    private PersonDao personDao;

    @Override
    public void getPerson(){
        System.out.println("PersonServiceExt......");
        personDao.getPerson();
    }
}