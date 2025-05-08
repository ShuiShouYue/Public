package org.service.zzl;

import org.base.zzl.BaseConst_New_ZZL;
import org.base.zzl.BasePath_New_ZZL;
import org.utils.http.Http;

import java.io.IOException;

/**
 * 品类码校验
 */
public class SamplingProduct {
    //品类码创建
    public String save(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.SAMPLING_PRODUCT_SAVE;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;
    }

    //品类码查询
    public String find(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.SAMPLING_PRODUCT_FIND;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;
    }

    //品类码删除
    public String delete(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.SAMPLING_PRODUCT_DELETE;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;

    }
}
