package org.tiankafei.aviator.extend.model;

public class ExpModel {

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 开始位置
     */
    private int startIndex;

    /**
     * 结束位置
     */
    private int endIndex;

    /**
     * 左括号出现的次数
     */
    private int leftBracketsCount;

    /**
     * 表达式字符串
     */
    private StringBuilder expBuilder;

    /**
     * 嵌套下一个表达式模型
     */
    private ExpModel next;


    /**
     * 嵌套上一个表达式模型
     */
    private ExpModel previous;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getLeftBracketsCount() {
        return leftBracketsCount;
    }

    public void setLeftBracketsCount(int leftBracketsCount) {
        this.leftBracketsCount = leftBracketsCount;
    }

    public StringBuilder getExpBuilder() {
        return expBuilder;
    }

    public void setExpBuilder(StringBuilder expBuilder) {
        this.expBuilder = expBuilder;
    }

    public ExpModel getNext() {
        return next;
    }

    public void setNext(ExpModel next) {
        this.next = next;
    }

    public ExpModel getPrevious() {
        return previous;
    }

    public void setPrevious(ExpModel previous) {
        this.previous = previous;
    }
}
