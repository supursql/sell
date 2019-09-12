package cn.xq.sell.enums;

import lombok.Getter;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午9:27
 * @description:
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
