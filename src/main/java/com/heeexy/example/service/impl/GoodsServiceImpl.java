package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.GoodsDao;
import com.heeexy.example.service.GoodsService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public JSONObject addGoods(JSONObject jsonObject) throws RuntimeException {
        // 将渠道链接转成字符串存在对象中
        handleDomainLinksToString(jsonObject);

        // 查询sku 编号是否唯一
        String sku_no = jsonObject.getString("sku_no");
        JSONObject json = new JSONObject();
        json.put("sku_no",sku_no);
        List<JSONObject> jsonObjects = goodsDao.queryBySku(json);
        if (jsonObjects.size() > 0){
            return CommonUtil.errorJson(ErrorEnum.E_30002);
        }
        goodsDao.addGoods(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listGoods(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        if(!CommonUtil.isEmpty(jsonObject.getString("categoryArray"))){
            String[] categoryArrays = jsonObject.getString("categoryArray").split(",");
            jsonObject.put("category_no",categoryArrays[categoryArrays.length -1]);
        }
        int count = goodsDao.countGoods(jsonObject);
        List<JSONObject> list = goodsDao.listGoods(jsonObject);
        list.forEach(json -> {
            handlePicAddressToArray(json);

            handleDomainLinksToArray(json);
        });

        return CommonUtil.successPage(jsonObject, list, count);
    }



    @Override
    public JSONObject updateGoods(JSONObject jsonObject) {
        // 将渠道链接转成字符串存在对象中
        handleDomainLinksToString(jsonObject);

        // 修改查询sku是否唯一
        String sku_no = jsonObject.getString("sku_no");
        JSONObject json = new JSONObject();
        json.put("sku_no",sku_no);
        List<JSONObject> queryBySku = goodsDao.queryBySku(json);
        if(queryBySku.size() == 1){//只查询到一条数据，判断该数据是否为正要修改的数据
            String editId = queryBySku.get(0).getString("id");
            if(!jsonObject.getString("id").equals(editId)){//sku相等，id不相等，证明不可修改，sku冲突
                return CommonUtil.errorJson(ErrorEnum.E_30002);
            }
        }
        if(queryBySku.size() >1 ) {
            return CommonUtil.errorJson(ErrorEnum.E_30003);
        }
        goodsDao.updateGoods(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject deleteGoodById(JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        JSONObject json = new JSONObject();
        json.put("id",id);
        goodsDao.deleteGoodById(json);
        return CommonUtil.successJson();
    }


    /**
     * Created By HJ on 2019-04-10 11:58:56
     *
     * 说明 : 处理图片地址数组
     */
    private void handlePicAddressToArray(JSONObject json) {
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
    private void handleDomainLinksToArray(JSONObject json) {
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
    }

    //处理链接地址将数组转成字符串类型存在数据库中
    private void handleDomainLinksToString (JSONObject jsonObject){
        ArrayList<String> domainArray = new ArrayList<>();
        ArrayList<HashMap<String, String>> domains = (ArrayList<HashMap<String, String>>) jsonObject.get("domains");
        if(!Objects.isNull(domains)){
            domains.forEach(domainMap -> {
                domainArray.add(domainMap.get("value"));
            });
            String domainString = domainArray.toString();
            jsonObject.put("domains",domainString);
        }
    }
}
