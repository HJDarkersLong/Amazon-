package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface TransTypeDao {

     boolean addTransType(JSONObject jsonObject);

     boolean editTransType(JSONObject jsonObject);

     boolean delTransType(JSONObject jsonObject);

     List<JSONObject> findTransTypeList(JSONObject jsonObject);

     Map<String,Object> findTransType(JSONObject jsonObject);

     Integer getCount(JSONObject jsonObject);

}
