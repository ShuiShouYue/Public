package org.utils.random.name;

import java.util.Random;

public class RandomNames {
    // 生成一个包含2-4个字的中文名称
    public static String generateChineseName() {
        StringBuilder chineseName = new StringBuilder();
        // Unicode范围：4e00-9fa5 是中文字符的范围
        int unicodeStart = 0x4e00;
        int unicodeEnd = 0x9fa5;
        Random random = new Random();
        //参数控制生成名字的长度（2个字/3个字）
        for (int i = 0; i < random.nextInt(3)+2; i++) {
            // 生成随机中文字符
            char randomChar = (char) (unicodeStart + random.nextInt(unicodeEnd - unicodeStart + 1));
            chineseName.append(randomChar);
        }
        return chineseName.toString();

    }
}
