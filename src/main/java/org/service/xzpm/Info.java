package org.service.xzpm;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.utils.http.Http;

import java.io.IOException;
/**
 * 上传
 */
public class Info {
    /**
     * 电动自行车上传
     */
    public String electric(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.DDC_INFO;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;

    }

    /**
     * 电动自行车上传
     */
    public String battery(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.DC_INFO;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;

    }

    /**
     * 生产计量器具上传
     */
    public String productImport(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SC_MEASURE;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;

    }

    /**
     * 使用计量器具上传
     */
    public String usingImport(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SY_MEASURE;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;

    }
}
