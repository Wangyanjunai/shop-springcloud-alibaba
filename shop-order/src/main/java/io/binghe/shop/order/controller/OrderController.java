package io.binghe.shop.order.controller;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.dto.OrderParams;
import io.binghe.shop.order.service.OrderService;
import io.binghe.shop.order.service.OrderService2;
import io.binghe.shop.order.service.SentinelService;
import io.binghe.shop.utils.constants.HttpCode;
import io.binghe.shop.utils.resp.Result;
import io.binghe.shop.vo.PageOrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class OrderController {
    private OrderService orderServiceV1;

    private OrderService orderServiceV2;

    private OrderService orderServiceV3;

    private OrderService orderServiceV4;

    private OrderService orderServiceV5;

    private OrderService orderServiceV6;

    private OrderService2 orderService2;

    private SentinelService sentinelService;

    @Autowired
    @Qualifier(value = "orderServiceV1")
    public void setOrderServiceV1(OrderService orderServiceV1) {
        this.orderServiceV1 = orderServiceV1;
    }

    @Autowired
    @Qualifier(value = "orderServiceV2")
    public void setOrderServiceV2(OrderService orderServiceV2) {
        this.orderServiceV2 = orderServiceV2;
    }

    @Autowired
    @Qualifier(value = "orderServiceV3")
    public void setOrderServiceV3(OrderService orderServiceV3) {
        this.orderServiceV3 = orderServiceV3;
    }

    @Autowired
    @Qualifier(value = "orderServiceV4")
    public void setOrderServiceV4(OrderService orderServiceV4) {
        this.orderServiceV4 = orderServiceV4;
    }

    @Autowired
    @Qualifier("orderServiceV5")
    public void setOrderServiceV5(OrderService orderServiceV5) {
        this.orderServiceV5 = orderServiceV5;
    }

    @Autowired
    @Qualifier("orderServiceV6")
    public void setOrderServiceV6(OrderService orderServiceV6) {
        this.orderServiceV6 = orderServiceV6;
    }

    @Autowired
    public void setSentinelService(SentinelService sentinelService) {
        this.sentinelService = sentinelService;
    }

    @Autowired
    public void setOrderService2(OrderService2 orderService2) {
        this.orderService2 = orderService2;
    }

    @GetMapping(value = "/submit_order1")
    public String submitOrder1(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderServiceV1.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order2")
    public String submitOrder2(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderServiceV2.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order3")
    public String submitOrder3(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderServiceV3.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order4")
    public String submitOrder4(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderServiceV4.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order5")
    public String submitOrder5(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderServiceV5.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/submit_order6")
    public String submitOrder6(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        this.orderServiceV6.saveOrder(orderParams);
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
        this.sentinelService.sendMessage();
        return "sentinel";
    }

    @GetMapping(value = "/test_sentinel2")
    public String testSentinel2() {
        log.info("测试Sentinel2");
        this.sentinelService.sendMessage();
        return "sentinel2";
    }

    @GetMapping(value = "/pages/{pageNum}/{pageSize}")
    public Result<PageOrderVO> pages(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        log.info("分页查询传递的参数为: 当前页码:{}, 每页条数:{} ", pageNum, pageSize);
        PageOrderVO pageOrderVO = this.orderService2.selectPage(pageNum, pageSize, null);
        return new Result<>(HttpCode.SUCCESS, "执行成功", pageOrderVO);
    }
}
