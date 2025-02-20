package org.xzpm;

import org.base.new_zpm.BasePath_New_ZPM;
import org.service.xzpm.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;
import java.util.HashMap;
/**
 * 删除流程
 */
public class ProcessDelete {
    MaterialMaterials materialMaterials= new MaterialMaterials();
    MaterialSuppliers materialSuppliers= new MaterialSuppliers();
    SamplingProduct samplingProduct = new SamplingProduct();
    static ZpmCode zpmCode = new ZpmCode();
    MaterialCustomers materialCustomers= new MaterialCustomers();
    MaterialPurchase materialPurchase= new MaterialPurchase();
    @Test(testName ="流向信息删除校验",priority = 1)
    public void deleteFlowDetailsTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/flowDetailsfindPageDpm.json").toJSONString();
        String result = zpmCode.flowDetailsFindByIdDpm(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.FLOW_DETAILS_DELETE+ "?id="+id;
        System.out.println(url);
        String result1 = zpmCode.deleteFlowDetails(url);
        String result2 =JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
    }

    @Test(testName ="经销商删除校验",priority = 2)
    public void customersDeleteTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/customersFindPageByQuery.json").toJSONString();
        String result = materialCustomers.findPageByQuery(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.CUSTOMERS_DELETE+ "?id="+id;
        System.out.println(url);
        String result1 = materialCustomers.delete(url);
        String result2 =JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
    }

  @Test(testName ="单品码删除校验",priority = 3)
    //单品码删除校验
    public void deleteDpmTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageDpm.json").toJSONString();
        String result = zpmCode.findPageDpm(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeId");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SINGLE_ITEM_DELETE+ "?id="+id;
        System.out.println(url);
        String result1 = zpmCode.deleteDpmById(url);
        String result2 =JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
    }


    @Test(testName ="批次码删除校验",priority = 4)
    //批次码删除校验
    public void deleteBatchTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/pcmFindPageByQuery.json").toJSONString();
        String result = zpmCode.findPageByQuery(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeId");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.BATCH_CODE_DELETE + "?id="+id;
        String result1 = zpmCode.deleteBatch(url);
        String result2 = JSONObject.parseObject(result1).getString("message");

        Assert.assertEquals(result2,message);
    }

    @Test(testName ="品类码删除校验",priority = 5)
    //品类码删除校验
    public void setProductQRCodeInvalidTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageCompanyProduct.json").toJSONString();
        String result = samplingProduct.findPageCompanyProduct(body);
        String CodeID = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeId");
        String UnifiedCode =JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("unifiedCode");

        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put( "codeId" ,CodeID );
        objectObjectHashMap.put( "unifiedCode" ,UnifiedCode );
        String parameters = JSONObject.toJSONString(objectObjectHashMap);
        String result1 = samplingProduct.setProductQRCodeInvalid(parameters);
        System.out.println(result1);
        System.out.println(parameters);
        String result2 =JSONObject.parseObject(result1).getString("message");
        String message2 = "成功";
        Assert.assertEquals(result2,message2);
    }

    @Test(testName ="原材料删除校验",priority = 6)
    public void MaterialsDeleteTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageByQuery.json").toJSONString();
        String result = materialMaterials.findPageByQuery(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.MATERIALS_DELETE+ "?id="+id;
        System.out.println(url);
        String result1 = materialMaterials.delete(url);
        String result2 =JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
    }

    @Test(testName ="供应商删除校验",priority = 7)
    public void SuppliersDeleteTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageByQuery.json").toJSONString();
        String result = materialSuppliers.findPageByQuery(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SUPPLIERS_DELETE+ "?id="+id;
        System.out.println(url);
        String result1 = materialSuppliers.delete(url);
        String result2 =JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
    }

    @Test(testName ="进货信息删除校验",priority = 8)
    public void PurchaseDeleteTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialPurchaseFind.json").toJSONString();
        String result = materialPurchase.findPageByQuery(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.MATERIAL_PURCHASE_DELETE+ "?id="+id;
        System.out.println(url);
        String result1 = materialPurchase.delete(url);
        String result2 =JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
    }
}
