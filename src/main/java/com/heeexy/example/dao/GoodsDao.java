package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface GoodsDao {
    /**
     * 新增商品
     */
    int addGoods(JSONObject jsonObject);

    /**
     * 统计商品总数
     */
    int countGoods(JSONObject jsonObject);

    /**
     * 商品列表
     */
    List<JSONObject> listGoods(JSONObject jsonObject);

    /**
     * 更新商品
     */
    int updateGoods(JSONObject jsonObject);
}
