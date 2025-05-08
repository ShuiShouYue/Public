package org.service.zzl;

import org.base.zzl.BaseConst_New_ZZL;
import org.base.zzl.BasePath_New_ZZL;
import org.utils.http.Http;

import java.io.IOException;

/**
 * 订单校验
 */
public class Order {
    //订单新增
    public String  orderSave(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.ORDER_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    //订单查询
    public String  orderFind(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.ORDER_FIND;
        String response = http.post(token,url,body);
        return response;
    }

    //订单删除
    public String orderDelete(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.ORDER_DELETE;
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String response = http.post(token,url,body);
        return response;
    }
}
