package cn.xq.sell.dataobject;

import cn.xq.sell.enums.ProductStatusEnum;
import cn.xq.sell.utils.EnumUtil;
import cn.xq.sell.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午1:47
 * @description:
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    /** id */
    @Id
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

    /** 状态 0正常1下架 */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目类型 */
    private Integer categoryType;

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 修改时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
