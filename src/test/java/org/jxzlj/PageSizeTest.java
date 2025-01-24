package org.jxzlj;

import com.alibaba.fastjson.JSONObject;
import org.base.jxzlj.BaseConst_JXZLJ;
import org.service.jxzlj.Apply;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;

import java.io.IOException;
/**
 * 页面条数展示校验
 */
public class PageSizeTest {
    Apply apply = new Apply();
    @Test(testName ="列表页的每页条数选择10，每页返回10条信息",priority = 1)
    public void pageSizeTest_1() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String pageSize = JSONObject.parseObject(result).getJSONObject("data").getString("pageSize");
        String message = "10";
        Assert.assertEquals(pageSize,message);
    }
    @Test(testName ="列表页的每页条数选择20，每页返回20条信息",priority = 2)
    public void pageSizeTest_2() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("pageSize","20");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String pageSize = JSONObject.parseObject(result).getJSONObject("data").getString("pageSize");
        String message = "20";
        Assert.assertEquals(pageSize,message);
    }
    @Test(testName ="列表页的每页条数选择30，每页返回30条信息",priority = 3)
    public void pageSizeTest_3() throws IOException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("pageSize","30");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String pageSize = JSONObject.parseObject(result).getJSONObject("data").getString("pageSize");
        String message = "30";
        Assert.assertEquals(pageSize,message);
    }
    @Test(testName ="列表页的每页条数选择50，每页返回50条信息",priority = 4)
    public void pageSizeTest_4() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("pageSize","50");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String pageSize = JSONObject.parseObject(result).getJSONObject("data").getString("pageSize");
        String message = "50";
        Assert.assertEquals(pageSize,message);
        Thread.sleep(1000);
    }
    @Test(testName ="前往页数，输入3并确定，跳转到对应的第三页",priority = 4)
    public void pageSizeTest_5() throws IOException, InterruptedException {
        String login = apply.login("QgXn16zeXzqfb5tOndCQ/Sufh40KqH5FGb5NTeV6oLZT5kwcS5VyfARHKYJLkbEzR2S5y5D2Kn5vaS1zNjErBCtINihQlcC5MaK9YJ7a5nByexIVT0YJEeGKnASy6SNMzI9OotWspApIwvqYA9zjZhvo+7fmHKor/EcOV4GSXqY=","jwUZegEYaAfwACOQNkXaNpMUWqJCWfTdMZ08ULTa7YFyUn9c/ENSXWGZCYBxmfLkHmOJS5XmmikFAtfKFRE1zFOib5njVUIrqdc+ACouuJnV+ykPwWWEwn2pj2Dc6nRSISJ0nZRm+dmIz08O8U2mtwSSOL/rT2hGa/k1k64HaJ0=");
        BaseConst_JXZLJ.setToken_zlj_sheng(login);

        JSONObject jsonObject = JsonFileUtils.readJson("/json/jxzlj/request/findPageByQuery.json");
        jsonObject.put("applyName","");
        jsonObject.put("pageNum","3");
        String body = jsonObject.toJSONString();
        String result = apply.findPageByQuery_sheng(body);
        String pageNum = JSONObject.parseObject(result).getJSONObject("data").getString("pageNum");
        String message = "3";
        Assert.assertEquals(pageNum,message);
        Thread.sleep(1000);
    }

}
