package cn.tiankafei.spring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode()
public class Person002 {
    private int id;
    private String name;
    private int age;
    private String gender;

    public Person002() {
    }

    public Person002(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person002(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}