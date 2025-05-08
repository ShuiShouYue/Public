package org.jxzlj;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.base.jxzlj.BaseConst_JXZLJ;
import org.base.jxzlj.BasePath_JXZLJ;
import org.service.jxzlj.Apply;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *导入/导出功能校验
 */
public class UploadTest {
    Apply apply = new Apply();
    @Test(testName ="导入zip类型的文件，导入成功",priority = 1)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void UploadTest() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\1.zip");
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        Map data = new HashMap();
        data.put("file", file);
        String result =HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        String result1 = JSONObject.parseObject(result).getString("name");
        String message = "1.zip";
        Assert.assertEquals(result1,message);
    }
    @Test(testName ="导入doc类型的文件，导入成功",priority = 2)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void UploadTest_1() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\2.doc");
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        Map data = new HashMap();
        data.put("file", file);
        String result =HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        String result1 = JSONObject.parseObject(result).getString("name");
        String message = "2.doc";
        Assert.assertEquals(result1,message);
    }
    @Test(testName ="导入docx类型的文件，导入成功",priority = 3)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void UploadTest_2() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\3.docx");
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        Map data = new HashMap();
        data.put("file", file);
        String result =HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        String result1 = JSONObject.parseObject(result).getString("name");
        String message = "3.docx";
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="导入pdf类型的文件，导入成功",priority = 4)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void UploadTest_3() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\4.pdf");
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        Map data = new HashMap();
        data.put("file", file);
        String result =HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        String result1 = JSONObject.parseObject(result).getString("name");
        String message = "4.pdf";
        Assert.assertEquals(result1,message);
    }
    @Test(testName ="导入rar类型的文件，导入成功",priority = 5)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void UploadTest_4() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\5.rar");
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        Map data = new HashMap();
        data.put("file", file);
        String result =HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        String result1 = JSONObject.parseObject(result).getString("name");
        String message = "5.rar";
        Assert.assertEquals(result1,message);
    }
    @Test(testName ="导入xlsx类型的文件，导入成功",priority = 6)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void UploadTest_5() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\6.xlsx");
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        Map data = new HashMap();
        data.put("file", file);
        String result =HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        String result1 = JSONObject.parseObject(result).getString("name");
        String message = "6.xlsx";
        Assert.assertEquals(result1,message);
    }
    @Test(testName ="导入不符合规范类型的数据，导入失败，并提示‘文件格式不正确, 请上传doc/docx/pdf/zip/rar/xlsx格式文件!’",priority = 7)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)

    public void UploadTest_6() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\7.png");
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        Map data = new HashMap();
        data.put("file", file);
        String result =HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        System.out.println(result);
        String result1 = JSONObject.parseObject(result).getString("name");
        String message = "文件格式不正确, 请上传doc/docx/pdf/zip/rar/xlsx格式文件!";
        Assert.assertEquals(result1,message);
        Thread.sleep(1000);
    }
    @Test(testName ="导入内存占用超过200M数据导入失败，并提示",priority = 8)

    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void UploadTest_7() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\超过200M.zip");
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        Map data = new HashMap();
        data.put("file", file);
        String result =HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        String result1 = JSONObject.parseObject(result).getString("name");
        String message = "文件格式不正确, 请上传doc/docx/pdf/zip/rar/xlsx格式文件!";
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="导出当页全部数据，能够导出对应的数据，且数据正确",priority = 9)

    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void UploadTest_8() throws IOException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        String body = JsonFileUtils.readJson("/json/jxzlj/request/exportArchived.json").toJSONString();
        String result = apply.exportArchived(body);
    }
    @Test(testName ="导出一条数据，能够导出对应的数据，且数据正确",priority = 10)

    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void UploadTest_9() throws IOException, InterruptedException {
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/exportArchived.json");
        jsonObject.put("applyName","1");
        String body = jsonObject.toJSONString();
        String result = apply.exportArchived(body);
        Thread.sleep(1000);
    }
}
