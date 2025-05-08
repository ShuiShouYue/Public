package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.base.new_zpm.BasePath_New_ZPM;
import org.service.xzpm.MaterialPurchase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;
/**
 * 进货信息
 */
public class MaterialPurchaseTest {
    MaterialPurchase materialPurchase= new MaterialPurchase();
    @Test(testName ="进货信息创建校验",priority = 1)
    public void PurchaseSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialPurchaseSave.json").toJSONString();
        String result = materialPurchase.save(body);
        String message = "成功";
        String message1 = "模板名称重复,换一个试试!";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
/*        String result2 = materialSuppliers.save(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message1);*/
    }

    @Test(testName ="进货信息查询校验",priority = 2)
    public void PurchaseFindPageByQueryTest() throws IOException, InterruptedException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialPurchaseFind.json").toJSONString();
        String result = materialPurchase.findPageByQuery(body);
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("materialName");
        String message = "瓶塞";
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="进货信息删除校验",priority = 3)
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
