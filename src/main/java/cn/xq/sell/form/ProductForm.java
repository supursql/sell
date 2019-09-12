package cn.xq.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: 紫苏
 * @date: 19-9-11 下午12:35
 * @description:
 */
@Data
public class ProductForm {

    /** id */
    private String productId;

    /** 名字 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 商品小图 */
    private String productIcon;

    /** 类目类型 */
    private Integer categoryType;


}
