package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.GoodsService;
import com.heeexy.example.service.LoginService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.DeleteStatus;
import com.heeexy.example.util.constants.GoodsStatus;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    /*测试测试*/

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private LoginService loginService;

    /**
     * 查询商品列表
     */
    @RequiresPermissions("goods:list")
    @GetMapping("/listGoods")
    public JSONObject listGoods (HttpServletRequest request) {
        return goodsService.listGoods(CommonUtil.request2Json(request));
    }

    /**
     * 添加商品
     */
    @RequiresPermissions("goods:add")
    @PostMapping("/addGoods")
    public JSONObject addGoods (@RequestBody JSONObject requestJson) {
        JSONObject info = loginService.getInfo();
        System.out.println(info);
        requestJson.put("create_date",new Timestamp(new Date().getTime()));
        requestJson.put("update_date",new Timestamp(new Date().getTime()));
        requestJson.put("delete_status",DeleteStatus.DLETE.getKey());
        /*CommonUtil.hasAllRequired(requestJson,
                "name,cn_name,en_name,pcl_no,sku_no," +
                        "other_name,cn_customs_name,en_customs_name,hs_code,category_no," +
                        "tag_no,brand_no,business_dev_user_no, buy_qus_user_no, buy_user_no," +
                        "length,width,height,weight,body_weight_5000,body_weight_6000,base_price," +
                        "sale_price,pic_address,description,easy_discription,key_code,status," +
                        "create_by,create_date,update_by, update_date,remarks");*/
        CommonUtil.hasAllRequired(requestJson,
                "name,sku_no," +
                        "er_no," +
                        "length,width,height,weight,body_weight_5000,body_weight_6000,base_price," +
                        "sale_price,status,");
        return goodsService.addGoods(requestJson);
    }

    /**
     * 获取商品所有状态信息
     */
    @GetMapping("/getGoodsStatus")
    public JSONObject getGoodsStatus (){
        Map<String, String> goodsStatusMap = GoodsStatus.goodsStatusMap;
        JSONObject requestJson = new JSONObject();
        requestJson.put("goodsStatusEnums",goodsStatusMap);
        return requestJson;
    }

}
