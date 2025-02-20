package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.base.new_zpm.BasePath_New_ZPM;
import org.service.xzpm.SamplingProduct;
import org.service.xzpm.ZpmCode;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;
import java.util.HashMap;

public class ChangeBatchTest {
    static SamplingProduct samplingProduct = new SamplingProduct();

    static ZpmCode zpmCode = new ZpmCode();
    @Test(testName ="品类码创建校验",priority = 1)
    //品类码创建校验(json文件的LatsCode每次需要更新)
    public void samplingProductSaveTest() throws IOException, InterruptedException {
        Thread.sleep(7000);
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
        Thread.sleep(1000);
    }

    @Test(testName ="批次码创建校验",priority = 2)
    public void saveBatchTest() throws IOException, InterruptedException {
        JSONObject body = JsonFileUtils.readJson("/json/xzpm/request/saveBatch.json");
        String result = zpmCode.saveBatch(body.toJSONString());
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(message,result1);
        Thread.sleep(500);
        body.put("batchNo",222);
        zpmCode.saveBatch(body.toJSONString());
        Thread.sleep(500);
    }

    @Test(testName ="单品码创建校验",priority = 3)
    public void saveDpmTest() throws IOException, InterruptedException {
        JSONObject body = JsonFileUtils.readJson("/json/xzpm/request/saveDpm.json");
        String result = zpmCode.saveDpm(body.toJSONString());
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        body.put("batchNo",222);
        Thread.sleep(500);
        zpmCode.saveDpm(body.toJSONString());
        Thread.sleep(500);
        zpmCode.saveDpm(body.toJSONString());
        Thread.sleep(5000);
    }

    @Test(testName ="批次变更",priority = 4)
    public void changeBatchTest() throws IOException, InterruptedException {
        Thread.sleep(5000);
        //单个变更
        JSONObject body = JsonFileUtils.readJson("/json/xzpm/request/associatedWithBatchAndBarSingle.json");
        String result = zpmCode.associatedWithBatchAndBarSingle(body.toJSONString());
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        Thread.sleep(500);
        //批量变更
        JSONObject body1 = JsonFileUtils.readJson("/json/xzpm/request/associatedWithBatchAndBarBatch.json");
        String result2 = zpmCode.associatedWithBatchAndBarBatch(body1.toJSONString());
        String result3 = JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message);
        Thread.sleep(3000);
    }



    @Test(testName ="单品码删除校验",priority = 5)
    //单品码删除校验
    public void deleteDpmTest() throws IOException, InterruptedException {
        JSONObject body = JsonFileUtils.readJson("/json/xzpm/request/findPageDpm.json");
        String result = zpmCode.findPageDpm(body.toJSONString());
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeId");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SINGLE_ITEM_DELETE+ "?id="+id;
        String id1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(1).getString("codeId");
        String url1 = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SINGLE_ITEM_DELETE+ "?id="+id1;
        String id2 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(2).getString("codeId");
        String url2 = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SINGLE_ITEM_DELETE+ "?id="+id2;
        String result1 = zpmCode.deleteDpmById(url);
        Thread.sleep(500);
        zpmCode.deleteDpmById(url1);
        Thread.sleep(500);
        zpmCode.deleteDpmById(url2);
        String result2 =JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
        Thread.sleep(1000);
    }


    @Test(testName ="批次码删除校验",priority = 6)
    //批次码删除校验
    public void deleteBatchTest() throws  IOException {
        JSONObject body = JsonFileUtils.readJson("/json/xzpm/request/pcmFindPageByQuery.json");
        String result = zpmCode.findPageByQuery(body.toJSONString());
        body.put("batchCode",222);
        String result3 = zpmCode.findPageByQuery(body.toJSONString());
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeId");
        String id1 = JSONObject.parseObject(result3).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeId");

        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.BATCH_CODE_DELETE + "?id="+id;
        String url1 = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.BATCH_CODE_DELETE + "?id="+id1;

        String result1 = zpmCode.deleteBatch(url);
        zpmCode.deleteBatch(url1);

        String result2 = JSONObject.parseObject(result1).getString("message");

        Assert.assertEquals(result2,message);
    }

    @Test(testName ="品类码删除校验",priority = 7)
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

}
