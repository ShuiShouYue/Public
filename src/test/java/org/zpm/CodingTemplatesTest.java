package org.zpm;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.base.BasePath;
import org.service.zpm.CodingTemplates;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Properties;

@Slf4j
/**
 * 此类包含了首页和模版
 */
public class CodingTemplatesTest {

    CodingTemplates codingTemplates = new CodingTemplates();
//验证首页数据
    @Test(testName ="首页数据校验",priority = 1)
    public void findByUsccTest() throws IOException {
        String url = BasePath.ZPM_IP + BasePath.GET_COMPANY_INFO;
        String result = codingTemplates.findByUscc(url);
        JSONObject data = JSONObject.parseObject(result).getJSONObject("data");
        System.out.println(data);
        String companyName = data.getString("companyName");
        String fmplNum = data.getString("fmplNum");
        String batchCodeNum = data.getString("batchCodeNum");
        String serCodeNum = data.getString("serCodeNum");
        System.out.println(result);
        Assert.assertEquals(companyName, "浙江金汇数字技术有限公司");
        Assert.assertEquals(fmplNum, "102" );
        Assert.assertEquals(batchCodeNum, "22" );
        Assert.assertEquals(serCodeNum, "64" );
    }

    @Test(testName ="模版创建校验",priority = 2)
    //模版创建校验
    public void templatesSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/zpm/request/templatesSave.json").toJSONString();
        String result = codingTemplates.templatesSave(body);
        String message = "成功";
        String message1 = "模板名称重复,换一个试试!";
        String result1 =JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        String result2 = codingTemplates.templatesSave(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message1);
    }

    @Test(testName ="模版列表页查询校验",priority = 3)
    //模版列表页查询校验
    public void findPageByQueryTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/zpm/request/mbfindPageByQuery.json").toJSONString();
        String result = codingTemplates.findPageByQuery(body);
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("templateName");
        String message = "模版一";
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="模版删除校验",priority = 4)
    //模版删除
    public void templatesDeleteTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/zpm/request/mbfindPageByQuery.json").toJSONString();
        String result = codingTemplates.findPageByQuery(body);
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        log.info("模板ID："+id);
        JSONArray list = new JSONArray();
        list.add(id);
        String result1 = codingTemplates.templatesDelete(list.toString());
        String result2 = JSONObject.parseObject(result1).getString("message");
        String message = "成功";
        Assert.assertEquals(result2,message);
    }

 /*
   public static void main(String[] args) throws IOException {
        CodingTemplatesTest codingTemplatesTest = new CodingTemplatesTest();
        codingTemplatesTest.templatesSave();

    }*/






}
