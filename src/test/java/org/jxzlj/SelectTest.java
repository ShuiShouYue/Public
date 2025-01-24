package org.jxzlj;

import com.alibaba.fastjson.JSONObject;
import org.base.jxzlj.BaseConst_JXZLJ;
import org.service.jxzlj.Apply;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;
/**
 * 搜索功能校验
 */
public class SelectTest {
    Apply apply = new Apply();
    @Test(testName ="输入申请人姓名，能够搜索到对应数据",priority = 1)
    public void selectTest_1() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject =JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("applyName","赵小康");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String flowStatusTxt = JSONObject.parseObject(result).getString("message");
        String message = "成功";
        Assert.assertEquals(flowStatusTxt,message);
    }
    @Test(testName ="输入任职单位能够搜索到对应数据",priority = 2)
    public void selectTest_2() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject =JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("employer","\t 杭州超尔切削工具有限公司");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String flowStatusTxt = JSONObject.parseObject(result).getString("message");
        String message = "成功";
        Assert.assertEquals(flowStatusTxt,message);
    }
    @Test(testName ="输入所属地区能够搜索到对应数据",priority = 3)
    public void selectTest_3() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject =JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("areaCode","360103");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String flowStatusTxt = JSONObject.parseObject(result).getString("message");
        String message = "成功";
        Assert.assertEquals(flowStatusTxt,message);
    }
    @Test(testName ="搜索项‘是否导入数据’选择否，能够搜索到对应数据",priority = 4)
    public void selectTest_4() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject =JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("importFlag","0");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String flowStatusTxt = JSONObject.parseObject(result).getString("message");
        String message = "成功";
        Assert.assertEquals(flowStatusTxt,message);
    }
    @Test(testName ="搜索项‘是否导入数据’选择是，能够搜索到对应数据",priority = 5)
    public void selectTest_5() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject =JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("importFlag","1");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String flowStatusTxt = JSONObject.parseObject(result).getString("message");
        String message = "成功";
        Assert.assertEquals(flowStatusTxt,message);
    }
    @Test(testName ="选择一个‘流程状态’进行搜索，能够搜索到对应信息",priority = 6)
    public void selectTest_6() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject =JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("flowStatus","100");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String flowStatusTxt = JSONObject.parseObject(result).getString("message");
        String message = "成功";
        Assert.assertEquals(flowStatusTxt,message);
    }
    @Test(testName ="输入申请人姓名，输入所属地区，输入任职单位，搜索项‘是否导入数据’选择否,选择一个‘流程状态’进行搜索，能够搜索到对应信息",priority = 7)
    public void selectTest_7() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject =JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("applyName","赵小康");
        jsonObject.put("flowStatus","100");
        jsonObject.put("importFlag","0");
        jsonObject.put("areaCode","360103");
        jsonObject.put("employer","\t 杭州超尔切削工具有限公司");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String flowStatusTxt = JSONObject.parseObject(result).getString("message");
        String message = "成功";
        Assert.assertEquals(flowStatusTxt,message);
    }
    @Test(testName ="搜索时点击重置按钮，能够搜索到对应数据",priority = 8)
    public void selectTest_8() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject =JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("applyName","null");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String flowStatusTxt = JSONObject.parseObject(result).getString("message");
        String message = "成功";
        Assert.assertEquals(flowStatusTxt,message);
        Thread.sleep(1000);
    }
}
