package io.binghe.shop.order.controller;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.dto.OrderParams;
import io.binghe.shop.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {
    private OrderService orderService;

    private OrderService orderService2;

    private OrderService orderService3;

    private OrderService orderService4;

    private OrderService orderService5;

    @Autowired
    @Qualifier(value = "orderServiceV1")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    @Qualifier(value = "orderServiceV2")
    public void setOrderService2(OrderService orderService2) {
        this.orderService2 = orderService2;
    }

    @Autowired
    @Qualifier(value = "orderServiceV3")
    public void setOrderService3(OrderService orderService3) {
        this.orderService3 = orderService3;
    }

    @Autowired
    @Qualifier(value = "orderServiceV4")
    public void setOrderService4(OrderService orderService4) {
        this.orderService4 = orderService4;
    }

    @Autowired
    @Qualifier("orderServiceV5")
    public void setOrderService5(OrderService orderService5) {
        this.orderService5 = orderService5;
    }

    @GetMapping(value = "/submit_order")
    public String submitOrder(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderService.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order2")
    public String submitOrder2(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderService2.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order3")
    public String submitOrder3(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderService3.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order4")
    public String submitOrder4(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderService4.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order5")
    public String submitOrder5(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderService5.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/concurrent_request")
    public String concurrentRequest() {
        log.info("测试业务在高并发场景下是否存在问题");
        return "binghe";
    }

    @GetMapping(value = "/test_sentinel")
    public String testSentinel() {
        log.info("测试Sentinel");
        return "sentinel";
    }

}
