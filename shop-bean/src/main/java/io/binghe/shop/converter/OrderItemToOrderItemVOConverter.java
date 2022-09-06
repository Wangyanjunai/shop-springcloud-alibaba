package io.binghe.shop.converter;

import io.binghe.shop.bean.OrderItem;
import io.binghe.shop.vo.OrderItemVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderItemToOrderItemVOConverter {

    public static OrderItemVO convert(OrderItem orderItem) {
        OrderItemVO orderItemVO = new OrderItemVO();
        BeanUtils.copyProperties(orderItem, orderItemVO);
        return orderItemVO;
    }

    public static List<OrderItemVO> convert(List<OrderItem> orderItemList) {
        return orderItemList.stream().map(OrderItemToOrderItemVOConverter::convert).collect(Collectors.toList());
    }
}
