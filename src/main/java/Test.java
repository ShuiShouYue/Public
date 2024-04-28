import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.service.zpm.CodingTemplates;
import org.utils.JsonFileUtils;
import org.utils.http.Http;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        CodingTemplates codingTemplates = new CodingTemplates();

/*        JSONObject result = JsonFileUtils.readJson("/json/zpm/request/templatesSave.json");
   *//*     result.getJSONObject("data").getJSONArray("list").getJSONObject(0).put("templateName","111");*//*
          *//*  result.put("templateName","1");*//*
        Object result1 = JsonFileUtils.readFileToObject("/json/zpm/request/b.json");
        System.out.println(result1);
        String a = result1.toString();
        System.out.println(a);*/

/*        String body = JsonFileUtils.readJson("/json/zpm/request/mbfindPageByQuery.json").toJSONString();
        String result = codingTemplates.findPageByQuery(body);
        String id = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("id");
        System.out.println(id);
        JSONArray list = new JSONArray();
        list.add(id);
        System.out.println(list);*/
        System.out.println("哈喽");



        Http http = new Http();
/*        String url = "http://192.168.82.164:10061/api/sys/menu/getRouters";
        String result = HttpRequest.get(url)
                .header("Authorization","Bearer 233dd6c0-a837-4245-98ca-b2b4bf0e66af")
                .cookie("node_id=nginx_1; Admin-Token=233dd6c0-a837-4245-98ca-b2b4bf0e66af; route=7d57559944d5dd58726f77b148eafe03; JSESSIONID=FE8328DC80C5857A7C4D4E56A9977DDC")
                .execute()
                .body();
        System.out.println(result);*/

/*        String body = "/json/request/a.json";

        String url = "http://192.168.82.164:10061/api/zpm/codingtemplates/save";


        System.out.println(http.post(BaseConst.Token,url,body));*/





    }
}
