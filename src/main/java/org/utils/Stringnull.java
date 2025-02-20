package org.utils;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *  去掉字符串String里为空的字段方法
 */
public class Stringnull {
    public static String trimnull(String string) throws UnsupportedEncodingException {
        ArrayList<Byte> list = new ArrayList<Byte>();
        byte[] bytes = string.getBytes("UTF-8");
        for (int i = 0; bytes != null && i < bytes.length; i++) {
            if (0 != bytes[i]) {
                list.add(bytes[i]);
            }
        }
        byte[] newbytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newbytes[i] = (Byte) list.get(i);
        }
        String str = new String(newbytes, "UTF-8");
        return str;
    }
    private  static Map<String, Object> removeEmpty(Map<String, ?> paramsMap) {
        return paramsMap.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .filter(entry -> !(entry.getValue() instanceof String) || StringUtils.isNotEmpty((String) entry.getValue()))
                .filter(entry -> !(entry.getValue() instanceof List) || CollectionUtils.isNotEmpty((List<?>) entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

/*    public static void main(String[] args) throws IOException {

        String body = JsonFileUtils.readJson("/json/xzpm/request/findPageCompanyProduct.json").toJSONString();
        System.out.println(body);
        System.out.println(Stringnull.trimnull(body));
    }*/

}


