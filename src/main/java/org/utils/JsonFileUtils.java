package org.utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.alibaba.fastjson.JSONObject;
import org.utils.api.AbstractFileReader;

/**
 *  Description:JsonFileUtils
 */
public final class JsonFileUtils {
    private JsonFileUtils(){}

    /**
     * 文件读取责任链头部
     * 先读取包外jar同级目录的json
     * 再读取包内Resource下的json
     *
     */
    private static final AbstractFileReader HEADER;
    static {
        AbstractFileReader systemFileReader = new SystemFileReader();
        ResourceFileReader resourceFileReader = new ResourceFileReader();
        systemFileReader.setNext(resourceFileReader);
        HEADER = systemFileReader;
    }


    /**
     * 应用场景比较单一，只能读取最外层为花括号的json，最外层为数组的json文件无法读取
     * @param path 读取路径
     * @return 读取结果
     * @throws IOException 异常
     */
    public static Map<String,Object> readFile(String path) throws IOException {
        InputStream resourceAsStream = HEADER.readFile(path);

        if (resourceAsStream == null) {
            return null;
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(resourceAsStream, Map.class);
        }
    }

    public static JSONObject readJson(String path) throws IOException {
        Map<String, Object> map = new HashMap<String , Object>();
        InputStream resourceAsStream = HEADER.readFile(path);
        if (resourceAsStream == null) {
            return null;
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            map = objectMapper.readValue(resourceAsStream, JSONObject.class);
            JSONObject jsonObject = new JSONObject(map);
            return jsonObject;
        }
    }

    /**
     * 能够读取对象和数组两种形式的json。返回结果难以修改
     * @param path 路径
     * @return 数据
     * @throws IOException 异常
     */
    public static Object readFileToObject(String path) throws IOException {
        InputStream resourceAsStream = HEADER.readFile(path);

        if (resourceAsStream == null) {
            return null;
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(resourceAsStream, Object.class);
        }
    }



    /**
     * 返回结果易修改
     */
    public static JsonNode readFileToJson(String path) throws IOException {
        InputStream resourceAsStream = HEADER.readFile(path);

        if (resourceAsStream == null) {
            return null;
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(getStr(resourceAsStream));
        }
    }

    public static String getStr(InputStream stream){
        try {
            Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            int ch;
            StringBuilder sb = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}