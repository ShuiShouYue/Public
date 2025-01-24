package org.jxzlj;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.base.jxzlj.BaseConst_JXZLJ;
import org.base.jxzlj.BasePath_JXZLJ;
import org.service.jxzlj.Apply;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;
import org.utils.random.name.RandomNames;
import org.utils.random.uid.Uid;

import java.io.IOException;
import java.util.ArrayList;
/**
 * 表格校验
 */
public class FormTest {
    Apply apply = new Apply();
    Uid uid = new Uid();
    RandomNames randomNames = new RandomNames();
    String ID = "";
    String name ="";
    @Test(testName ="登录申请人账号，必填项填写，点击保存，保存成功",priority = 1)
    public void formTest_1() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        name = randomNames.generateChineseName();
        String uuid = uid.getRandomString2(32);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/addQoApply.json");
        jsonObject.getJSONArray("declareFiles").getJSONObject(0).put("id",uuid);
        jsonObject.put("applyName",name);
        jsonObject.put("status","0");
        String body = jsonObject.toJSONString();

        String result = apply.addQoApply(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        ID = JSONObject.parseObject(result).getString("data");
        System.out.println(ID);
        Assert.assertEquals(result1,message);
        Thread.sleep(1000);
    }

    @Test(testName ="登录申请人账号，对已存在的保存数据进行修改操作，点击提交，修改成功",priority = 2)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void formTest_2() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        String url = BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_BY_ID;
        String url1 = url+"?id="+this.ID;
        String result = apply.findById_sqr(url1);
        JSONObject jsonObject = JSONObject.parseObject(result).getJSONObject("data");
        jsonObject.put("applyName","王大锤");
        System.out.println(jsonObject);
        String body = jsonObject.toJSONString();
        String result1 = apply.addQoApply(body);
        String message = "成功";
        String result2 = JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
        Thread.sleep(1000);
    }
    @Test(testName ="登录申请人账号，对已存在的保存数据进行删除操作，点击删除，删除成功",priority = 3)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void formTest_3() throws IOException, InterruptedException {

        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);
        ArrayList list = new ArrayList();
        list.add(this.ID);
        JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
        System.out.println(jsonObject);
        String body = jsonObject.toJSONString();
        String result = apply.delete(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        Thread.sleep(1000);
    }

    @Test(testName ="登录申请人账号，列表提交时，必填项未填写，提交失败",priority = 4)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void formTest_4() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/addQoApply.json");
        jsonObject.put("applyName","");
        String body = jsonObject.toJSONString();
        String result = apply.addQoApply(body);
        String message = "接口异常，请联系管理员";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        Thread.sleep(1000);
    }

    @Test(testName ="登录申请人账号，列表提交申请时，必填项均填写且输入规定长度限制内的数据，提交成功",priority = 5)
    public void formTest_5() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        name = randomNames.generateChineseName();
        String uuid = uid.getRandomString2(32);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/addQoApply.json");
        jsonObject.getJSONArray("declareFiles").getJSONObject(0).put("id",uuid);
        jsonObject.put("applyName",this.name);
        String body = jsonObject.toJSONString();

        String result = apply.addQoApply(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        Thread.sleep(1000);
    }
    @Test(testName ="登录申请人账号，列表提交申请时，输入超过规定长度限的数据，提交失败",priority = 6)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void formTest_6() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        name = randomNames.generateChineseName();
        String uuid = uid.getRandomString2(32);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/addQoApply.json");
        jsonObject.getJSONArray("declareFiles").getJSONObject(0).put("id",uuid);
        jsonObject.put("applyName",this.name);
        jsonObject.put("industry","分析影响行业发展的各种因素以及判断对行业的判断");
        String body = jsonObject.toJSONString();

        String result = apply.addQoApply(body);
        String message = "接口异常，请联系管理员";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        Thread.sleep(1000);
    }

}
