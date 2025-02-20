package org.service.xzpm;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.utils.http.Http;

import java.io.IOException;

public class MaterialCustomers {
    /**
     * 销售单位新增
     */
    public String  save(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.CUSTOMERS_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 销售单位查询
     */
    public String  findPageByQuery(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.CUSTOMERS_FIND;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 销售单位删除
     */
    public String  delete(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }
}
