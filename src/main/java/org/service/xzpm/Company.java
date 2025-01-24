package org.service.xzpm;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.utils.http.Http;

import java.io.IOException;

public class Company {
    /**
     * 企业信息管理
     */
    public String update(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.COMPANY;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;

    }
}
