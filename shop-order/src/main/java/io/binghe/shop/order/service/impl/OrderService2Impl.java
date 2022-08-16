package io.binghe.shop.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.binghe.shop.bean.Order;
import io.binghe.shop.bean.OrderItem;
import io.binghe.shop.order.mapper.OrderItemMapper;
import io.binghe.shop.order.mapper.OrderMapper;
import io.binghe.shop.order.service.OrderService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
    public Map<String, Object> selectPage(int pageIndex, int pageSize, QueryWrapper<Order> queryWrapper) {
        Page<Order> page = new Page<>(pageIndex, pageSize);
        Map<String, Object> map = new ConcurrentHashMap<>();
        Page<Order> orderPage = this.orderMapper.selectPage(page, queryWrapper);
        map.put("records", orderPage.getRecords());
        map.put("total", orderPage.getTotal());
        map.put("totalPage", orderPage.getPages());
        return map;
    }
}
