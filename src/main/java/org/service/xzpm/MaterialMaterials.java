package org.service.xzpm;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.utils.http.Http;

import java.io.IOException;

public class MaterialMaterials {
    /**
     * 原辅料新增
     */
    public String  save(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.MATERIALS_SAVE;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 原辅料查询
     */
    public String  findPageByQuery(String body) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.MATERIALS_FIND;
        String response = http.post(token,url,body);
        return response;
    }

    /**
     * 原辅料删除
     */
    public String  delete(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }
}
