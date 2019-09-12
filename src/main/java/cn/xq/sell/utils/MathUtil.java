package cn.xq.sell.utils;

/**
 * @author: 紫苏
 * @date: 19-9-9 下午3:30
 * @description:
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
