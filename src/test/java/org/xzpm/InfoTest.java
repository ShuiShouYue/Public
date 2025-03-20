package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.service.xzpm.Company;
import org.service.xzpm.Info;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;
/**
 * 校验上传
 */
public class InfoTest {
    Info info= new Info();
    /**
     * 电动车上传
     */
    @Test(testName ="电动自行车",priority = 1)
    public void electricTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/").toJSONString();
        String result = info.electric(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }
    /**
     * 电池上传
     */
    @Test(testName ="电池",priority = 1)
    public void batteryTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/").toJSONString();
        String result = info.electric(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }

    /**
     * 生产计量器具上传
     */
    @Test(testName ="电池",priority = 1)
    public void productImportTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/").toJSONString();
        String result = info.productImport(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }

    /**
     * 使用计量器具上传
     */
    @Test(testName ="电池",priority = 1)
    public void usingImportTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/").toJSONString();
        String result = info.usingImport(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }

}
