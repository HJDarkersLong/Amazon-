package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.TransTypeDao;
import com.heeexy.example.service.TransTypeService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.DeleteStatus;
import com.heeexy.example.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author: hxy
 * @description: 用户/角色/权限
 * @date: 2017/11/2 10:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TransTypeServiceImpl implements TransTypeService {
	@Autowired
	private TransTypeDao transTypeDao;

	@Override
	public JSONObject addTransType(JSONObject jsonObject) throws Exception {
		jsonObject.put("type_id",UUID.randomUUID().toString());
		jsonObject.put("status", DeleteStatus.LIVE.getKey());
		jsonObject.put("create_date",new Timestamp(new Date().getTime()));
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(transTypeDao.addTransType(jsonObject)) {
			return CommonUtil.successJson(jsonObject);
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30001);
		}
	}

	@Override
	public JSONObject editTransType(JSONObject jsonObject) throws Exception{
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(transTypeDao.editTransType(jsonObject)) {
			return CommonUtil.successJson();
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30001);
		}
	}

	@Override
	public JSONObject delTransType(JSONObject jsonObject) throws Exception{
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(transTypeDao.delTransType(jsonObject)) {
			return CommonUtil.successJson(jsonObject);
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30004);
		}

	}

	@Override
	public JSONObject findTransTypeList(JSONObject jsonObject) throws Exception{
		CommonUtil.fillPageParam(jsonObject);
		int count = transTypeDao.getCount(jsonObject);
		List<JSONObject> list = transTypeDao.findTransTypeList(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject findTransType(JSONObject jsonObject) throws Exception {
		return CommonUtil.successJson(transTypeDao.findTransType(jsonObject));
	}

	@Override
	public JSONObject findAllTransType() {
		return CommonUtil.successJson(transTypeDao.findAllTransType());
	}

}
