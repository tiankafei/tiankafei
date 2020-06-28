package org.tiankafei.springdemo.service.impl;

import org.tiankafei.springdemo.dao.impl.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public void getPerson(){
        personDao.getPerson();
    }

}