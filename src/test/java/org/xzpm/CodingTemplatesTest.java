package org.xzpm;
import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.service.xzpm.CodingTemplates;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;

@Slf4j
/**
 * 此类包含了首页和模版
 */
public class CodingTemplatesTest {

    CodingTemplates codingTemplates = new CodingTemplates();
    @Test(testName ="模版创建校验",priority = 1)
    //模版创建校验
    public void templatesSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/templatesSave.json").toJSONString();
        String result = codingTemplates.templatesSave(body);
        String message = "成功";
        String message1 = "模板名称重复,换一个试试!";
        String result1 =JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
/*        String result2 = codingTemplates.templatesSave(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message1);*/
    }

    @Test(testName ="模版列表页查询校验",priority = 2)
    //模版列表页查询校验
    public void findPageByQueryTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/mbfindPageByQuery.json").toJSONString();
        String result = codingTemplates.findPageByQuery(body);
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("templateName");
        String message = "通用模版";
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="模版删除校验",priority = 3)
    //模版删除
    public void templatesDeleteTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/mbfindPageByQuery.json").toJSONString();
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







}
