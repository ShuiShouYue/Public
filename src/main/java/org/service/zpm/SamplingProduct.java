package org.service.zpm;

import org.base.BaseConst;
import org.base.BasePath;
import org.utils.http.Http;

import java.io.IOException;

public class SamplingProduct {
    /**
     * 创建品类码
     */
    public String plmSave(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst.Token;
        String url = BasePath.ZPM_IP + BasePath.SAMPLING_PRODUCT_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 品类码列表页查询
     */
    public String findPageCompanyProduct(String body) throws IOException{
        Http http = new Http();
        String token = BaseConst.Token;
        String url = BasePath.ZPM_IP + BasePath.SAMPLING_PRODUCT_FIND;
        String response = http.post(token,url,body);
        return response;
    }


    /**
     * 品类码详情页
     */
    public String findById(String url) throws IOException{
        Http http = new Http();
        String token = BaseConst.Token;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 删除品类码
     */
    public String setProductQRCodeInvalid(String body) throws IOException{
        Http http = new Http();
        String url = BasePath.ZPM_IP + BasePath.SAMPLING_PRODUCT_DELETE;
        String token = BaseConst.Token;
        String response = http.post(token,url,body);
        return response;
    }
}
