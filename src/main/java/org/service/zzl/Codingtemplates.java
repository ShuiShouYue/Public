package org.service.zzl;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.base.zzl.BaseConst_New_ZZL;
import org.base.zzl.BasePath_New_ZZL;
import org.utils.http.Http;

import java.io.IOException;
/**
 * 模版测试
 */
public class Codingtemplates {

    //创建模版
    public String save(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.CODINGTEMPLATES_SAVE;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;

    }

    //查询模版
    public String find(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.CODINGTEMPLATES_FIND;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;

    }

    //删除模版
    public String delete(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.CODINGTEMPLATES_DELETE;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;

        }
}