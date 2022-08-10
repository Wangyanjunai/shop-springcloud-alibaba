package io.binghe.shop.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.bean.Order;
import io.binghe.shop.bean.OrderItem;
import io.binghe.shop.bean.Product;
import io.binghe.shop.bean.User;
import io.binghe.shop.dto.OrderParams;
import io.binghe.shop.order.mapper.OrderMapper;
import io.binghe.shop.order.mapper.OrderItemMapper;
import io.binghe.shop.order.service.OrderService;
import io.binghe.shop.utils.constants.HttpCode;
import io.binghe.shop.utils.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author binghe
 * @version 1.0.0
 * @description 订单业务接口实现
 */
@Service("orderServiceV1")
@Slf4j
public class OrderServiceV1Impl implements OrderService {

    private OrderMapper orderMapper;

    private OrderItemMapper orderItemMapper;

    private RestTemplate restTemplate;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    public void setOrderItemMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 保存订单
     *
     * @param orderParams
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrder(OrderParams orderParams) {
        if (orderParams.isEmpty()) {
            throw new RuntimeException("参数异常: " + JSONObject.toJSONString(orderParams));
        }

        User user = this.restTemplate.getForObject("http://localhost:8060/user/get/" + orderParams.getUserId(), User.class);
        if (user == null) {
            throw new RuntimeException("未获取到用户信息: " + JSONObject.toJSONString(orderParams));
        }

        Product product = this.restTemplate.getForObject("http://localhost:8070/product/get/" + orderParams.getProductId(), Product.class);
        if (product == null) {
            throw new RuntimeException("未获取到商品信息: " + JSONObject.toJSONString(orderParams));
        }

        if (product.getProStock() < orderParams.getCount()) {
            throw new RuntimeException("商品库存不足: " + JSONObject.toJSONString(orderParams));
        }
        Order order = new Order();
        order.setAddress(user.getAddress());
        order.setPhone(user.getPhone());
        order.setUserId(user.getId());
        order.setUsername(user.getUsername());
        order.setTotalPrice(product.getProPrice().multiply(BigDecimal.valueOf(orderParams.getCount())));
        this.orderMapper.insert(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setNumber(orderParams.getCount());
        orderItem.setOrderId(order.getId());
        orderItem.setProId(product.getId());
        orderItem.setProName(product.getProName());
        orderItem.setProPrice(product.getProPrice());
        this.orderItemMapper.insert(orderItem);

        Result<Integer> result = this.restTemplate.getForObject("http://localhost:8070/product/update_count/" + orderParams.getProductId() + "/" + orderParams.getCount(), Result.class);
        if (result.getCode() != HttpCode.SUCCESS) {
            throw new RuntimeException("库存扣减失败。");
        }
        log.info("库存扣减成功");
    }
}
