package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.TransBaseService;
import com.heeexy.example.service.TransTypeService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hxy
 * @description: 文章相关Controller
 * @date: 2017/10/24 16:04
 */
@RestController
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private TransBaseService transBaseService;

    @Autowired
    private TransTypeService transTypeService;

    /**
     * 查询
     */
    @RequiresPermissions("transport:list")
    @GetMapping("/listTransport")
    public JSONObject listTransport(HttpServletRequest request) {
        return transBaseService.listTransport(CommonUtil.request2Json(request));
    }

    /**
     * 查询快递方式
     */
    @RequiresPermissions("transport:list")
    @GetMapping("/listAllTransType")
    public JSONObject listAllTransType(HttpServletRequest request){
        return transTypeService.findAllTransType();
    }

    /**
     * 查询运费
     */
    @RequiresPermissions("transport:list")
    @GetMapping("/findTransBaseList")
    public JSONObject findTransBaseList(HttpServletRequest request){
        return transBaseService.findTransBaseList(CommonUtil.request2Json(request));
    }

}
