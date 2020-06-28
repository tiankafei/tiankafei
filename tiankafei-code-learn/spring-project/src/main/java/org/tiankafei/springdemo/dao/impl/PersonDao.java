package org.tiankafei.springdemo.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("personDao")
@Scope(value="prototype")
public class PersonDao {

    public void getPerson(){
        System.out.println("PersonDao:getPerson");
    }

}