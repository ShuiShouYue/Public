package org.zzl;

import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.service.zzl.Codingtemplates;
import org.service.zzl.SamplingProduct;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 品类码校验
 */
public class SamplingProductTest {
    SamplingProduct samplingProduct = new SamplingProduct();
    @Test(testName ="品类码创建校验",priority = 1)
    public void saveTest() throws IOException {
/*        Sys sys = new Sys();
        String login = sys.loginsc("FPgiV+ggXpm0EHTBmfbchM+jgPEe60U8lOwGx8nYcNk2CrTZFiPqSOj3B7q0elwPiX8xWeRf1m46DK2M83n4i8Miq+cyZ8+Nnq4dSWRYYX23VTZVYqbOXJ0xhHhzWbm4fBC4bk5P7tHuyGSYbaJjUP1Zqln8sOL/sWMibcYy7pI=","JIkMjPjOa4GqQrX8Elj1YC/3xaPh9DGcVtxSj02OYKKfLKOT2GPLru4FumZnsYpf3QtwFHXE4dJQbahYnl+9HN4zsV/Af83OEYr8bxLuIrgl2glEeDzivq5dT9knkL3G69F0HQOwgMmKNortHwyf3TGWf0t+1bzK9Wd5b7Zxt8o=");
        BaseConst_New_ZZL.setToken_zzl_sc(login);
        System.out.println(BaseConst_New_ZZL.getToken_zzl_sc());*/
        String body = JsonFileUtils.readJson("/json/zzl/request/samplingProductSave.json").toJSONString();
        String result = samplingProduct.save(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }
    @Test(testName ="品类码查询校验",priority = 2)
    public void findTest() throws IOException {

        String body = JsonFileUtils.readJson("/json/zzl/request/samplingProductFind.json").toJSONString();
        String result = samplingProduct.find(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);

    }
    @Test(testName ="品类码删除校验",priority = 3)
    public void deleteTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/zzl/request/samplingProductFind.json").toJSONString();
        String result = samplingProduct.find(body);
        String codeID = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeID");
        String unifiedCode = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("unifiedCode");
        Map map = new HashMap();
        map.put("CodeID",codeID);
        map.put("UnifiedCode",unifiedCode);
        String result1 = samplingProduct.delete(JSONObject.toJSONString(map));
        String result2 = JSONObject.parseObject(result1).getString("message");
        String message = "成功";
        Assert.assertEquals(result2,message);
    }
}
