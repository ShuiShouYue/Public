package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.base.new_zpm.BasePath_New_ZPM;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;
import org.service.xzpm.MaterialMaterials;
import java.io.IOException;
/**
 * 原材料管理
 */
public class MaterialMaterialsTest {
    MaterialMaterials materialMaterials= new MaterialMaterials();
    @Test(testName ="原辅料创建校验",priority = 1)
    public void MaterialsSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialMaterials.json").toJSONString();
        String result = materialMaterials.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
/*
        String message1 = "模板名称重复,换一个试试!";
        String result2 = materialSuppliers.save(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message1);*/
    }

    @Test(testName ="原辅料查询校验",priority = 2)
    public void MaterialsFindPageByQueryTest() throws IOException {
        JSONObject jsonObject= JsonFileUtils.readJson("/json/xzpm/request/findPageByQuery.json");
        jsonObject.put("purchaseBatchNo","111");
        jsonObject.put("specification","3A");
        String body = jsonObject.toString();
        System.out.println(body);
        String result = materialMaterials.findPageByQuery(body);
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("supplierName");
        String message = "厦门红酒酒进出口有限公司";
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="原辅料删除校验",priority = 3)
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
}
