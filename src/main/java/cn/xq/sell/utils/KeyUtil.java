package cn.xq.sell.utils;

import java.util.Random;

/**
 * @author: 紫苏
 * @date: 19-9-5 下午12:53
 * @description:
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return String.valueOf(number) + System.currentTimeMillis();
    }

}
