package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface TabDao {

     boolean addTabInfo(JSONObject jsonObject);

     boolean editTabInfo(JSONObject jsonObject);

     boolean delTabInfo(JSONObject jsonObject);

     List<JSONObject> findTabList(JSONObject jsonObject);

     Map<String,Object> findTabInfo(JSONObject jsonObject);

     Integer getCount(JSONObject jsonObject);

     List<Map<String,Object>> findTabAllList();

     Integer getSortsCount (JSONObject jsonObject);
}
