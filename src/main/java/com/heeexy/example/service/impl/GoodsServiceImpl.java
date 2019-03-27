package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.GoodsDao;
import com.heeexy.example.service.GoodsService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public JSONObject addGoods(JSONObject jsonObject) {
        goodsDao.addGoods(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listGoods(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = goodsDao.countGoods(jsonObject);
        List<JSONObject> list = goodsDao.listGoods(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject updateGoods(JSONObject jsonObject) {
        goodsDao.updateGoods(jsonObject);
        return CommonUtil.successJson();
    }
}
