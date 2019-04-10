package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.GoodsDao;
import com.heeexy.example.service.GoodsService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public JSONObject addGoods(JSONObject jsonObject) {
        goodsDao.addGoods(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listGoods(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = goodsDao.countGoods(jsonObject);
        List<JSONObject> list = goodsDao.listGoods(jsonObject);
        list.forEach(json -> {
            handlePicAddress(json);

            handleDomainLinks(json);
        });

        return CommonUtil.successPage(jsonObject, list, count);
    }



    @Override
    public JSONObject updateGoods(JSONObject jsonObject) {
        ArrayList<String> domainArray = new ArrayList<>();
        ArrayList<HashMap<String, String>> domains = (ArrayList<HashMap<String, String>>) jsonObject.get("domains");
        domains.forEach(domainMap -> {
            domainArray.add(domainMap.get("value"));
        });
        String domainString = domainArray.toString();
        jsonObject.put("domains",domainString);
        goodsDao.updateGoods(jsonObject);
        return CommonUtil.successJson();
    }


    /**
     * Created By HJ on 2019-04-10 11:58:56
     *
     * 说明 : 处理图片地址数组
     */
    private void handlePicAddress(JSONObject json) {
        if(((String)json.get("pic_address")).contains(",")){
            json.put("pic_address",Arrays.asList(((String)json.get("pic_address")).split(",")));
        }else{
            String[] array = { (String)json.get("pic_address") };
            json.put("pic_address",array);
        }
    }

    /**
     * Created By HJ on 2019-04-10 11:58:08
     *
     * 说明 : json处理链接数组，传到前台
     */
    private void handleDomainLinks(JSONObject json) {
        if(json.get("domains") != null){
//                if(((String)json.get("domains")).contains(",")){
            //数据库获取的链接数组字符串
            String domainsString = ((String) json.get("domains")).replace("[", "").replace("]", "");

            //数组数据
            List<String> arrays = Arrays.asList(domainsString.split(","));

            //每一份数据做成一个map放在ArrayList里面
            HashMap<String, String> stringHashMap = new HashMap<>();

            //正是这个ArrayList
            ArrayList<HashMap<String, String>> domainsArray = new ArrayList<>();

            arrays.forEach(arrayString -> {
                HashMap<String, String> mapValue = new HashMap<>();
                mapValue.put("value",arrayString);
                domainsArray.add(mapValue);
            });

            json.put("domains",domainsArray);
        }
//            }
    }
}
