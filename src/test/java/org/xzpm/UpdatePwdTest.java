package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.service.xzpm.SysUser;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;

public class UpdatePwdTest {
    SysUser sysUser =new SysUser();
    @Test(testName ="密码修改",priority = 1)
    public void saveBatchTest() throws IOException {
        //修改密码成功
        JSONObject body = JsonFileUtils.readJson("/json/xzpm/request/updatePwd.json");
        String result = sysUser.updatePwd(body.toJSONString());
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(message,result1);
        //输入错误旧密码
        body.put("oldPwd","MTIzNDU2Nzg5");
        String message1 = "旧密码错误";
        String result2 = sysUser.updatePwd(body.toJSONString());
        String result3 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(message,result3);
    }

}
