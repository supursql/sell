package cn.xq.sell.exception;

import cn.xq.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @author: 紫苏
 * @date: 19-9-5 下午12:40
 * @description:
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
