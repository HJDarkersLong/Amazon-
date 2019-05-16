package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created By HJ on 2019-04-03 11:50:56
 *
 * 说明 :
 */
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

    /**
     * 跟据sku_no 查询
     */
    List<JSONObject> queryBySku(JSONObject jsonObject);

    /**
     * 删除商品
     */
    int deleteGoodById(JSONObject jsonObject);
}
