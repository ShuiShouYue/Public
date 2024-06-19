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
    public String login1(String username,String password) throws IOException {
        Http http = new Http();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.LOGIN;
        String response = HttpRequest.post(url)
                .form("username",username,
                        "password",password)
                .execute()
                .body();
        String token =JSONObject.parseObject(response).getString("token");
        return token;
    }
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
     * 指派专家接口
     */
    public String applyGroup(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sheng();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.ASSIGN_EXPERTS;
        String response = http.post(token, url, body);
        return response;
    }


    /**
     * 专家审核接口
     */
    public String audit_zj(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_zj();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.AUDIT_ZJ;
        String response = http.post(token, url, body);
        return response;
    }

    /**
     * 上传任命文件
     */
    public String audit_rmwj(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.AUDIT;
        String response = http.post(token, url, body);;
        return response;
    }

    /**
     * 申请人情页查询
     */
    public String findById_sqr(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String response = http.get(token,url);;
        return response;
    }


    /**
     * 县级详情页查询
     */
    public String findById_xian(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_xian();
        String response = http.get(token,url);;
        return response;
    }
    /**
     * 市级详情页查询
     */
    public String findById_shi(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_shi();
        String response = http.get(token,url);;
        return response;

    }

    /**
     * 省级详情页查询
     */
    public String findById_sheng(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sheng();
        String response = http.get(token,url);;
        return response;
    }

    /**
     * 专家详情页查询
     */
    public String findById_zj(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_zj();
        String response = http.get(token,url);;
        return response;
    }
    /**
     * 申请人多条件查询
     */
    public String findPageByQuery_sqr(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_PAGE_BY_QUERY;
        String response = http.post(token, url, body);;
        return response;
    }

    /**
     * 区/县多条件查询
     */
    public String findPageByQuery_xian(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_xian();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_PAGE_BY_QUERY;
        String response = http.post(token, url, body);;
        return response;
    }

    /**
     * 市多条件查询
     */
    public String findPageByQuery_shi(String body) throws IOException {
            Http http = new Http();
            String token = BaseConst_JXZLJ.getToken_zlj_shi();
            String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_PAGE_BY_QUERY;
            String response = http.post(token, url, body);;
            return response;
    }
    /**
     * 省多多条件查询
     */
    public String findPageByQuery_sheng(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sheng();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_PAGE_BY_QUERY;
        String response = http.post(token, url, body);;
        return response;
    }
    /**
     * 专家多条件查询
     */
    public String findPageByQuery_zj(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_zj();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_PAGE_BY_QUERY;
        String response = http.post(token, url, body);;
        return response;
    }

    /**
     * 上传
     */
    public String upload(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.UPLOAD;
        String response = http.post(token, url, body);;
        return response;
    }

    /**
     * 下载
     */
    public String exportArchived(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.EXPORTARCHIVED;
        String response = http.post(token, url, body);
        return response;
    }
}
