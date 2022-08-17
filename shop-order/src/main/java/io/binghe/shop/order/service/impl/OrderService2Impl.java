package io.binghe.shop.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.binghe.shop.bean.Order;
import io.binghe.shop.bean.OrderItem;
import io.binghe.shop.converter.OrderItemToOrderItemVOConverter;
import io.binghe.shop.converter.OrderToOrderVOConverter;
import io.binghe.shop.order.mapper.OrderItemMapper;
import io.binghe.shop.order.mapper.OrderMapper;
import io.binghe.shop.order.service.OrderService2;
import io.binghe.shop.vo.OrderVO;
import io.binghe.shop.vo.PageOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService2Impl implements OrderService2 {

    private OrderMapper orderMapper;

    private OrderItemMapper orderItemMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    public void setOrderItemMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }


    /**
     * 分页查询订单
     *
     * @param pageIndex
     * @param pageSize
     * @param queryWrapper
     */
    @Override
    public PageOrderVO selectPage(int pageIndex, int pageSize, QueryWrapper<Order> queryWrapper) {
        Page<Order> page = new Page<>(pageIndex, pageSize);
        Page<Order> orderPage = this.orderMapper.selectPage(page, queryWrapper);
        List<Order> orderList = orderPage.getRecords();
        PageOrderVO pageOrderVO = new PageOrderVO();
        pageOrderVO.setTotal(orderPage.getTotal());
        pageOrderVO.setTotalPage(orderPage.getPages());
        List<OrderVO> orderVOList = new ArrayList<>();
        List<OrderItem> orderItemList;
        for (Order order : orderList) {
            OrderVO orderVO = OrderToOrderVOConverter.convert(order);
            Long orderId = order.getId();
            QueryWrapper<OrderItem> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("t_order_id", orderId);
            orderItemList = this.orderItemMapper.selectList(queryWrapper1);
            orderVO.setOrderItemVOList(OrderItemToOrderItemVOConverter.convert(orderItemList));
            orderVOList.add(orderVO);
        }
        pageOrderVO.setOrderVOList(orderVOList);
        return pageOrderVO;
    }
}
