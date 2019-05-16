package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

public interface GoodsService {

    /**
     * 新增商品
     */
    JSONObject addGoods(JSONObject jsonObject);

    /**
     * 文章商品
     */
    JSONObject listGoods(JSONObject jsonObject);

    /**
     * 更新商品
     */
    JSONObject updateGoods(JSONObject jsonObject);

    /**
     * 删除商品
     * @param jsonObject
     * @return
     */
    JSONObject deleteGoodById (JSONObject jsonObject);
}
