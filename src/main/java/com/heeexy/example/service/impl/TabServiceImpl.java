package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.TabDao;
import com.heeexy.example.dao.UserDao;
import com.heeexy.example.service.TabService;
import com.heeexy.example.service.UserService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.DeleteStatus;
import com.heeexy.example.util.constants.ErrorEnum;
import javafx.scene.control.Tab;
import org.apache.commons.lang3.StringUtils;
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
		if("1".equals(jsonObject.getString("level")))
			jsonObject.put("type_id_1",UUID.randomUUID().toString());
		else if("2".equals(jsonObject.getString("level")))
			jsonObject.put("type_id_2",UUID.randomUUID().toString());
		else if("3".equals(jsonObject.getString("level")))
			jsonObject.put("type_id_3",UUID.randomUUID().toString());
		jsonObject.put("status", DeleteStatus.LIVE.getKey());
		jsonObject.put("create_date",new Timestamp(new Date().getTime()));
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(tabDao.addTabInfo(jsonObject)) {
			throw new Exception("添加失败");
		}
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject editTabInfo(JSONObject jsonObject) throws Exception{
		jsonObject.put("update_date",new Timestamp(new Date().getTime()));
		if(tabDao.editTabInfo(jsonObject)) {
			throw new Exception("修改失败");
		}
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject delTabInfo(JSONObject jsonObject) throws Exception{
		if(tabDao.delTabInfo(jsonObject)) {
			throw new Exception("删除失败");
		}
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject findTabListToTree(JSONObject jsonObject) throws Exception{
		List<Map<String,Object>> list=tabDao.findTabAllList();
		List<Map<String,Object>> type=new ArrayList<>();
		if(list!=null && list.size()>0){
			List<Map<String,Object>> type2=new ArrayList<>();
			for(Map<String,Object> map:list){
				Map<String,Object> m=new HashMap<>();
				if(!CommonUtil.isEmpty(map.get("type_id_1")) && CommonUtil.isEmpty(map.get("type_id_2"))){
					m.put("lable",map.get("name"));
					m.put("value",map.get("type_id"));
					type.add(m);
				}
			}
			for(Map<String,Object> map:list){
				Map<String,Object> m=new HashMap<>();
				if(!CommonUtil.isEmpty(map.get("type_id_2")) && CommonUtil.isEmpty(map.get("type_id_3"))){
					m.put("lable",map.get("name"));
					m.put("value",map.get("type_id"));
					m.put("type_id_1",map.get("type_id_1"));
					type2.add(m);
				}
			}
			for(Map<String,Object> m:type2){
				List<Map<String,Object>> children=new ArrayList<>();
				for(Map<String,Object> map:list){
					if(!CommonUtil.isEmpty(map.get("type_id_3"))
							&& CommonUtil.getString(m.get("value")).equals(CommonUtil.getString(map.get("type_id_2"))) ){
						map.put("lable",map.get("name"));
						map.put("value",map.get("type_id"));
						children.add(map);
					}
				}
				m.put("children",children);
			}
			for(Map<String,Object> m:type){
				List<Map<String,Object>> children=new ArrayList<>();
				for(Map<String,Object> map:type2){
					if(CommonUtil.getString(m.get("value")).equals(CommonUtil.getString(map.get("type_id_1"))) ){
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
