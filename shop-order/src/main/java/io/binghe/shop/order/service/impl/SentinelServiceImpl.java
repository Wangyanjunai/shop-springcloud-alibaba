package io.binghe.shop.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.binghe.shop.order.handler.MyBlockHandlerClass;
import io.binghe.shop.order.handler.MyFallbackClass;
import io.binghe.shop.order.service.SentinelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试类
 */
@Slf4j
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

    private int count = 0;

    /**
     * 测试方法2
     */
    @Override
    @SentinelResource(value = "sendMessage2",
            blockHandlerClass = MyBlockHandlerClass.class,
            blockHandler = "blockHandler",
            fallbackClass = MyFallbackClass.class,
            fallback = "fallback")
    public String sendMessage2() {
        count++;
        //25%的异常率
        if (count % 4 == 0) {
            throw new RuntimeException("25%的异常率");
        }
        return "sendMessage2";
    }

    public String blockHandler(BlockException e) {
        log.error("限流了:{}", e);
        return "限流了";
    }

    public String fallback(Throwable e) {
        log.error("异常了:{}", e);
        return "异常了";
    }
}
