package org.xzpm;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.service.xzpm.SamplingProduct;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JsonFileUtils;
import org.utils.JsonUtil;
import org.utils.Stringnull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
/**
 * 此类包含了品类码
 */
public class ResourceFileReaderTest{
    static SamplingProduct samplingProduct = new SamplingProduct();

    @Test(testName ="品类码创建校验",priority = 1)
    //品类码创建校验(json文件的LatsCode每次需要更新)
    public void samplingProductSaveTest() throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/plmSave.json").toJSONString();
        String result = samplingProduct.plmSave(body);
        System.out.println(result);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
        String message1 = "该浙品码在本系统中已存在，无法再次添加";
        String result2 = samplingProduct.plmSave(body);
        String result3 =JSONObject.parseObject(result2).getString("message");
        Assert.assertEquals(result3,message1);
    }

    @Test(testName ="品类码列表页查询校验",priority = 2)
    //品类码列表页查询校验（json文件需要与创建的产品名称（ProductName）字段一致）
    public void findPageCompanyProductTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageCompanyProduct.json").toJSONString();
        String result = samplingProduct.findPageCompanyProduct(body);
        System.out.println(result);
        String message = "森森";
        String result1 = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("specifications");
        Assert.assertEquals(result1,message);
        String CodeID = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("CodeID");
        System.out.println(CodeID);
    }

 /*   public static void main(String[] args) throws IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageCompanyProduct.json").toJSONString();
        String result = samplingProduct.findPageCompanyProduct(body);
        System.out.println(result);

        Map<String, Object> map = new HashMap<String, Object>();
        map=JsonUtil.getStringToMap(result);

        Map<String, Object> mapNew = removeEmpty(map);

    }
*/
    @Test(testName ="品类码删除校验",priority = 3)
    //品类码删除校验
    public void setProductQRCodeInvalidTest() throws  IOException {
        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageCompanyProduct.json").toJSONString();
        String result = samplingProduct.findPageCompanyProduct(body);
        String CodeID = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("codeId");
        String UnifiedCode =JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("unifiedCode");

        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put( "codeId" ,CodeID );
        objectObjectHashMap.put( "unifiedCode" ,UnifiedCode );
        String parameters = JSONObject.toJSONString(objectObjectHashMap);
        String result1 = samplingProduct.setProductQRCodeInvalid(parameters);
/*        System.out.println(result1);
        System.out.println(parameters);*/
        String result2 =JSONObject.parseObject(result1).getString("message");
        String message2 = "成功";
        Assert.assertEquals(result2,message2);
    }

/*    public static void main(String[] args) throws IOException {
        SamplingProduct samplingProduct = new SamplingProduct();

        String body = JsonFileUtils.readJson("/json/zpm/request/findPageCompanyProduct.json").toJSONString();
        String result = samplingProduct.findPageCompanyProduct(body);
        String message = "杭州丝绸1";
        String CreditCode = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("CreditCode");
        String UnifiedCode =JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("UnifiedCode");

        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put( "CreditCode" ,CreditCode );
        objectObjectHashMap.put( "UnifiedCode" ,UnifiedCode );
        String parameters = JSONObject.toJSONString(objectObjectHashMap);
        String result1 = samplingProduct.setProductQRCodeInvalid(parameters);
        String result2 =JSONObject.parseObject(result1).getString("message");

        System.out.println(parameters);
        System.out.println(result2);
    }*/


}
