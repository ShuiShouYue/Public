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
    //执行时，文件不能是打开状态，需要关闭文件后才能执行
    @DataProvider(name="testData")
    public Object[][] provider(){
        ExcelVoid excel = new ExcelVoid();
        return excel.read("D:\\IDEA\\git\\src\\main\\resources\\excel\\测试数据.xls",2,8,1,3);
    }
    //参数返回的数组作为用例的输入（String url,String data），并循环输出结果
    @Test(dataProvider="testData")
    public void getResult(String url,String data,String num) throws IOException {
        System.out.println();
        Http http = new Http();
        String result = http.postChange("Bearer b52cc6bc-859c-47a6-a8ae-423f676550b9",url,data);
        /*String message = num;*/
        String result1 = JSONObject.parseObject(result).getString("message");
        System.out.println(result1);
        if (result1.equals(num)){

        }
        else {
            System.out.println(url);
        }
        Assert.assertEquals(result1,num);

    }


}
