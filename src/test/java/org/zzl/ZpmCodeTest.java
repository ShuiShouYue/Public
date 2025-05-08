package org.zzl;

import com.alibaba.fastjson.JSONObject;
import org.base.zzl.BasePath_New_ZZL;
import org.service.zzl.ZpmCode;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;

/**
 * 批次单品校验
 */
public class ZpmCodeTest {
    ZpmCode zpmCode = new ZpmCode();
    @Test(testName ="批次创建校验",priority = 1)

    public void batchSave() throws IOException {
/*        Sys sys = new Sys();
        String login = sys.loginsc("FPgiV+ggXpm0EHTBmfbchM+jgPEe60U8lOwGx8nYcNk2CrTZFiPqSOj3B7q0elwPiX8xWeRf1m46DK2M83n4i8Miq+cyZ8+Nnq4dSWRYYX23VTZVYqbOXJ0xhHhzWbm4fBC4bk5P7tHuyGSYbaJjUP1Zqln8sOL/sWMibcYy7pI=","JIkMjPjOa4GqQrX8Elj1YC/3xaPh9DGcVtxSj02OYKKfLKOT2GPLru4FumZnsYpf3QtwFHXE4dJQbahYnl+9HN4zsV/Af83OEYr8bxLuIrgl2glEeDzivq5dT9knkL3G69F0HQOwgMmKNortHwyf3TGWf0t+1bzK9Wd5b7Zxt8o=");
        BaseConst_New_ZZL.setToken_zzl_sc(login);
        System.out.println(BaseConst_New_ZZL.getToken_zzl_sc());*/
        String body = JsonFileUtils.readJson("/json/zzl/request/saveBatch.json").toJSONString();
        String result = zpmCode.saveBatch(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }
    @Test(testName ="批次查询校验",priority = 2)

    public void batchFind() throws IOException {

        String body = JsonFileUtils.readJson("/json/zzl/request/findBatch.json").toJSONString();
        String result = zpmCode.findBatch(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);

    }
    @Test(testName ="批次删除校验",priority = 3)

    public void batchDelete() throws IOException {
        String body = JsonFileUtils.readJson("/json/zzl/request/findBatch.json").toJSONString();
        String result = zpmCode.findBatch(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeId");
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.BATCH_DELETE + "?id="+id;
        String result1 = zpmCode.deleteBatch(url);
        String result2 = JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);
    }

    @Test(testName ="单品码创建校验",priority = 4)
    public void saveDpmTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/zzl/request/saveDpm.json").toJSONString();
        String result = zpmCode.saveDpm(body);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }

    @Test(testName ="单品码查询校验",priority = 5)

    public void findPageDpmTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/zzl/request/findByIdDpm.json").toJSONString();
        String result = zpmCode.findByIdDpm(body);
        String message = "2061840927771";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("unifiedCode");
        Assert.assertEquals(result1,message);
        System.out.println(result);
    }

    @Test(testName ="单品码入库前报废校验",priority = 6)

    public void deleteDpmTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/zzl/request/findByIdDpm.json").toJSONString();
        String result = zpmCode.findByIdDpm(body);
        String message = "成功";
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeId");
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.DPM_DELETE+ "?id="+id;
        System.out.println(url);
        String result1 = zpmCode.deleteDpm(url);
        String result2 =JSONObject.parseObject(result1).getString("message");
        Assert.assertEquals(result2,message);

    }
}
