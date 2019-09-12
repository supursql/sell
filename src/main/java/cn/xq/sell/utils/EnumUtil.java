package cn.xq.sell.utils;

import cn.xq.sell.enums.CodeEnum;

/**
 * @author: 紫苏
 * @date: 19-9-10 下午3:35
 * @description:
 */
public class EnumUtil {

    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }

        return null;
    }

}
