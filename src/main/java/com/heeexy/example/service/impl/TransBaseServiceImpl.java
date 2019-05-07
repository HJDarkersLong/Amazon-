package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.TransBaseDao;
import com.heeexy.example.dao.TransTypeDao;
import com.heeexy.example.service.TransBaseService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.DeleteStatus;
import com.heeexy.example.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author: hxy
 * @description: 用户/角色/权限
 * @date: 2017/11/2 10:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TransBaseServiceImpl implements TransBaseService {
	@Autowired
	private TransBaseDao transBaseDao;
	@Autowired
    private TransTypeDao transTypeDao;

	@Override
	public JSONObject addTransBase(JSONObject jsonObject) throws Exception {
		jsonObject.put("type_id",UUID.randomUUID().toString());
		jsonObject.put("status", DeleteStatus.LIVE.getKey());
		jsonObject.put("create_date",new Timestamp(new Date().getTime()));
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		//最小重量为0.01kg
		if(CommonUtil.isEmpty(jsonObject.getString("min_weight")) || Double.parseDouble(jsonObject.getString("min_weight"))<0.01)
			jsonObject.put("min_weight",new BigDecimal(0.01));
		if(transBaseDao.addTransBase(jsonObject)) {
			return CommonUtil.successJson(jsonObject);
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30001);
		}
	}

	@Override
	public JSONObject editTransBase(JSONObject jsonObject) throws Exception{
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(transBaseDao.editTransBase(jsonObject)) {
			return CommonUtil.successJson();
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30001);
		}
	}

	@Override
	public JSONObject delTransBase(JSONObject jsonObject) throws Exception{
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(transBaseDao.delTransBase(jsonObject)) {
			return CommonUtil.successJson(jsonObject);
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30004);
		}

	}

	/**
	 * 通过运输方式删除基础数据
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	@Override
	public JSONObject delTransBaseByTransType(JSONObject jsonObject) throws Exception{
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(transBaseDao.delTransBaseByTransType(jsonObject)) {
			return CommonUtil.successJson(jsonObject);
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30004);
		}

	}

	@Override
	public JSONObject findTransBaseList(JSONObject jsonObject) {
		String contry_name=jsonObject.getString("contry_name");
		BigDecimal weight=new BigDecimal(jsonObject.getString("weight"));
		CommonUtil.fillPageParam(jsonObject);
		int count = transBaseDao.getCount(jsonObject);
		List<JSONObject> list = transBaseDao.findTransBaseList(jsonObject);
		//计算数据并排序  运费公式   操作费  +  运费单价/1000 * 重量
		if(list!=null && list.size()>0){
			for(JSONObject json:list){
				BigDecimal operCost=new BigDecimal(json.getString("oper_cost"));//操作费
				BigDecimal freightPrice=new BigDecimal(json.getString("freight_price"));//运费单价
				BigDecimal transPrice=new BigDecimal(0);//操作费
//				transPrice=operCost.add(freightPrice.divide(new BigDecimal(1000)).multiply(weight));
				transPrice=operCost.add(freightPrice.multiply(weight));
				json.put("transPrice",transPrice);

			}
			/* 排序 */
			Collections.sort(list, new Comparator<JSONObject>() {
				public int compare(JSONObject a, JSONObject b) {
					if(Double.parseDouble(a.getString("transPrice"))>Double.parseDouble(b.getString("transPrice")))
						return 1;
					else if(Double.parseDouble(a.getString("transPrice"))<Double.parseDouble(b.getString("transPrice")))
						return -1;
					else
						return 0;
				}
			});
		}
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject findTransBase(JSONObject jsonObject) throws Exception {
		return CommonUtil.successJson(transBaseDao.findTransBase(jsonObject));
	}

	@Override
	public JSONObject listTransport(JSONObject jsonObject)  {
		CommonUtil.fillPageParam(jsonObject);
		int count = transBaseDao.getCount(jsonObject);
        List<JSONObject> list = transBaseDao.findTransBaseList(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}


}
