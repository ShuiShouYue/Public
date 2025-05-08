package org.service.zzl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.base.zzl.BasePath_New_ZZL;
import org.utils.http.Http;

import java.io.IOException;

public class Sys {
    /**
     * 浙妆链登录
     */
    public String loginsc(String username,String password) throws IOException {
        Http http = new Http();
        String url =  BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.LOGIN;
        String response = HttpRequest.post(url)
                .form("username",username,
                        "password",password)
                .execute()
                .body();
        String token ="Bearer "+ JSONObject.parseObject(response).getString("token");
        return token;
    }
}
