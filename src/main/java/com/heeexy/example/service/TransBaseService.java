package com.heeexy.example.service;


import com.alibaba.fastjson.JSONObject;

/**
 * @author: hxy
 * @description: 运输方式
 * @date: 2017/11/2 10:18
 */
public interface TransBaseService {

	public JSONObject addTransBase(JSONObject jsonObject) throws Exception;

	public JSONObject editTransBase(JSONObject jsonObject) throws Exception;

	public JSONObject delTransBase(JSONObject jsonObject) throws Exception;

	public JSONObject delTransBaseByTransType(JSONObject jsonObject) throws Exception;

	public JSONObject findTransBaseList(JSONObject jsonObject) ;

	public JSONObject findTransBase(JSONObject jsonObject) throws Exception;

	public JSONObject listTransport(JSONObject jsonObject) ;

}
