package org.xzpm;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import org.service.xzpm.Info;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 校验上传
 */
public class InfoTest {
    Info info= new Info();
    /**
     * 电动车上传
     */
    @Test(testName ="电动自行车上传",priority = 1)
    public void electricTest() throws IOException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("file", FileUtil.file("C:\\Users\\ASUS\\Desktop\\批量导入模板\\新浙品码\\电动车信息导入模版.xlsx"));
        String result = info.electric(dataMap);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }
    /**
     * 电池上传
     */
    @Test(testName ="电池上传",priority = 1)
    public void batteryTest() throws IOException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("file", FileUtil.file("C:\\Users\\ASUS\\Desktop\\批量导入模板\\新浙品码\\电池信息导入模板.xlsx"));
        dataMap.put("uniscid","91330109589891087U");
        String result = info.battery(dataMap);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }

    /**
     * 电动车附件上传
     */
/*    @Test(testName ="电动自行车附件上传",priority = 1)
    public void bicyclesInfoTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/bicyclesInfo.json").toJSONString();
        String result = info.bicyclesInfo(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }*/
    /**
     * 电池附件上传
     */
/*    @Test(testName ="电池附件上传",priority = 1)
    public void batteryTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/").toJSONString();
        String result = info.electric(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }*/
    /**
     * 生产计量器具上传
     */
    @Test(testName ="生产计量器具上传",priority = 1)
    public void productImportTest() throws IOException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("file", FileUtil.file("C:\\Users\\ASUS\\Desktop\\批量导入模板\\新浙品码\\生产单位器具信息导入模版.xlsx"));
        String result = info.productImport(dataMap);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }

    /**
     * 使用计量器具上传
     */
    @Test(testName ="使用计量器具上传",priority = 1)
    public void usingImportTest() throws IOException {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("file", FileUtil.file("C:\\Users\\ASUS\\Desktop\\批量导入模板\\新浙品码\\使用单位器具信息导入模版.xlsx"));
        String result = info.usingImport(dataMap);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1, message);
    }

}
