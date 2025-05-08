package org.utils.http;
import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Http {
    /**
     * 发送get请求
     */
    public String get(String token,String url){
        String result = HttpRequest.get(url).header("Authorization",token).cookie("").execute().body();
        return result;
    }

    /**
     * 发送post请求
     */
    public String post( String token, String url,String body) throws IOException {
        String result = HttpRequest.post(url)
                .header("Authorization",token)
                .cookie("")
                .body(body)
                .execute().body();
        return result;
    }

    public String postChange( String token, String url,String body) throws IOException {
        String result = HttpRequest.post(url)
                .header("Authorization",token)
                .cookie("")
                .body(body)
                .execute().body();
        return result;
    }

    /**
     * 发送表单类型请求，filename是路径
     */
    public String excel( String token, String url,Map dataMap) throws IOException {
        String result = HttpRequest.post(url)
                .header("Authorization",token)
                .header("content-type","multipart/form-data; boundary=----WebKitFormBoundaryL1yySoERhfeAEqLh")
                .form(dataMap)
                .execute().body();
        return result;
    }
}
