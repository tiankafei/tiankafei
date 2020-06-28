package org.tiankafei.springdemo.factory;

import org.tiankafei.springdemo.entity.Person001;

public class PersonInstanceFactory {
    public Person001 getPerson(String name){
        Person001 person = new Person001();
        person.setId(1);
        person.setName(name);
        return person;
    }
}