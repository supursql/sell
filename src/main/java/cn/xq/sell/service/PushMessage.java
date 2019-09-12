package cn.xq.sell.service;

import cn.xq.sell.dto.OrderDTO;

/**
 * @author: 紫苏
 * @date: 19-9-11 下午11:50
 * @description:
 */
public interface PushMessage {

    void orderStatus(OrderDTO orderDTO);

}
