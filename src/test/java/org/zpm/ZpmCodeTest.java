package org.zpm;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import org.service.zpm.ZpmCode;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;
import org.utils.JsonFileUtils;
import java.io.IOException;
import com.alibaba.fastjson.JSONArray;

/**
 * 此类包含了批次码和单品码
 */
public class ZpmCodeTest {
    ZpmCode zpmCode = new ZpmCode();
    @Test(testName ="批次码创建校验",priority = 1)
    //批次码创建校验(每次需要变更批次码的数据，因为批次码是软删除)
    public void plmSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/zpm/request/saveBatch.json").toJSONString();
        String result = zpmCode.saveBatch(body);
        String message = "成功";
        String message1 = "批次码已存在，请勿重复添加！";
        String message2 = "重复操作";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(message,result1);
        String result2 = zpmCode.saveBatch(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message1);
    }

        @Test(testName ="批次码列表页查询校验",priority = 2)
    //批次码列表页查询校验
    public void findPageByQueryTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/zpm/request/pcmFindPageByQuery.json").toJSONString();
        String result = zpmCode.findPageByQuery(body);
        String message = "杭州丝绸1";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("productName");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="批次码删除校验",priority = 6)
    //批次码删除校验
    public void deleteBatchByIdTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/zpm/request/pcmFindPageByQuery.json").toJSONString();
        String result = zpmCode.findPageByQuery(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        JSONArray list = new JSONArray();
        list.add(id);
        String result1 = zpmCode.deleteBatch(list.toString());
        String result2 = JSONObject.parseObject(result1).getString("message");

        Assert.assertEquals(result2,message);
    }


    @Test(testName ="单品码创建校验",priority = 3)
    //单品码创建校验
    public void saveDpmTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/zpm/request/pcmFindPageByQuery.json").toJSONString();
        String result0 = zpmCode.findPageByQuery(body);
        String batchCode = JSONObject.parseObject(result0).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("batchCode");
        JSONObject body1 = JsonFileUtils.readJson("/json/zpm/request/saveDpm.json");
        body1.put("batchCode",batchCode);
        String result = zpmCode.saveDpm(body1.toJSONString());
        String message = "成功";
        String message1 = "单品码已存在，请勿重复添加！";
        String message2 = "重复操作";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        /*String result2 = zpmCode.saveDpm(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(message1,result3);*/
    }

    @Test(testName ="单品码列表页查询校验",priority = 4)
    //单品码列表页查询校验
    public void findPageDpmTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/zpm/request/pcmFindPageByQuery.json").toJSONString();
        String result = zpmCode.findPageDpm(body);
        String message = "杭州丝绸1";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("productName");
        Assert.assertEquals(result1,message);
        System.out.println(result);
    }

    @Test(testName ="单品码删除校验",priority = 5)
    //单品码删除校验
    public void deleteDpmByIdTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/zpm/request/pcmFindPageByQuery.json").toJSONString();
        String result = zpmCode.findPageDpm(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        JSONArray list = new JSONArray();
        list.add(id);
        String result1 = zpmCode.deleteDpmById(list.toString());
        String result2 =JSONObject.parseObject(result1).getString("message");

        Assert.assertEquals(result2,message);
    }

/*    public static void main(String[] args) throws IOException {
        ZpmCode zpmCode= new ZpmCode();
        String body = JsonFileUtils.readJson("/json/zpm/request/pcmFindPageByQuery.json").toJSONString();
        String result0 = zpmCode.findPageByQuery(body);
        String batchCode = JSONObject.parseObject(result0).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("batchCode");
        System.out.println(batchCode);
        JSONObject body1 = JsonFileUtils.readJson("/json/zpm/request/saveDpm.json");
        body1.put("batchCode",batchCode);
        System.out.println(body1);
    }*/


}
