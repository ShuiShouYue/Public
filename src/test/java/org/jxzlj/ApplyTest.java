package org.jxzlj;

import com.alibaba.fastjson.JSONObject;
import lombok.val;
import org.base.BaseConst_JXZLJ;
import org.base.BasePath_JXZLJ;
import org.service.jxzlj.Apply;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;

public class ApplyTest {
    Apply apply = new Apply();
    String ID = "";
    @Test(testName ="质量官申请并提交校验",priority = 1)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void addQoApplyTest() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);
        String body = JsonFileUtils.readJson("/json/jxzlj/request/addQoApply.json").toJSONString();
        String result = apply.addQoApply(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        ID = JSONObject.parseObject(result).getString("data");
        Assert.assertEquals(result1,message);

    }

    @Test(testName ="区/县级审批通过",priority = 2)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void audit_xianTest() throws IOException {
        String login = apply.login("Q3YJgDLmc4XCvbGBOBA27Sfm591CPKKd7vg6O20Ab2ZXdExTrEhxOMu4cJ2tcb85RqtPy2B7TqlcEq1muLXzx+Nk1a1vKx8B/v87yunkmNeTi74sVy9ujjJOSHuxm/tCFz1b73QJuKU/w6/ufBdS4v0DHxjRKMPoXBpHmrBkz6k=","cuubBlSXJs0ESHfWaSwdkXMBJZQ72NTWYtYaO692RN/4kNpCBvR5qJjSax5WhL5miVy9soKhVljyXGtMYLvNY/kuS6xlZUBDqWDGNesiYFPnbmD7AtdqeX/jBkj4kl8YZUHPUs1lKRd+rhQbk69VfHk+m59GHx4CD/aHwP3DU3w=");
        BaseConst_JXZLJ.setToken_zlj_xian(login);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_pass.json");
        jsonObject.put("id",this.ID);
        String body = jsonObject.toJSONString();
        String result = apply.audit_xian(body);

    }

   @Test(testName ="市级级审批通过",priority = 3)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void audit_shiTest() throws IOException {
        String login = apply.login("S1MiSzmkkJpVmZq8bFfkkhHGu+9033afcPzpSC8qyf2VPyF5RDW8FhkkOHBCXn2qoVZBpYhC0krVeLUZMq11wOh6nmTPPnsPVOMz9C1YQeM1IsY27GfN+SJFlmi2ynO5kkKvE09WudCFPgo9EEsvk9Hoz2R+t8DQSIMnn9qxenE=","cna3r0gIN8AaYl6Mp5FRMVotbl0FsxDSpVTjy9SMJGlsxM1J875BWmQwWd7FEoNsyHby1VxqDMg7QkKhb7S87xvGZHMCsV+LP/TARBs4EOVcr38Wn8JSBeQ6r7+B31Z0zfcTFMEH4Jljh7q1pthGPnqDqU5NtSW5EMMBn9JiJYc=");
        BaseConst_JXZLJ.setToken_zlj_shi(login);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_pass.json");
        jsonObject.put("id",this.ID);
        jsonObject.put("flowStatus",20);
        String body = jsonObject.toJSONString();
        String result = apply.audit_shi(body);
;

    }

     @Test(testName ="省级审批通过",priority = 4)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void audit_shengTest() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_pass.json");
        jsonObject.put("id",this.ID);
        jsonObject.put("flowStatus",30);
        String body = jsonObject.toJSONString();
        String result = apply.audit_sheng(body);
;
    }

/*    @Test(testName ="专家审批通过",priority = 2)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void audit_zjTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/jxzlj/request/audit_pass.json").toJSONString();
        String result = apply.addQoApply(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }*/


}
