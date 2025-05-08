package org;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.readJson.isnull.GetJsonUtil;
import org.utils.readJson.notnull.JsonFileUtils;

import java.io.IOException;

public class Test1 {
    @Test
    public void batchSave() throws IOException {
        String result = JsonFileUtils.readJson("/json/a.json").toJSONString();
        System.out.println(result);
        String result1 = JsonFileUtils.readJson("/json/b.json").toJSONString();
        System.out.println(result1);
        Assert.assertEquals (result,result1);
    }
}
