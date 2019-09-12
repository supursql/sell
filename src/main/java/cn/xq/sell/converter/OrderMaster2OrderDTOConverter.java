package cn.xq.sell.converter;

import cn.xq.sell.dataobject.OrderMaster;
import cn.xq.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 紫苏
 * @date: 19-9-5 下午3:26
 * @description:
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(
                e -> convert(e)
        ).collect(Collectors.toList());
    }
}
