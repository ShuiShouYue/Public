package org.service.xzpm;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.utils.http.Http;

import java.io.IOException;
import java.util.Map;

/**
 * 上传
 */
public class Info {
    /**
     * 电动自行车上传
     */
    public String electric(Map dataMap) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.DDC_INFO;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.excel(token,url,dataMap);
        return response;

    }

    /**
     * 电池上传
     */
    public String battery(Map dataMap) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.DC_INFO;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.excel(token,url,dataMap);
        return response;

    }

    /**
     * 电动车附件上传
     */
    public String bicyclesInfo(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.DDCFJ_SAVE;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;

    }

/*    *//**
     * 电池附件上传
     *//*
    public String usingImport(String filename) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SY_MEASURE;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;

    }*/

    /**
     * 生产计量器具上传
     */
    public String productImport(Map dataMap) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SC_MEASURE;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.excel(token,url,dataMap);
        return response;

    }

    /**
     * 使用计量器具上传
     */
    public String usingImport(Map dataMap) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SY_MEASURE;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.excel(token,url,dataMap);
        return response;

    }


}
