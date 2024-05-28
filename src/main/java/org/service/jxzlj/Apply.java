package org.service.jxzlj;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.base.BaseConst_JXZLJ;
import org.base.BasePath_JXZLJ;
import org.springframework.stereotype.Service;
import org.utils.http.Http;

import java.io.IOException;

/**
 *
 */
@Service
public class Apply {
    /**
     * 质量官登录
     */
    public String login(String username,String password) throws IOException {
        Http http = new Http();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.LOGIN;
        String response = HttpRequest.post(url)
                .form("username",username,
                        "password",password)
                .execute()
                .body();
        String token ="Bearer "+ JSONObject.parseObject(response).getString("token");
        return token;
    }

    /**
     * 质量官评选提交申请
     */
    public String addQoApply(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.SUBMIT_ZLGSQ;
        String response = http.post(token, url, body);
        return response;
    }

    /**
     * 区/县审核接口
     */
    public String audit_xian(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_xian();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.AUDIT;
        String response = http.post(token, url, body);
        return response;
    }

    /**
     * 市级审核接口
     */
    public String audit_shi(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_shi();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.AUDIT;
        String response = http.post(token, url, body);
        return response;
    }

    /**
     * 省级审核接口
     */
    public String audit_sheng(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sheng();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.AUDIT;
        String response = http.post(token, url, body);
        return response;
    }

    /**
     * 专家审核接口
     */
    public String audit_zj(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_zj();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.AUDIT;
        String response = http.post(token, url, body);
        return response;
    }




}
