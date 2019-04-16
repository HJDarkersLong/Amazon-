package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.TabService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.ErrorEnum;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hxy
 * @description: 用户/角色/权限相关controller
 * @date: 2017/11/2 10:19
 */
@RestController
@RequestMapping("/sort")
public class TabController {
    @Autowired
    private TabService tabService;

    /**
     * 查询文章列表
     */
    @RequiresPermissions("sort:list")
    @GetMapping("/listSort")
    public JSONObject findTabList(HttpServletRequest request){
        try {
            return tabService.findTabList(CommonUtil.request2Json(request));
        }catch (Exception e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_400);
        }
    }

    public JSONObject findTabInfo(HttpServletRequest request){
        try {
            return tabService.findTabInfo(CommonUtil.request2Json(request));
        }catch (Exception e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_400);
        }
    }

    public JSONObject addTabInfo(HttpServletRequest request){
        try {
            return tabService.addTabInfo(CommonUtil.request2Json(request));
        }catch (Exception e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_400);
        }
    }

    public JSONObject editTabInfo(HttpServletRequest request){
        try {
            return tabService.editTabInfo(CommonUtil.request2Json(request));
        }catch (Exception e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_400);
        }
    }

    public JSONObject delTabInfo(HttpServletRequest request){
        try {
            return tabService.delTabInfo(CommonUtil.request2Json(request));
        }catch (Exception e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_400);
        }
    }
}
