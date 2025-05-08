package org.service.zzl;

import org.base.zzl.BaseConst_New_ZZL;
import org.base.zzl.BasePath_New_ZZL;
import org.utils.http.Http;

import java.io.IOException;

/**
 * 客户测试
 */
public class Custom {
    //客户创建
    public String save(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.CUSTOM_SAVE;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;
    }

    //客户查询
    public String find(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.CUSTOM_FIND;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;
    }

    //客户删除
    public String delete(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.CUSTOM_DELETE;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;

    }
}
