package org.utils.http;
import cn.hutool.http.HttpRequest;
import java.io.IOException;

public class Http {
    public String get(String token,String url){
        String result = HttpRequest.get(url).header("Authorization",token).cookie("").execute().body();
        return result;
    }
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
}
