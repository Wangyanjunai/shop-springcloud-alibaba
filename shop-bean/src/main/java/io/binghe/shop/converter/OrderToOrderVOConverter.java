package io.binghe.shop.converter;

import io.binghe.shop.bean.Order;
import io.binghe.shop.vo.OrderVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderToOrderVOConverter {

    public static OrderVO convert(Order order) {
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(order, orderVO);
        return orderVO;
    }

    public static List<OrderVO> convert(List<Order> orderList) {
        return orderList.stream().map(OrderToOrderVOConverter::convert).collect(Collectors.toList());
    }
}
