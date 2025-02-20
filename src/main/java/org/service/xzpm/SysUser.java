package org.service.xzpm;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.utils.http.Http;

import java.io.IOException;

public class SysUser {
    /**
     * 修改密码
     */
    public String updatePwd(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.UPDATEPWD;
        String response = http.post(token,url,body);
        return response;
    }
}
