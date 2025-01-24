package org.service.xzpm;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.utils.http.Http;

import java.io.IOException;

public class SamplingProduct {
    /**
     * 创建品类码
     */
    public String plmSave(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SAMPLING_PRODUCT_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 品类码列表页查询
     */
    public String findPageCompanyProduct(String body) throws IOException{
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SAMPLING_PRODUCT_FIND;
        String response = http.post(token,url,body);
        return response;
    }


    /**
     * 品类码详情页
     */
    public String findById(String url) throws IOException{
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 删除品类码
     */
    public String setProductQRCodeInvalid(String body) throws IOException{
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.SAMPLING_PRODUCT_DELETE;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;
    }
}
