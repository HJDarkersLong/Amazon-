package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.TabDao;
import com.heeexy.example.service.TabService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.DeleteStatus;
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
						map.put("addAble",true);
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
