package org.service.zpm;

import org.base.BaseConst;
import org.base.BasePath;
import org.utils.http.Http;

import java.io.IOException;


public class ZpmCode {
    /**
     * 批次码列表页查询
     */
    public String findPageByQuery(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst.Token;
        String url = BasePath.ZPM_IP + BasePath.BATCH_CODE_DETAILS_FIND;
        String response = http.post(token,url,body);
        return response;
    }


    /**
     * 创建批次码
     */
    public String saveBatch(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst.Token;
        String url = BasePath.ZPM_IP + BasePath.BATCH_CODE_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 批次码详情页
     */
    public String findById(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst.Token;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 批次码删除
     */
    public String  deleteBatch(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst.Token;
        String url = BasePath.ZPM_IP + BasePath.BATCH_CODE_DELETE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 单品码列表页查询
     */
    public String  findPageDpm(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst.Token;
        String url = BasePath.ZPM_IP + BasePath.SINGLE_ITEM_DETAILS_FIND;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 单品码创建
     */
    public String  saveDpm(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst.Token;
        String url = BasePath.ZPM_IP + BasePath.SINGLE_ITEM_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 单品码列详情页
     */
    public String  findByIdDpm(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst.Token;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 单品码删除
     */
    public String  deleteDpmById(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst.Token;
        String url = BasePath.ZPM_IP + BasePath.SINGLE_ITEM_DELETE;
        String response = http.post(token,url,body);
        return response;
    }


}
