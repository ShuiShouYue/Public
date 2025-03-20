package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.service.xzpm.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;
/**
 * 新增流程
 */
public class ProcessSave {
    MaterialMaterials materialMaterials= new MaterialMaterials();
    MaterialSuppliers materialSuppliers= new MaterialSuppliers();
    SamplingProduct samplingProduct = new SamplingProduct();
    static ZpmCode zpmCode = new ZpmCode();
    MaterialCustomers materialCustomers= new MaterialCustomers();
    MaterialPurchase materialPurchase= new MaterialPurchase();

    @Test(testName ="供应商创建校验",priority = 1)
    public void SuppliersSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialSuppliers.json").toJSONString();
        String result = materialSuppliers.save(body);
        String message = "成功";
        String result1 =JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);

    }
    @Test(testName ="原辅料创建校验",priority = 2)
    public void MaterialsSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialMaterials.json").toJSONString();
        String result = materialMaterials.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);

    }



    @Test(testName ="进货信息创建校验",priority = 3)
    public void PurchaseSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialPurchaseSave.json").toJSONString();
        String result = materialPurchase.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="品类码创建校验",priority = 4)
    //品类码创建校验(json文件的LatsCode每次需要更新)
    public void samplingProductSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/plmSave.json").toJSONString();
        String result = samplingProduct.plmSave(body);
        System.out.println(result);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        String message1 = "该浙品码在本系统中已存在，无法再次添加";
        String result2 = samplingProduct.plmSave(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message1);
    }

    @Test(testName ="批次码创建校验",priority = 5)
    //批次码创建校验(JSON文件每次需要变更批次码CODE（batchCode）的数据，因为批次码是软删除)
    public void saveBatchTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/saveBatch.json").toJSONString();
        String result = zpmCode.saveBatch(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(message,result1);
    }

    @Test(testName ="单品码创建校验",priority = 6)
    public void saveDpmTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/saveDpm.json").toJSONString();
        String result = zpmCode.saveDpm(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="经销商创建校验",priority = 7)
    public void customersSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialCustomersSave.json").toJSONString();
        String result = materialCustomers.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);

    }
    @Test(testName ="流向信息创建校验",priority = 8)
    public void saveFlowDetailsTest() throws IOException {
        JSONObject body1 = JsonFileUtils.readJson("/json/xzpm/request/saveFlowDetails.json");
        String result = zpmCode.saveFlowDetails(body1.toJSONString());
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }

  /*
      @Test(testName ="流向信息删除校验",priority = 8)
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

        @Test(testName ="经销商删除校验",priority = 9)
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

  @Test(testName ="单品码删除校验",priority = 10)
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

    @Test(testName ="批次码删除校验",priority = 11)
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

    @Test(testName ="品类码删除校验",priority = 12)
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
*//*        System.out.println(result1);
        System.out.println(parameters);*//*
        String result2 =JSONObject.parseObject(result1).getString("message");
        String message2 = "成功";
        Assert.assertEquals(result2,message2);
    }

    @Test(testName ="原辅料删除校验",priority = 13)
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

    @Test(testName ="供应商删除校验",priority = 14)
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
    }*/
}
