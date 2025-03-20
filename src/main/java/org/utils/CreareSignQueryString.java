package org.utils;

import org.springframework.util.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class CreareSignQueryString {
    public static String CreareSignQueryString(String formStr, String appSecret) throws UnsupportedEncodingException, URISyntaxException, MalformedURLException {
        if (StringUtils.isEmpty(appSecret)) {
            return formStr;
        }
        String signQueryString = "";
        //将参数存入字符数组
        String[] dataArry = formStr.split("&");
        //定义字典,将参数按照键值对存入字典中
        Map<String,String> dics = new HashMap<>();
        dics.put("appsecret", appSecret);
        //遍历字符数组
        for (int i = 0; i <= dataArry.length - 1; i++) {
            //当前参数值
            String dataParm = dataArry[i];
            //"="的索引值
            int dIndex = dataParm.indexOf("=");
            //参数名做为key
            String key = dataParm.substring(0, dIndex);
            //参数值做为Value
            String value = dataParm.substring(dIndex + 1, dIndex + 1 + dataParm.length() - dIndex - 1);
            //将编码后的Value解码
            String deValue = URLDecoder.decode(value, "UTF-8");
            if (key != "__VIEWSTATE") {
                //将参数以键值对存入字典
                dics.put(key, deValue);
            }
        }

        List<String> arrKeys = new ArrayList<>(dics.keySet());
        Collections.sort(arrKeys, String::compareToIgnoreCase);
        for (String key : arrKeys) {
            String value = dics.get(key);
            String test = java.net.URLEncoder.encode(value, "UTF-8");
            signQueryString+=((signQueryString.length() == 0 ? "" : "&") + key + "=" + test);
        }

        String createsign = MD5Encrypt32(signQueryString);
        return createsign;
    }

    public static String MD5Encrypt32(String password) {
        String cl = password;
        StringBuilder pwd = new StringBuilder();
        try {
            // 实例化一个MD5对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 加密后是一个字节类型的数组，这里要注意编码的选择，这里使用UTF-8编码
            byte[] s = md5.digest(cl.getBytes(StandardCharsets.UTF_8));
            // 通过使用循环，将字节类型的数组转换为字符串，此字符串是常规字符格式化所得
            for (int i = 0; i < s.length; i++) {
                // 将得到的字符串使用十六进制类型格式。格式后的字符是小写的字母，如果使用大写（toUpperCase）则格式后的字符是大写字符
                pwd.append(String.format("%02x", s[i]));
            }
        } catch (NoSuchAlgorithmException e) {

        }
        return pwd.toString().toUpperCase();
    }
}
