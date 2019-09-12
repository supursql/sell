package cn.xq.sell.dataobject;

import cn.xq.sell.enums.OrderStatusEnum;
import cn.xq.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午9:22
 * @description:
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    /** id */
    @Id
    private String orderId;

    /** 买家名称 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态 默认0新下单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态 默认0未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;
}
