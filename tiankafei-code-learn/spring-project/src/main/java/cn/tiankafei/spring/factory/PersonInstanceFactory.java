package cn.tiankafei.spring.factory;

import cn.tiankafei.spring.entity.Person001;

public class PersonInstanceFactory {
    public Person001 getPerson(String name){
        Person001 person = new Person001();
        person.setId(1);
        person.setName(name);
        return person;
    }
}