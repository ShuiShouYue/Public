package org.jxzlj;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.base.jxzlj.BaseConst_JXZLJ;
import org.base.jxzlj.BasePath_JXZLJ;
import org.service.jxzlj.Apply;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * 特殊流程申请质量官，省级综合评审不通过流程
 */
public class ApplyRefuseSpecialTest2 {
    Apply apply = new Apply();
    String ID = "";
    String DATA = "";
    @Test(testName ="导入zip类型的文件，导入成功",priority = 1)
    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void addQoApplyTest() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        File file = new File("C:\\Users\\ASUS\\Desktop\\压缩文件\\质量官.xlsx");
        String token = BaseConst_JXZLJ.getToken_zlj_sheng();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD_SPECIAL;
        Map data = new HashMap();
        data.put("file", file);
        String result = HttpRequest.post(url)
                .header("Authorization",token)
                .form(data)
                .contentType("multipart/form-data")
                .execute()
                .body();
        String result1 = JSONObject.parseObject(result).getString("message");
        String message = "成功";
        Assert.assertEquals(result1,message);
    }
    @Test(testName ="省级级审批已通过，输入姓名，任职单位，所属地区，是否导入数据查询用户流转节点，验证流转节点是待综合评审",priority = 2)
    public void findByIdTest_3() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("applyName","盒刏莃");
        jsonObject.put("flowStatus",30);
        String body = jsonObject.toJSONString();

        String result = apply.findPageByQuery_sheng(body);
        ID = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        System.out.println(ID);
    }
    @Test(testName ="登录省市场监管局账号，省级初审通过",priority = 3)

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
    @Test(testName ="登录省市场监管局账号，分配专家",priority = 4)

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
    @Test(testName ="登录专家账号，专家审核通过并上传材料",priority = 5)

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

    @Test(testName ="登录省市场监管局账号，综合审核不通过",priority = 6)
    public void audit_pass_zhTest() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/audit_refuse.json");
        jsonObject.put("id",this.ID);
        jsonObject.put("flowStatus",40);
        String body = jsonObject.toJSONString();
        String result = apply.audit_sheng(body);
        Thread.sleep(1000);
    }
    @Test(testName ="登录省市场监管局账号，对其数据进行删除操作，点击删除，删除成功",priority = 7)
    public void formTest_3() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        ArrayList list = new ArrayList();
        list.add(this.ID);
        JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(list));
        System.out.println(jsonObject);
        String body = jsonObject.toJSONString();
        String result = apply.delete_sheng(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        Thread.sleep(1000);
    }
}
