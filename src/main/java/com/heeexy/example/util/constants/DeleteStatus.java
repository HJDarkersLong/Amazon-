package com.heeexy.example.util.constants;

public enum DeleteStatus {

    /**
     * 未删除.
     */
    LIVE("1", "未删除"),
    /**
     * 已删除.
     */
    DLETE("0", "已删除")

    ;

    DeleteStatus(String key, String value) {
        this.value = value;
        this.key = key;
    }

    private String key;// DB 存贮值
    private String value;// 值对应的中文描述

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
