package org.tiankafei.web.generate.properties;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class CfgProperties implements Serializable {

    private String controllerConstName;
    private String serviceConstName;
    private String mapperConstName;
    private String entityConstName;

    private String voClassName;
    private String voConstName;

    private String listParamClassName;
    private String listParamConstName;

    private String countParamClassName;
    private String countParamConstName;

    private String deleteParamClassName;
    private String deleteParamConstName;

    private String checkParamClassName;
    private String checkParamConstName;

    private String pageParamClassName;
    private String pageParamConstName;

    private boolean shiroAuthority;
    private String authority;

    private List<String> importPackageList;






}
