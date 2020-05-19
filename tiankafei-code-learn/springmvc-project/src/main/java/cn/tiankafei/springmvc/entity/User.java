package cn.tiankafei.springmvc.entity;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Accessors(chain = true)
public class User {

    private Integer id;

    @NotBlank(message = "名称不能为空！")
    private String name;
    private Integer age;
    private String gender;
    private Date date;
    private Address address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

}