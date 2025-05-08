package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.base.new_zpm.BasePath_New_ZPM;

import org.service.xzpm.CompanyCredential;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;
/**
 * 资质信息管理
 */
public class CompanyCredentialTest {
    static CompanyCredential companyCredential = new CompanyCredential();
    @Test(testName ="资质新增",priority = 1)
    public void companyCredentialSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/companyCredentialSave.json").toJSONString();
        String result = companyCredential.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(message,result1);
    }

    @Test(testName ="资质列表页查询校验",priority = 2)

    public void FindPageByQueryTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/companyCredentialFindPageByQuery.json").toJSONString();
        String result = companyCredential.findPageByQuery(body);
        System.out.println(result);
        String message = "20250111";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("credentialNo");
        System.out.println(result1);
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="资质删除校验",priority = 3)

    public void companyCredentialDeleteTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/pcmFindPageByQuery.json").toJSONString();
        String result = companyCredential.findPageByQuery(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.COMPANY_CREDENTIAL_DELETE + "?id="+id;
        String result1 = companyCredential.delete(url);
        String result2 = JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
    }
}
