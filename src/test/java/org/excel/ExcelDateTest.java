package org.excel;

import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.utils.excel.ExcelVoid;
import org.utils.http.Http;

import java.io.IOException;

public class ExcelDateTest {
    //@DataProvider作为参数提供给@Test,startRow和endRow代表起始行和结束行，startColumn和endstartColumn代表起始列和结束列
    @DataProvider(name="testData")
    public Object[][] provider(){
        ExcelVoid excel = new ExcelVoid();
        return excel.read("C:\\Users\\ASUS\\Desktop\\测试数据.xls",1,3,1,2);
    }
    //参数返回的数组作为用例的输入（String url,String data），并循环输出结果
    @Test(dataProvider="testData")
    public void getResult(String url,String data) throws IOException {
        System.out.println();
        Http http = new Http();
        String result = http.postChange("Bearer d6e03255-094a-43e8-99a7-d0ac3bf6842b",url,data);
        String message = "成功";
        String result1 = JSONObject.parseObject(result).getString("message");
        Assert.assertEquals(result1,message);
    }
}
