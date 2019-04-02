package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.GoodsDao;
import com.heeexy.example.service.GoodsService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
        list.forEach(json -> {
            if(((String)json.get("pic_address")).contains(",")){
                json.put("pic_address",Arrays.asList(((String)json.get("pic_address")).split(",")));
            }else{
                String[] array = { (String)json.get("pic_address") };
                json.put("pic_address",array);
            }
        });

        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject updateGoods(JSONObject jsonObject) {
        goodsDao.updateGoods(jsonObject);
        return CommonUtil.successJson();
    }
}
