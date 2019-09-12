package cn.xq.sell.vo;

import lombok.Data;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午2:27
 * @description:
 */
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;

}
