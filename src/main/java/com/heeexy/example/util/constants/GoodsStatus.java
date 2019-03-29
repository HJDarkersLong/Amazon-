package com.heeexy.example.util.constants;

import java.util.HashMap;
import java.util.Map;

public enum GoodsStatus {
    /**
     * 待定.
     */
    WAIT( "待定","1"),
    /**
     * 上架.
     */
    UP( "上架","2"),
    /**
     * 下架.
     */
    DOWN ("下架","3"),
    /**
     * 上架.
     */
    SHIELD("屏蔽","4" ),
    /**
     * 上架.
     */
    UDELETE( "删除","5"),

    ;
    GoodsStatus(String name, String key) {
        this.name = name;
        this.key = key;
    }

    private String key;// DB 存贮值
    private String name;// 值对应的中文描述

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Map<String, String> goodsStatusMap = new HashMap<>();
    static {
        GoodsStatus[] statuses = GoodsStatus.values();
        for (GoodsStatus status : statuses) {
            goodsStatusMap.put(String.valueOf(status.key),status.name);
        }
    }
}
