package cn.xq.sell.service;

import cn.xq.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @author: 紫苏
 * @date: 19-9-9 下午1:19
 * @description:
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notityData);

    RefundResponse refund(OrderDTO orderDTO);

}
