package org.xzpm;
import com.alibaba.fastjson.JSONObject;
import org.service.xzpm.ZpmCode;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;
import org.base.new_zpm.BasePath_New_ZPM;
import java.io.IOException;

/**
 * 此类包含了批次码和单品码
 */
public class ZpmCodeTest {
    static ZpmCode zpmCode = new ZpmCode();
    @Test(testName ="批次码创建校验",priority = 1)

    public void saveBatchTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/saveBatch.json").toJSONString();
        String result = zpmCode.saveBatch(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(message,result1);
    }

    @Test(testName ="批次码列表页查询校验",priority = 2)

    public void batchFindPageByQueryTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/pcmFindPageByQuery.json").toJSONString();
        String result = zpmCode.findPageByQuery(body);
        String message = "工业";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("productName");
        Assert.assertEquals(result1,message);
    }


    @Test(testName ="批次码删除校验",priority = 3)

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


    @Test(testName ="单品码创建校验",priority = 4)
    public void saveDpmTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/saveDpm.json").toJSONString();
        String result = zpmCode.saveDpm(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="单品码列表页查询校验",priority = 5)

    public void findPageDpmTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageDpm.json").toJSONString();
        String result = zpmCode.findPageDpm(body);
        String message = "细工木板";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("productName");
        Assert.assertEquals(result1,message);
        System.out.println(result);
    }

    @Test(testName ="单品码删除校验",priority = 6)

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

    @Test(testName ="流向信息创建校验",priority = 7)
    public void saveFlowDetailsTest() throws IOException {
        JSONObject body1 = JsonFileUtils.readJson("/json/xzpm/request/saveFlowDetails.json");
        String result = zpmCode.saveFlowDetails(body1.toJSONString());
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="流向信息列表页查询校验",priority = 8)
    public void flowDetailsfindPageDpmTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/flowDetailsfindPageDpm.json").toJSONString();
        String result = zpmCode.flowDetailsFindByIdDpm(body);
        String message = "经销商家";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("buyerName");
        Assert.assertEquals(result1,message);
        System.out.println(result);
    }

    @Test(testName ="流向信息删除校验",priority = 9)
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
