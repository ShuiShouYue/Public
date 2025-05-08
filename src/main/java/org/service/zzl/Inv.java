package org.service.zzl;

import org.base.zzl.BaseConst_New_ZZL;
import org.base.zzl.BasePath_New_ZZL;
import org.utils.http.Http;

import java.io.IOException;

public class Inv {
    public String  save(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZZL.getToken_zzl_sc();
        String url = BasePath_New_ZZL.ZZL_IP + BasePath_New_ZZL.DPM_FIND;
        String response = http.post(token,url,body);
        return response;
    }
}
