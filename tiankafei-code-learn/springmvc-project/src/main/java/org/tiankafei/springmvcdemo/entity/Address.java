package org.tiankafei.springmvcdemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {

    private String province;
    private String city;
    private String town;

}