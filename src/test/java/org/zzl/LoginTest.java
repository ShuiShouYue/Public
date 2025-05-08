package org.zzl;

import org.base.jxzlj.BaseConst_JXZLJ;
import org.base.zzl.BaseConst_New_ZZL;
import org.service.zzl.Sys;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest {
    Sys sys = new Sys();
@BeforeTest
public void getTestClassName(){
    ITestResult it = Reporter.getCurrentTestResult();
    System.out.println(it.getTestName());
}
    @Test(testName ="浙妆链生产企业登录",priority = 1)

    public void addQoApplyTest() throws IOException, InterruptedException {

        String login = sys.loginsc("FPgiV+ggXpm0EHTBmfbchM+jgPEe60U8lOwGx8nYcNk2CrTZFiPqSOj3B7q0elwPiX8xWeRf1m46DK2M83n4i8Miq+cyZ8+Nnq4dSWRYYX23VTZVYqbOXJ0xhHhzWbm4fBC4bk5P7tHuyGSYbaJjUP1Zqln8sOL/sWMibcYy7pI=","JIkMjPjOa4GqQrX8Elj1YC/3xaPh9DGcVtxSj02OYKKfLKOT2GPLru4FumZnsYpf3QtwFHXE4dJQbahYnl+9HN4zsV/Af83OEYr8bxLuIrgl2glEeDzivq5dT9knkL3G69F0HQOwgMmKNortHwyf3TGWf0t+1bzK9Wd5b7Zxt8o=");
        BaseConst_New_ZZL.setToken_zzl_sc(login);
        System.out.println(BaseConst_New_ZZL.getToken_zzl_sc());
    }
}
