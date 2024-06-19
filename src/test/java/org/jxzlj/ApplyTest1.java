package org.jxzlj;

import com.alibaba.fastjson.JSONObject;
import org.base.BaseConst_JXZLJ;
import org.base.BasePath_JXZLJ;
import org.service.jxzlj.Apply;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;

/**
 * 申请质量官，区/县级审批不通过，流程及查询节点校验
 */
public class ApplyTest1 {
    Apply apply = new Apply();
    String ID = "";
    @Test(testName ="登录申请人账号，质量官申请并提交",priority = 1)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void addQoApplyTest() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);
        String body = JsonFileUtils.readJson("/json/jxzlj/request/addQoApply.json").toJSONString();
        String result = apply.addQoApply(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        ID = JSONObject.parseObject(result).getString("data");
        System.out.println(ID);
        Assert.assertEquals(result1,message);

    }

    @Test(testName ="登录区/县级市场监管局账号，区/县级审批不通过",priority = 2)
    //区县审核通过
    public void audit_refuse_xianTest() throws IOException {
        String login = apply.login("Q3YJgDLmc4XCvbGBOBA27Sfm591CPKKd7vg6O20Ab2ZXdExTrEhxOMu4cJ2tcb85RqtPy2B7TqlcEq1muLXzx+Nk1a1vKx8B/v87yunkmNeTi74sVy9ujjJOSHuxm/tCFz1b73QJuKU/w6/ufBdS4v0DHxjRKMPoXBpHmrBkz6k=","cuubBlSXJs0ESHfWaSwdkXMBJZQ72NTWYtYaO692RN/4kNpCBvR5qJjSax5WhL5miVy9soKhVljyXGtMYLvNY/kuS6xlZUBDqWDGNesiYFPnbmD7AtdqeX/jBkj4kl8YZUHPUs1lKRd+rhQbk69VfHk+m59GHx4CD/aHwP3DU3w=");
        BaseConst_JXZLJ.setToken_zlj_xian(login);
        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_refuse.json");
        jsonObject.put("id",this.ID);
        String body = jsonObject.toJSONString();
        String result = apply.audit_xian(body);

    }

    @Test(testName ="查询流程节点",priority = 3)
    //查询
    public void findByIdTest() throws IOException {
        String url = BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_BY_ID;
        String url1 = url+"?id="+this.ID;
        String result = apply.findById_xian(url1);
        System.out.println(result);
        String flowStatusTxt = JSONObject.parseObject(result).getJSONObject("data").getString("flowStatusTxt");
        String advices = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("flows").getJSONObject(1).getString("advices");
        String message = "已归档";
        String message1 = "拒绝";
        Assert.assertEquals(flowStatusTxt,message);
        Assert.assertEquals(advices,message1);
    }
}
