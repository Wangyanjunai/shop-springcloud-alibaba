package io.binghe.shop.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.bean.Order;
import io.binghe.shop.bean.OrderItem;
import io.binghe.shop.bean.Product;
import io.binghe.shop.bean.User;
import io.binghe.shop.dto.OrderParams;
import io.binghe.shop.order.mapper.OrderItemMapper;
import io.binghe.shop.order.mapper.OrderMapper;
import io.binghe.shop.order.service.OrderService;
import io.binghe.shop.utils.constants.HttpCode;
import io.binghe.shop.utils.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * @author binghe
 * @version 1.0.0
 * @description 订单业务接口实现
 */
@Service("orderServiceV3")
@Slf4j
public class OrderServiceV3Impl implements OrderService {

    private OrderMapper orderMapper;

    private OrderItemMapper orderItemMapper;

    private RestTemplate restTemplate;

    private DiscoveryClient discoveryClient;


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

    @Autowired
    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    private String getServiceUrl(String serviceName) {
        List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances(serviceName);
        int index = new Random().nextInt(serviceInstances.size());
        ServiceInstance serviceInstance = serviceInstances.get(index);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
        log.info("负载均衡后的服务地址为:{}", url);
        return url;
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

        String userServer = "server-user";
        String userUrl = this.getServiceUrl(userServer);

        String productServer = "server-product";
        String productUrl = this.getServiceUrl(productServer);

        User user = this.restTemplate.getForObject("http://" + userUrl + "/user/get/" + orderParams.getUserId(), User.class);
        if (user == null) {
            throw new RuntimeException("未获取到用户信息: " + JSONObject.toJSONString(orderParams));
        }

        Product product = this.restTemplate.getForObject("http://" + productUrl + "/product/get/" + orderParams.getProductId(), Product.class);
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

        Result<Integer> result = this.restTemplate.getForObject("http://" + productUrl + "/product/update_count/" + orderParams.getProductId() + "/" + orderParams.getCount(), Result.class);
        if (result.getCode() != HttpCode.SUCCESS) {
            throw new RuntimeException("库存扣减失败。");
        }
        log.info("库存扣减成功");
    }
}
