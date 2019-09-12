package cn.xq.sell.service;

import cn.xq.sell.dto.OrderDTO;

/**
 * @author: 紫苏
 * @date: 19-9-8 上午10:46
 * @description:
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
