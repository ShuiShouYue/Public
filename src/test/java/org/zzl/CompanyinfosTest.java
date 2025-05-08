package org.zzl;

import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;
import org.service.zzl.Companyinfos;
import java.io.IOException;
/**
 * 企业信息
 */
public class CompanyinfosTest {
    Companyinfos companyinfos = new Companyinfos();
    @Test(testName ="企业信息更新校验",priority = 1)
    //模版查询校验
    public void findTest() throws IOException {

        String body = JsonFileUtils.readJson("/json/zzl/request/companyinfosSave.json").toJSONString();
        String result = companyinfos.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }

}
