import com.alibaba.fastjson.JSONObject;
import jxl.read.biff.BiffException;
import org.utils.GetJsonUtil;
import org.utils.JsonFileUtils;
import org.utils.excel.ExcelData;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

/*        val apply = new Apply();
        String login = apply.login("fWc7VySov1OGXs208kTajiFZteovxnCOTNnwRDn1f+qwNLWbqbcCxyUybn0+sRowKKW6J24QN/d5JuhyT84FC0hjcwqxemH9lFEVMZHelqXI8QWKA8KrMo5Ca8l06seoYW5YyF6gfynQgVl7S/T2BORYblLF+8P4WnjIrj2EBOk=","mVgnYLLOAuXVGft96zPcZYYx8AuI8R36prFM6G0dzx/AvkSRSmCW6L4BXBMjULXmcobIeRxiM+QaZNJIagTOY9PDp8NlpIYW2FC7lMUYhon7oqMLNTgdYZDl7AW5MKBRW8qp+uy61Md2/DDmwDOg0D/DDIHxzO6MXcNWim6Q544=");
        BaseConst_JXZLJ.setToken_zlj_zj(login);
        //查询详细信息取出id
        String ID = "0114c317d9644076a89feedd874ccff2";
        String url = BasePath_JXZLJ.ZLJ_IP + BasePath_JXZLJ.FIND_BY_ID;
        String url1 = url+"?id="+ID;
        String result = apply.findById_zj(url1);
        System.out.println(result);
        String id = JSONObject.parseObject(result).getJSONObject("data").getString("id");
        System.out.println(id);*/



        String result = GetJsonUtil.getJson("/json/xzpm/request/a.json");
        System.out.println(result);


/*        CodingTemplates codingTemplates = new CodingTemplates();

        JSONObject result = JsonFileUtils.readJson("/json/jxzlj/request/applyGroup.json");
        System.out.println(result);
        result.getJSONArray("applyIds").set(0,"ssss");
        System.out.println(result);
        JSONObject response = JsonFileUtils.readJson("/json/xzpm/request/b.json");
        System.out.println(response);
        String ProductName1= response.getJSONObject("data").getJSONArray("list").getJSONObject(1).getString("ProductName1");
        System.out.println(ProductName1);
        response.getJSONObject("data").getJSONArray("list").getJSONObject(1).put("ProductName1","222");

        System.out.println(response);*/

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



/*        Http http = new Http();
        String url = "http://192.168.82.164:10061/api/sys/menu/getRouters";
        String result = HttpRequest.get(url)
                .header("Authorization","Bearer 233dd6c0-a837-4245-98ca-b2b4bf0e66af")
                .cookie("node_id=nginx_1; Admin-Token=233dd6c0-a837-4245-98ca-b2b4bf0e66af; route=7d57559944d5dd58726f77b148eafe03; JSESSIONID=FE8328DC80C5857A7C4D4E56A9977DDC")
                .execute()
                .body();
        System.out.println(result);*/






/*        Apply apply = new Apply();
        String url = "http://192.168.82.164:10063/api/jxqb/sys/login";
        String url1 = "http://192.168.82.164:10063/api/jxqb/sys/captcha/getCurrentUser";
        String login = apply.login("GPKLmKwDgzI3FVw1bHJAR+agzNuAJqk7sLKxAIVmSbckM03WToHQ7HOtZgEW9Wianj1r0uX0WL4HaNKY+zGPfwi70iaJ+mNIlBmsW0XPRn3klpUlu58bWQGz1QvzSYY/ftxJ7cG+FenpvL6d2HOZbWhriYhq56xJGSPDnwbaNOo=","MPkdSXLXLpJKqY27Zdp3DjB3OUnohwBEVr9lvVNlv+B3JQ3+vxGcoEqcZ+4xn1L89vxZ/Zml6z0q8x1HpHgIf1lAB0Vpja2riGtwIhm3M/TxKcApv2h+n1djm2zosU1RGR5LFVOYesre/hgITA9YnbTWSmOaZx1b22hZftm4tg==");
        BaseConst_JXZLJ.setToken_zlj_sqr(login);
        System.out.println(login);

        String result1 = HttpRequest.get(url1)
                .header("Authorization",BaseConst_JXZLJ.getToken_zlj_sqr())
                .execute()
                .body();
        System.out.println(result1);*/






    }
}
