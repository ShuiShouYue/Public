package org.zzl;

import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.base.zzl.BasePath_New_ZZL;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;
import org.service.zzl.Order;
import java.io.IOException;

 public class OrderTest {
    Order order =new Order();
    @Test(testName ="订单创建校验",priority = 1)
    public void saveOrderTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/zzl/request/saveOrder.json").toJSONString();
        String result = order.orderSave(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="订单查询校验",priority = 2)

    public void findOrderTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/zzl/request/findOrder.json").toJSONString();
        String result = order.orderFind(body);
        String message = "91330110MA2J2JNK0Q";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("customUscc");
        Assert.assertEquals(result1,message);
        System.out.println(result);
    }

    @Test(testName ="订单删除校验",priority = 3)

    public void deleteOrderTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/zzl/request/findOrder.json").toJSONString();
        String result = order.orderFind(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        JSONArray list = new JSONArray();
        list.add(id);
        String result1 = order.orderDelete(list.toString());
        String result2 = JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);

    }
}
