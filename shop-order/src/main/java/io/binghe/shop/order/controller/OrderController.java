package io.binghe.shop.order.controller;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.dto.OrderParams;
import io.binghe.shop.order.service.OrderService;
import io.binghe.shop.order.service.impl.OrderService2Impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {
    private OrderService orderService;


    private OrderService2Impl orderService2;


    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setOrderService2(OrderService2Impl orderService2) {
        this.orderService2 = orderService2;
    }

    @GetMapping(value = "/submit_order")
    public String submitOrder(OrderParams orderParams){
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        orderService.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order2")
    public String submitOrder2(OrderParams orderParams){
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        orderService2.saveOrder(orderParams);
        return "success";
    }
}
