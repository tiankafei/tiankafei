package cn.tiankafei.springmvc.entity;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Date date;
    private Address address;

}