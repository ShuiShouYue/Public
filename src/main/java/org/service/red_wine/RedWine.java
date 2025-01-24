package org.service.red_wine;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.base.red_wine.BasePath_RedWine;
import org.utils.http.Http;

import java.io.IOException;

public class RedWine {
    /**
     * 红酒登录
     */
    public String login1(String username,String password) throws IOException {
        Http http = new Http();
        String url =  BasePath_RedWine.RedWine_IP + BasePath_RedWine.LOGIN;
        String response = HttpRequest.post(url)
                .form("username",username,
                        "password",password)
                .execute()
                .body();
        String token ="Bearer "+ JSONObject.parseObject(response).getString("token");
        return token;
    }
}
