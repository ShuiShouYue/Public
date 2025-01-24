package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.service.xzpm.Company;
import org.service.xzpm.MaterialCustomers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;

public class CompanyTest {
    Company company= new Company();
    @Test(testName ="企业信息保存校验",priority = 1)
    public void customersSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/companyUpdate.json").toJSONString();
        String result = company.update(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }
}
