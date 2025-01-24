package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.base.new_zpm.BasePath_New_ZPM;
import org.service.xzpm.MaterialSuppliers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;

public class MaterialSuppliersTest {
    MaterialSuppliers materialSuppliers= new MaterialSuppliers();
    @Test(testName ="供应商创建校验",priority = 1)
    public void SuppliersSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialSuppliers.json").toJSONString();
        String result = materialSuppliers.save(body);
        String message = "成功";
        String message1 = "模板名称重复,换一个试试!";
        String result1 =JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
/*        String result2 = materialSuppliers.save(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message1);*/
    }

    @Test(testName ="供应商查询校验",priority = 2)
    public void SuppliersFindPageByQueryTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageByQuery.json").toJSONString();
        String result = materialSuppliers.findPageByQuery(body);
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("supplierName");
        String message = "厦门红酒酒进出口有限公司";
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="供应商删除校验",priority = 3)
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
}
