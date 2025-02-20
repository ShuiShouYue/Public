package org.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author jackkang
 * @Description 请求参数解析
 */
public class GetJsonUtil {

    //读取resources里面的JSON字符串，不过滤空值
    public static String getJson( String path) throws IOException {
        File jsonFile1 = ResourceUtils.getFile("src/main/resources/" + path);
        String json = FileUtils.readFileToString(jsonFile1);
        return json;
    }

    //jsonz字符串z转换成Map
    public static Map<String, Object> json2Map(JSONObject json) {
        Map<String, Object> resultMap = new HashMap<>();
        //循环转换
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            resultMap.put(entry.getKey(), entry.getValue());
        }
        return resultMap;
    }

    //json中部分key进行替换
    public static JSONObject changeJsonObj(JSONObject jsonObject, Map<String, String> keyMap) {
        JSONObject resJson = new JSONObject();
        Set<String> keySet = jsonObject.keySet();
        for (String key : keySet) {
            String resKey = keyMap.get(key) == null ? key : keyMap.get(key);
            try {
                JSONObject jsonObject_temp = jsonObject.getJSONObject(key);
                resJson.put(resKey, changeJsonObj(jsonObject_temp, keyMap));
            } catch (Exception e) {
                try {
                    JSONArray jsonArr = jsonObject.getJSONArray(key);
                    resJson.put(resKey, changeJsonArr(jsonArr, keyMap));
                } catch (Exception e1) {
                    resJson.put(resKey, jsonObject.get(key));
                }
            }
        }
        return resJson;
    }

    public static JSONArray changeJsonArr(JSONArray jsonArr, Map<String, String> keyMap) {
        JSONArray resJson = new JSONArray();
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            resJson.add(changeJsonObj(jsonObj, keyMap));
        }
        return resJson;
    }

    //替换json中的value值
    public static JSONObject changeJsonValue(String paramStr, Map<String, Object> valueMap) {
        LinkedHashMap<String, Object> jsonMap = JSON.parseObject(paramStr, LinkedHashMap.class, Feature.OrderedField);
        JSONObject resJson = new JSONObject(true);
        resJson.putAll(jsonMap);
        //替换
        for (Map.Entry<String, Object> entry : valueMap.entrySet()) {
            if (resJson.containsKey(entry.getKey())) {
                resJson.put(entry.getKey(), entry.getValue());
            } else {
                //遍历json
                for (Map.Entry<String, Object> temEntry : resJson.entrySet()) {
                    Object o = temEntry.getValue();
                    if (o instanceof String) {
                        continue;
                    } else if (o instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) o;
                        for (int i = 0; i < jsonArray.size(); i++) {
                            if (jsonArray.getJSONObject(i).containsKey(entry.getKey())) {
                                resJson.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                }
            }
        }
        return resJson;
    }

    //map转jsonObject
    public static JSONObject map2Json(Map<String, Object> map) {
        String result = JSONObject.toJSONString(map2Json(map));
        return JSON.parseObject(result);
    }

}