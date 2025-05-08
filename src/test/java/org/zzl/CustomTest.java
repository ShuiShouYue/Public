package org.zzl;

import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.base.new_zpm.BasePath_New_ZPM;
import org.service.zzl.Custom;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;

public class CustomTest {
    Custom custom = new Custom();
    @Test(testName ="客户创建校验",priority = 1)
    //模版查询校验
    public void saveTest() throws IOException {

        String body = JsonFileUtils.readJson("/json/zzl/request/customSave.json").toJSONString();
        String result = custom.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="客户查询校验",priority = 2)

    public void findTest() throws  IOException {

        String body = JsonFileUtils.readJson("/json/zzl/request/customFind.json").toJSONString();
        String result = custom.find(body);
        String message = "91310000717860307J";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("customUscc");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="客户删除校验",priority = 3)

    public void deleteTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/zzl/request/customFind.json").toJSONString();
        String result = custom.find(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        JSONArray list = new JSONArray();
        list.add(id);
        String result1 = custom.delete(list.toString());
        String result2 = JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);

    }
}
