package org.service.xzpm;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.utils.http.Http;

import java.io.IOException;


public class ZpmCode {
    /**
     * 批次码列表页查询
     */
    public String findPageByQuery(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.BATCH_CODE_DETAILS_FIND;
        String response = http.post(token,url,body);
        return response;
    }


    /**
     * 创建批次码
     */
    public String saveBatch(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.BATCH_CODE_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 批次码详情页
     */
    public String findById(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 批次码删除
     */
    public String  deleteBatch(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 单品码列表页查询
     */
    public String  findPageDpm(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SINGLE_ITEM_DETAILS_FIND;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 单品码创建
     */
    public String  saveDpm(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SINGLE_ITEM_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 单品码列详情页
     */
    public String  findByIdDpm(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 单品码删除
     */
    public String  deleteDpmById(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 流向信息创建
     */
    public String  saveFlowDetails(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.FLOW_DETAILS_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 流向信息列详情页
     */
    public String  flowDetailsFindByIdDpm(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.FLOW_DETAILS_FIND;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 流向信息删除
     */
    public String  deleteFlowDetails(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 变更批次
     */
    public String  associatedWithBatchAndBarSingle(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.CHANGE_BATCH;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 批量变更批次
     */
    public String  associatedWithBatchAndBarBatch(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.CHANGE_BATCH_MORE;
        String response = http.post(token,url,body);
        return response;
    }
}
