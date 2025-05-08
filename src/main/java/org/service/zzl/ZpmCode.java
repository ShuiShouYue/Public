package org.service.zzl;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.base.zzl.BaseConst_New_ZZL;
import org.base.zzl.BasePath_New_ZZL;
import org.utils.http.Http;

import java.io.IOException;

/**
 * 批次码校验
 */
public class ZpmCode {
    //创建批次码
    public String saveBatch(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.BATCH_SAVE;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;

    }

    //查询批次码
    public String findBatch(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.BATCH_FIND;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;

    }

    //删除批次码
    public String  deleteBatch(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.get(token,url);
        return response;

    }

    //创建单品码
    public String  saveDpm(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.DPM_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    //查询单品码
    public String  findByIdDpm(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.DPM_FIND;
        String response = http.post(token,url,body);
        return response;
    }

    //单品码入库前报废
    public String  deleteDpm(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.get(token,url);
        return response;
    }
}
