package cn.xq.sell.enums;

import lombok.Getter;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午2:11
 * @description:
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0, "在架"),
    DOWN(1, "下架")
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
