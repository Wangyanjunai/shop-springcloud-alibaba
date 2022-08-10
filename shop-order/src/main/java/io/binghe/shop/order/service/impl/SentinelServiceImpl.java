package io.binghe.shop.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.binghe.shop.order.service.SentinelService;
import org.springframework.stereotype.Service;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试类
 */
@Service
public class SentinelServiceImpl implements SentinelService {

    /**
     * 测试方法
     */
    @Override
    @SentinelResource("sendMessage")
    public void sendMessage() {
        System.out.println("测试Sentinel的链路流控模式");
    }
}
