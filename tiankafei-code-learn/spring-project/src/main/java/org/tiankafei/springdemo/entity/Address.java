package org.tiankafei.springdemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode()
public class Address {
    private String province;
    private String city;
    private String town;

    public Address() {
        System.out.println("address被创建了");
    }

    public Address(String province, String city, String town) {
        this.province = province;
        this.city = city;
        this.town = town;
    }

    public void init(){
        System.out.println("对象被初始化");
    }

    public void destory(){
        System.out.println("对象被销毁");
    }
}