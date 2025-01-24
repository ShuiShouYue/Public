package org.jxzlj;

import org.service.jxzlj.Apply;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
/**
 * 登录校验
 */
public class LoginTest {
    Apply apply = new Apply();
    String actual = "1";
    @Test(testName ="输入已注册的账密，登录成功",priority = 1)

    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void loginTest_1() throws IOException {
        String login = apply.login1("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        System.out.println(login);
        if (login != null){
            actual = "成功";
        }
        else {
            actual = "失败";
        }
        String message = "成功";
        Assert.assertEquals(actual,message);
    }
    @Test(testName ="输入未注册的账密，登录失败",priority = 1)

    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void loginTest_2() throws IOException {
        String login = apply.login1("1GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        System.out.println(login);
        if (login != null){
            actual = "成功";
        }
        else {
            actual = "失败";
        }
        String message = "失败";
        Assert.assertEquals(actual,message);
    }
    @Test(testName ="输入错误账号，登录失败",priority = 1)

    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void loginTest_3() throws IOException {
        String login = apply.login1("1GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        System.out.println(login);
        if (login != null){
            actual = "成功";
        }
        else {
            actual = "失败";
        }
        String message = "失败";
        Assert.assertEquals(actual,message);
    }
    @Test(testName ="输入错误密码，登录失败",priority = 1)

    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void loginTest_4() throws IOException {
        String login = apply.login1("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=", "1MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        System.out.println(login);
        if (login != null){
            actual = "成功";
        }
        else {
            actual = "失败";
        }
        String message = "失败";
        Assert.assertEquals(actual,message);
    }
    @Test(testName ="输入账密为空，登录失败",priority = 1)

    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void loginTest_5() throws IOException {
        String login = apply.login1("", "");
        System.out.println(login);
        if (login != null){
            actual = "成功";
        }
        else {
            actual = "失败";
        }
        String message = "失败";
        Assert.assertEquals(actual,message);
    }
    @Test(testName ="输入账密中间带有空格，登录失败",priority = 1)

    //质量官申请并提交校验(需要每次手动更新ID和applyName的值)
    public void loginTest_6() throws IOException, InterruptedException {
        String login = apply.login1("BszhTJcnL5AYvoGs+7Okn8nrNnLKfOSaW9cVyPo0Ea1gWEnlMqTU4y1rmhKFjR8V+BbWPYeqZSFBKCV/vYYvj95ziQ4W1tS8C6ZG5BIMwvsWFQz5zxBP5ygNjaR/AnJJPtmmMcM6LoyNs+IpccyU4CwzSvZNbwPux4RpdpZL90U=", "IRFtqyl9vm9XeEHlfO9Z5dD6TBoWu57No76L0kTJDjrl3dWup8SMWnbwoaC0bBRvdB39Zq1RNdJDxWqHvB2JmraJNWQ79UQjrUjyie2XDiJKZeC7Xoqe7WCD/uGta7+r3EiqRTt0VZheLfYY3ojC6OpNdAN4G6fJxPmyPowsVTg=");
        System.out.println(login);
        if (login != null){
            actual = "成功";
        }
        else {
            actual = "失败";
        }
        String message = "失败";
        Assert.assertEquals(actual,message);
        Thread.sleep(1000);
    }
}
