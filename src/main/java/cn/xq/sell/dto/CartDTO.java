package cn.xq.sell.dto;

import lombok.Data;

/**
 * @author: 紫苏
 * @date: 19-9-5 下午1:05
 * @description:
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
