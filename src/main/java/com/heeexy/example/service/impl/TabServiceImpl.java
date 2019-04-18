package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.TabDao;
import com.heeexy.example.service.TabService;
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
public class TabServiceImpl implements TabService {
	@Autowired
	private TabDao tabDao;

	@Override
	public JSONObject addTabInfo(JSONObject jsonObject) throws Exception {
		jsonObject.put("type_id",UUID.randomUUID().toString());
		if("1".equals(jsonObject.getString("level"))){
			jsonObject.put("type_id_1",jsonObject.getString("type_id"));
		}
		else if("2".equals(jsonObject.getString("level"))){
			jsonObject.put("type_id_2",jsonObject.getString("type_id"));
			jsonObject.put("type_id_1",jsonObject.getString("parentId"));
		}
		else if("3".equals(jsonObject.getString("level"))){
			jsonObject.put("type_id_3",jsonObject.getString("type_id"));
			jsonObject.put("type_id_2",jsonObject.getString("parentId"));
		}
		jsonObject.put("status", DeleteStatus.LIVE.getKey());
		jsonObject.put("create_date",new Timestamp(new Date().getTime()));
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(tabDao.addTabInfo(jsonObject)) {
			jsonObject.put("label",jsonObject.getString("name"));
			if(jsonObject.getIntValue("level")<3){
				jsonObject.put("addAble",true);
			}else{
				jsonObject.put("addAble",false);
			}
			jsonObject.put("delAble",true);
			return CommonUtil.successJson(jsonObject);
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30001);
		}
	}

	@Override
	public JSONObject editTabInfo(JSONObject jsonObject) throws Exception{
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(tabDao.editTabInfo(jsonObject)) {
			return CommonUtil.successJson();
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30001);
		}
	}

	@Override
	public JSONObject delTabInfo(JSONObject jsonObject) throws Exception{
		if(jsonObject.getString("level").equals("3")){
			tabDao.delTabInfo(jsonObject);
			return CommonUtil.successJson(jsonObject);
		}
		Integer sortsCount = tabDao.getSortsCount(jsonObject);
		if(sortsCount > 0){
			return CommonUtil.errorJson(ErrorEnum.E_30005);
		}
		if(tabDao.delTabInfo(jsonObject)) {
			return CommonUtil.successJson(jsonObject);
		}else{
			return CommonUtil.errorJson(ErrorEnum.E_30004);
		}

	}

	@Override
	public JSONObject findTabListToTree(JSONObject jsonObject) throws Exception{
		List<Map<String,Object>> list=tabDao.findTabAllList();//所有的分类
		List<Map<String,Object>> type=new ArrayList<>();//所有一级分类
		if(list!=null && list.size()>0){
			List<Map<String,Object>> type2=new ArrayList<>();//所有二级分类

			// 遍历所有数据筛选出一级分类放入type
			for(Map<String,Object> map:list){
				Map<String,Object> m=new HashMap<>();
				if(!CommonUtil.isEmpty(map.get("type_id_1")) && CommonUtil.isEmpty(map.get("type_id_2"))){
					m.put("label",map.get("name"));
					m.put("id",map.get("type_id"));
					m.put("addAble",true);
					m.put("delAble",true);
					type.add(m);
				}
			}

			// 遍历所有分类筛选出二级分类 放入 type2
			for(Map<String,Object> map:list){
				Map<String,Object> m=new HashMap<>();
				if(!CommonUtil.isEmpty(map.get("type_id_2")) && CommonUtil.isEmpty(map.get("type_id_3"))){
					m.put("label",map.get("name"));
					m.put("id",map.get("type_id"));
					m.put("parentId",map.get("type_id_1"));
					m.put("addAble",true);
					m.put("delAble",true);
					type2.add(m);
				}
			}

			// 遍历所有的二级分类 type2 将三级分类注入到二级分类中
			for(Map<String,Object> m:type2){
				List<Map<String,Object>> children=new ArrayList<>();
				for(Map<String,Object> map:list){
					if(!CommonUtil.isEmpty(map.get("type_id_3"))
							&& CommonUtil.getString(m.get("id")).equals(CommonUtil.getString(map.get("type_id_2"))) ){
						map.put("label",map.get("name"));
						map.put("id",map.get("type_id"));
						map.put("parentId",map.get("type_id_2"));
						map.put("addAble",false);
						map.put("delAble",true);
						children.add(map);
					}
				}
				m.put("children",children);
			}
			// 遍历所有的一级分类  吧二级分类注入进去
			for(Map<String,Object> m:type){
				List<Map<String,Object>> children=new ArrayList<>();
				for(Map<String,Object> map:type2){
					if(CommonUtil.getString(m.get("id")).equals(CommonUtil.getString(map.get("parentId"))) ){
						children.add(map);
					}
				}
				m.put("children",children);
			}
		}
		return CommonUtil.successJson(type);
	}

	@Override
	public JSONObject findTabList(JSONObject jsonObject) throws Exception{
		CommonUtil.fillPageParam(jsonObject);
		int count = tabDao.getCount(jsonObject);
		List<JSONObject> list = tabDao.findTabList(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject findTabInfo(JSONObject jsonObject) throws Exception{
		return CommonUtil.successJson(tabDao.findTabInfo(jsonObject));
	}
}
