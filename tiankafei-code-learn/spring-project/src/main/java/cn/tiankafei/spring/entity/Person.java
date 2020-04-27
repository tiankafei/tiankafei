package cn.tiankafei.spring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
@Accessors(chain = true)
@EqualsAndHashCode()
public class Person {
    private Integer id;
    private String name="dahuang";
    private Integer age;
    private String gender;
    private Address address;
    private String[] hobbies;
    private List<Book> books;
    private Set<Integer> sets;
    private Map<String,Object> maps;
    private Properties properties;

    public Person(Integer id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        System.out.println("有参构造器");
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
        System.out.println("Age");
    }

    public Person(Integer id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        System.out.println("gender");
    }

    public Person() {
    }
}