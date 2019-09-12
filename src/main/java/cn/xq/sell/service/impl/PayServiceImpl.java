package cn.xq.sell.service.impl;

import cn.xq.sell.dto.OrderDTO;
import cn.xq.sell.enums.ResultEnum;
import cn.xq.sell.exception.SellException;
import cn.xq.sell.service.OrderService;
import cn.xq.sell.service.PayService;
import cn.xq.sell.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: 紫苏
 * @date: 19-9-9 下午1:20
 * @description:
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    private static final String ORDER_NAME = "微信点餐单";

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【发起支付】request={}", payRequest);

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【发起支付】response={}", payResponse);
        return payResponse;
    }

    @Override
    public PayResponse notify(String notityData) {
        //1. 验证订单
        //2. 支付的状态
        //3. 校验金额
        //4. 支付人(下单人 == 支付人)

         PayResponse payResponse =bestPayService.asyncNotify(notityData);
         log.info("【微信支付】异步通知，payResponse={}",payResponse);

         OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());

         if (orderDTO == null) {
             throw new SellException(ResultEnum.ORDER_NOT_EXIST);
         }

         if (!MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue() )) {
             throw new SellException(ResultEnum.WXPAY_NOTITY_MONEY_VERIFY_ERROR);
         }

         orderService.paid(orderDTO);

         return payResponse;
    }

    @Override
    public RefundResponse refund(OrderDTO orderDTO) {

        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);

        RefundResponse refundResponse =  bestPayService.refund(refundRequest);
        return refundResponse;
    }
}
