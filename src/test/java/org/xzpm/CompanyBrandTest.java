package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import org.base.new_zpm.BasePath_New_ZPM;
import org.service.xzpm.CompanyBrand;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;
/**
 * 品牌信息
 */
public class CompanyBrandTest {


    static CompanyBrand companyBrand = new CompanyBrand();
    @Test(testName ="品牌新增",priority = 1)
    public void saveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/companyBrandSave.json").toJSONString();
        String result = companyBrand.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(message,result1);
    }

    @Test(testName ="品牌列表页查询校验",priority = 2)

    public void FindPageByQueryTest() throws  IOException {

        String body = JsonFileUtils.readJson("/json/xzpm/request/companyBrandFindPageByQuery.json").toJSONString();
        String result = companyBrand.findPageByQuery(body);
        String message = "品牌名称";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("brandName");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="品牌删除校验",priority = 3)

    public void companyBrandDeleteTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/pcmFindPageByQuery.json").toJSONString();
        String result = companyBrand.findPageByQuery(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.COMPANY_BRAND_DELETE + "?id="+id;
        String result1 = companyBrand.delete(url);
        String result2 = JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);

    }
}
