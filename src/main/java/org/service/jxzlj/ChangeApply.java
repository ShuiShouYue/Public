package org.service.jxzlj;

import org.base.jxzlj.BaseConst_JXZLJ;
import org.base.jxzlj.BasePath_JXZLJ;
import org.utils.http.Http;

import java.io.IOException;

public class ChangeApply {
    /**
     * 申请注销
     */
    public String cancelApply(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String response = http.get(token, url);
        return response;
    }
    /**
     * 注销区/县级审核
     */
    public String cancelAudit_xian(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_xian();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.CANCEAUDIT;
        String response = http.post(token, url, body);
        return response;
    }
    /**
     * 注销市级审核
     */
    public String cancelAudit_shi(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_shi();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.CANCEAUDIT;
        String response = http.post(token, url, body);
        return response;
    }
    /**
     * 注销省级审核
     */
    public String cancelAudit_sheng(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sheng();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.CANCEAUDIT;
        String response = http.post(token, url, body);
        return response;
    }
    /**
     * 证书查询
     */
    public String findPageByQuery_zs(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sheng();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_PAGE_BY_QUERY_ZS;
        String response = http.post(token, url, body);
        return response;
    }
    /**
     * 申请人查询字段
     */
    public String findPageByQuery_zd_sqr(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_PAGE_BY_QUERY_ZD;
        String response = http.post(token, url, body);
        return response;
    }
    /**
     * 申请人查询详情
     */
    public String findPageByQuery_xq_sqr(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String response = http.get(token, url);
        return response;
    }
    /**
     * 申请质量官变更
     */
    public String addQoApply(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String url =  BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.SUBMIT_ZLGBG;
        String response = http.post(token, url, body);
        return response;
    }
    /**
     * 申请质量官变更
     */
    public String findById_change(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_JXZLJ.getToken_zlj_sqr();
        String response = http.get(token, url);
        return response;
    }
}
