package cn.xq.sell.enums;

import lombok.Getter;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午9:30
 * @description:
 */
@Getter
public enum PayStatusEnum implements CodeEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");


    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
