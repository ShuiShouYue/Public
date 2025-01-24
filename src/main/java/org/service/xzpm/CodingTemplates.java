package org.service.xzpm;

import org.base.new_zpm.BaseConst_New_ZPM;
import org.base.new_zpm.BasePath_New_ZPM;
import org.springframework.stereotype.Service;
import org.utils.http.Http;
import java.io.IOException;

@Service
public class CodingTemplates {
    /**
     * 首页查询
     */
    public String findByUscc(String url) throws IOException{
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }

    /**
     * 模版列表页查询
     */
    public String findPageByQuery(String body) throws IOException {
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.TEMPLATES_FIND;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;

    }

    /**
     * 模版创建
     */
    public String templatesSave(String body) throws IOException{
        Http http = new Http();
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.TEMPLATES_SAVE;
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.post(token,url,body);
        return response;
    }
    /**
     * 模版删除
     */
    public String templatesDelete(String body) throws IOException{
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String url = BasePath_New_ZPM.ZPM_IP + BasePath_New_ZPM.TEMPLATES_DELETE;
        String response = http.post(token,url,body);
        return response;
    }
    /**
     * 模版详情页
     */
    public String findById(String url) throws IOException {
        Http http = new Http();
        String token = BaseConst_New_ZPM.Token_xzpm;
        String response = http.get(token,url);
        return response;
    }

}
