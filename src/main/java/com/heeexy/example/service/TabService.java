package com.heeexy.example.service;


import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author: hxy
 * @description: 用户/角色/权限
 * @date: 2017/11/2 10:18
 */
public interface TabService {

	public JSONObject addTabInfo(JSONObject jsonObject) throws Exception;

	public JSONObject editTabInfo(JSONObject jsonObject) throws Exception;

	public JSONObject delTabInfo(JSONObject jsonObject) throws Exception;

	public JSONObject findTabList(JSONObject jsonObject) throws Exception;

	public JSONObject findTabInfo(JSONObject jsonObject) throws Exception;

	public JSONObject findTabListToTree(JSONObject jsonObject) throws Exception;
}
