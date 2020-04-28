package cn.tiankafei.spring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode()
public class Person001 {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;

    public Person001() {
    }

    public Person001(Integer id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}