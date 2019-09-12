package cn.xq.sell.service.impl;

import cn.xq.sell.dto.OrderDTO;
import cn.xq.sell.enums.ResultEnum;
import cn.xq.sell.exception.SellException;
import cn.xq.sell.service.BuyerService;
import cn.xq.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 紫苏
 * @date: 19-9-8 上午10:47
 * @description:
 */
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到该订单，orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);

        if (orderDTO == null) {
            return null;
        }

        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】订单的openid不一致，openid={}，orderId={}", openid, orderId);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
