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
}