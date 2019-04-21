package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface TransBaseDao {

     boolean addTransBase(JSONObject jsonObject);

     boolean editTransBase(JSONObject jsonObject);

     boolean delTransBase(JSONObject jsonObject);

     List<JSONObject> findTransBaseList(JSONObject jsonObject);

     Map<String,Object> findTransBase(JSONObject jsonObject);

     Integer getCount(JSONObject jsonObject);

     /**
      * 通过运输方式删除运输基础数据
      * @param jsonObject
      * @return
      */
     boolean  delTransBaseByTransType(JSONObject jsonObject);

}
