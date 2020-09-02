package org.tiankafei.ui.report.enums;

/**
 * @author 魏双双
 */
public enum ActionIdentificationEnum {

    /**********************************快速形成表样*************************************/
    AFTER_ADD("AFTER_ADD", "向后新增"),
    AFTER_COPY_ADD("AFTER_COPY_ADD", "向后复制新增"),
    BEFORE_ADD("BEFORE_ADD", "向前新增"),
    BEFORE_COPY_ADD("BEFORE_COPY_ADD", "向前复制新增"),
    KNIFE_DIRECT_NODE("KNIFE_DIRECT_NODE", "刀型直接节点"),
    LEFT_KNIFE_TYPE("LEFT_KNIFE_TYPE", "左侧刀型"),
    RIGHT_KNIFE_TYPE("RIGHT_KNIFE_TYPE", "右侧刀型"),
    PARENT_AND_SUB("PARENT_AND_SUB", "父子级"),

    /**********************************操作报表*************************************/
    ADD_REPORT("ADD_REPORT", "新建报表"),
    OPEN_REPORT("OPEN_REPORT", "打开报表"),
    SAVE_REPORT("SAVE_REPORT", "保存报表"),
    SAVEAS_REPORT("SAVEAS_REPORT", "另存报表"),
    COPY("COPY", "复制"),
    CUT("CUT", "剪切"),
    PASTE("PASTE", "粘贴"),
    UN_GO_BACK("UN_GO_BACK", "恢复"),
    GO_BACK("GO_BACK", "撤销"),
    DELETE("DELETE", "删除单元格"),
    RESET("RESET", "重置"),
    INSERT_ROW("INSERT_ROW", "插入行"),
    DELETE_ROW("DELETE_ROW", "删除行"),
    INSERT_COL("INSERT_COL", "插入列"),
    DELETE_COL("DELETE_COL", "删除列"),
    MERGE("MERGE", "合并单元格"),
    UN_MERGE("UN_MERGE", "取消单元格合并"),
    CELL_STYPE("CELL_STYPE", "单元格格式"),
    BORDER("BORDER", "边框"),
    GENERAL("GENERAL", "普通对齐"),
    LEFT("LEFT", "左对齐"),
    CENTER("CENTER", "居中对齐"),
    RIGHT("RIGHT", "右对齐"),
    DISTRIBUTE("DISTRIBUTE", "两端对齐"),
    BOLD("BOLD", "加粗"),
    BEVELED("BEVELED", "倾斜"),
    UNDERLINED("UNDERLINED", "下划线"),
    FOREGROUND("FOREGROUND", "前景色"),
    BACKGROUND("BACKGROUND", "背景色"),
    FREEZE("FREEZE", "冻结"),
    UN_FREEZE("UN_FREEZE", "取消冻结"),
    SEARCH("SEARCH", "搜索"),
    FULL_SCREEN("FULL_SCREEN", "全屏"),
    RULE_MANAGE("RULE_MANAGE", "规则引擎"),
    ;

    private String code;

    private String name;

    ActionIdentificationEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
