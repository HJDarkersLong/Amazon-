package com.heeexy.example.util.constants;

/**
 * @author: hxy
 * @description: 通用常量类, 单个业务的常量请单开一个类, 方便常量的分类管理
 * @date: 2017/10/24 10:15
 */
public class Constants {

	public static final String SUCCESS_CODE = "100";
	public static final String SUCCESS_MSG = "请求成功";
	public static final String FAILURE_MSG = "请求失败";

	public static final String ADD_FAILURE_MSG = "添加失败";
	public static final String DELETE_FAILURE_MSG = "删除失败";
	public static final String UPDATE_FAILURE_MSG = "更新失败";
	public static final String QUERY_FAILURE_MSG = "查询失败";

	/**
	 * session中存放用户信息的key值
	 */
	public static final String SESSION_USER_INFO = "userInfo";
	public static final String SESSION_USER_PERMISSION = "userPermission";
}
