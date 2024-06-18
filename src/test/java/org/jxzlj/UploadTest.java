package org.jxzlj;

import cn.hutool.http.HttpRequest;
import org.base.BaseConst_JXZLJ;
import org.base.BasePath_JXZLJ;
import org.service.jxzlj.Apply;
import org.testng.annotations.Test;
import org.utils.http.Http;

import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UploadTest {
    Apply apply = new Apply();
    @Test(testName ="登录申请人账号，质量官填写正确数据，且必填项均填写并点击提交，提交成功",priority = 1)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void addQoApplyTest() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\1.zip");
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        Map data = new HashMap();
        data.put("file", file);
        String body =HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        System.out.println(body);
    }
}
