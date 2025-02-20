package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.base.new_zpm.BasePath_New_ZPM;
import org.service.xzpm.MaterialCustomers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;
/**
 * 销售单位信息
 */
public class MaterialCustomersTest {
    MaterialCustomers materialCustomers= new MaterialCustomers();
    @Test(testName ="销售单位创建校验",priority = 1)
    public void customersSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/materialCustomersSave.json").toJSONString();
        String result = materialCustomers.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
/*
        String message1 = "模板名称重复,换一个试试!";
        String result2 = materialSuppliers.save(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message1);*/
    }

    @Test(testName ="销售单位查询校验",priority = 2)
    public void customersFindPageByQueryTest() throws IOException {
        JSONObject jsonObject= JsonFileUtils.readJson("/json/xzpm/request/customersFindPageByQuery.json");
        String body = jsonObject.toString();
        String result = materialCustomers.findPageByQuery(body);
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("customerName");
        String message = "经销商家";
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="销售单位删除校验",priority = 3)
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
}
