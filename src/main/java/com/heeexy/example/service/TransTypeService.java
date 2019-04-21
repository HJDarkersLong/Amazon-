package com.heeexy.example.service;


import com.alibaba.fastjson.JSONObject;

/**
 * @author: hxy
 * @description: 运输方式
 * @date: 2017/11/2 10:18
 */
public interface TransTypeService {

	public JSONObject addTransType(JSONObject jsonObject) throws Exception;

	public JSONObject editTransType(JSONObject jsonObject) throws Exception;

	public JSONObject delTransType(JSONObject jsonObject) throws Exception;

	public JSONObject findTransTypeList(JSONObject jsonObject) throws Exception;

	public JSONObject findTransType(JSONObject jsonObject) throws Exception;

}
