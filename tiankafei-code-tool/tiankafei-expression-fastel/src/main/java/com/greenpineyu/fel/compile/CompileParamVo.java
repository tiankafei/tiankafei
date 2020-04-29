package com.greenpineyu.fel.compile;

/**
 * @Author 魏双双
 * @Date 2020/1/15
 * @Version V1.0
 **/
public class CompileParamVo {

    /**
     * ID
     */
    private String id;

    /**
     * 包路径
     */
    private String packagePath;

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
