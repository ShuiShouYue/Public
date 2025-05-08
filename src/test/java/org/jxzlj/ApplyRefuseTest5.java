package org.jxzlj;

import com.alibaba.fastjson.JSONObject;
import org.base.jxzlj.BaseConst_JXZLJ;
import org.base.jxzlj.BasePath_JXZLJ;
import org.service.jxzlj.Apply;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;
import org.utils.random.name.RandomNames;
import org.utils.random.uid.Uid;

import java.io.IOException;

public class ApplyRefuseTest5 {
    Apply apply = new Apply();
    Uid uid = new Uid();
    RandomNames randomNames = new RandomNames();
    String ID = "";
    String name = "";
    @Test(testName ="登录申请人账号，质量官申请并提交",priority = 1)

    public void addQoApplyTest() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);
        name = randomNames.generateChineseName();
        String uuid = uid.getRandomString2(32);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/addQoApply.json");
        jsonObject.getJSONArray("declareFiles").getJSONObject(0).put("id",uuid);
        jsonObject.put("applyName",name);
        String body = jsonObject.toJSONString();

        String result = apply.addQoApply(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        ID = JSONObject.parseObject(result).getString("data");
        System.out.println(ID);
        Assert.assertEquals(result1,message);
        Thread.sleep(1000);

    }

    @Test(testName ="登录区/县级市场监管局账号，区/县级审批通过",priority = 2)
    //区县审核通过
    public void audit_pass_xianTest() throws IOException, InterruptedException {
        String login = apply.login("Q3YJgDLmc4XCvbGBOBA27Sfm591CPKKd7vg6O20Ab2ZXdExTrEhxOMu4cJ2tcb85RqtPy2B7TqlcEq1muLXzx+Nk1a1vKx8B/v87yunkmNeTi74sVy9ujjJOSHuxm/tCFz1b73QJuKU/w6/ufBdS4v0DHxjRKMPoXBpHmrBkz6k=","cuubBlSXJs0ESHfWaSwdkXMBJZQ72NTWYtYaO692RN/4kNpCBvR5qJjSax5WhL5miVy9soKhVljyXGtMYLvNY/kuS6xlZUBDqWDGNesiYFPnbmD7AtdqeX/jBkj4kl8YZUHPUs1lKRd+rhQbk69VfHk+m59GHx4CD/aHwP3DU3w=");
        BaseConst_JXZLJ.setToken_zlj_xian(login);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_pass.json");
        jsonObject.put("id",this.ID);
        String body = jsonObject.toJSONString();
        String result = apply.audit_xian(body);
        Thread.sleep(1000);
    }

    @Test(testName ="登录市市场监管局账号，市级审批通过",priority = 3)
    //市级审核通过
    public void audit_pass_shiTest() throws IOException, InterruptedException {
        String login = apply.login("S1MiSzmkkJpVmZq8bFfkkhHGu+9033afcPzpSC8qyf2VPyF5RDW8FhkkOHBCXn2qoVZBpYhC0krVeLUZMq11wOh6nmTPPnsPVOMz9C1YQeM1IsY27GfN+SJFlmi2ynO5kkKvE09WudCFPgo9EEsvk9Hoz2R+t8DQSIMnn9qxenE=","cna3r0gIN8AaYl6Mp5FRMVotbl0FsxDSpVTjy9SMJGlsxM1J875BWmQwWd7FEoNsyHby1VxqDMg7QkKhb7S87xvGZHMCsV+LP/TARBs4EOVcr38Wn8JSBeQ6r7+B31Z0zfcTFMEH4Jljh7q1pthGPnqDqU5NtSW5EMMBn9JiJYc=");
        BaseConst_JXZLJ.setToken_zlj_shi(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_pass.json");
        jsonObject.put("id",this.ID);
        jsonObject.put("flowStatus",20);
        String body = jsonObject.toJSONString();
        String result = apply.audit_shi(body);
        Thread.sleep(1000);
    }
    @Test(testName ="登录省市场监管局账号，省级审批通过",priority = 4)

    public void audit_pass_shengTest() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_pass.json");
        jsonObject.put("id",this.ID);
        jsonObject.put("flowStatus",30);
        String body = jsonObject.toJSONString();
        String result = apply.audit_sheng(body);
        Thread.sleep(1000);
    }
    @Test(testName ="登录省市场监管局账号，分配专家",priority = 5)

    public void applyGroupTest() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);
        System.out.println(ID);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/applyGroup.json");
        jsonObject.getJSONArray("applyIds").set(0,this.ID);
        String body = jsonObject.toJSONString();
        String result = apply.applyGroup(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        System.out.println(ID);
        Thread.sleep(1000);
    }
    @Test(testName ="登录专家账号，专家审核通过并上传材料",priority = 6)

    public void audit_zjTest() throws IOException, InterruptedException {
        String login = apply.login("fWc7VySov1OGXs208kTajiFZteovxnCOTNnwRDn1f+qwNLWbqbcCxyUybn0+sRowKKW6J24QN/d5JuhyT84FC0hjcwqxemH9lFEVMZHelqXI8QWKA8KrMo5Ca8l06seoYW5YyF6gfynQgVl7S/T2BORYblLF+8P4WnjIrj2EBOk=","mVgnYLLOAuXVGft96zPcZYYx8AuI8R36prFM6G0dzx/AvkSRSmCW6L4BXBMjULXmcobIeRxiM+QaZNJIagTOY9PDp8NlpIYW2FC7lMUYhon7oqMLNTgdYZDl7AW5MKBRW8qp+uy61Md2/DDmwDOg0D/DDIHxzO6MXcNWim6Q544=");
        BaseConst_JXZLJ.setToken_zlj_zj(login);
        //查询详细信息取出id
        String url = BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_BY_ID;
        String url1 = url+"?id="+this.ID;
        String result = apply.findById_zj(url1);
        String id = JSONObject.parseObject(result).getJSONObject("data").getString("id");
        //分别赋值给json文件的参数
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/saveExpertFile.json");
        jsonObject.put("id",this.ID);
        jsonObject.getJSONArray("expertFiles").getJSONObject(0).put("id",id);

        String body = jsonObject.toJSONString();
        String result1 = apply.audit_zj(body);
        System.out.println(result1);
        String message = "成功";
        String result2 = JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
        Thread.sleep(1000);
    }
    @Test(testName ="登录省市场监管局账号，综合审核通过",priority = 7)
    public void audit_pass_zhTest() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_pass.json");
        jsonObject.put("id",this.ID);
        jsonObject.put("flowStatus",40);
        String body = jsonObject.toJSONString();
        String result = apply.audit_sheng(body);
        Thread.sleep(1000);
    }
    @Test(testName ="登录申请人账号，申请人上传任命文件，提交成功",priority = 8)

    public void audit_rmwjTest() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_pass.json");
        jsonObject.put("id",this.ID);
        jsonObject.put("flowStatus",50);
        String body = jsonObject.toJSONString();
        String result = apply.audit_rmwj(body);
        Thread.sleep(1000);
    }
    @Test(testName ="登录省市场监管局账号，备案审核不通过",priority = 9)
    public void audit_pass__baTest() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_refuse.json");
        jsonObject.put("id",this.ID);
        jsonObject.put("flowStatus",60);
        String body = jsonObject.toJSONString();
        String result = apply.audit_sheng(body);
        Thread.sleep(1000);
    }
    @Test(testName ="备案审核不通过，登录省级账号，输入姓名，查询用户流转节点，验证流转节点是,已归档（不通过）",priority = 10)
    //查询
    public void findByIdTest() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=", "jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        String url = BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_BY_ID;
        String url1 = url + "?id=" + this.ID;
        String result = apply.findById_sheng(url1);
        String flowStatusTxt = JSONObject.parseObject(result).getJSONObject("data").getString("flowStatusTxt");
        String advices = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("flows").getJSONObject(6).getString("advices");
        String message = "已归档";
        String message1 = "不通过";
        Assert.assertEquals(flowStatusTxt, message);
        Assert.assertEquals(advices, message1);
        Thread.sleep(1000);
    }
}
