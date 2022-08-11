package io.binghe.shop.order.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author binghe
 * @version 1.0.0
 * @description 定义被Sentinel限流时调用的方法
 */
@Slf4j
public class MyBlockHandlerClass {
    public static String blockHandler(BlockException e){
        log.error("限流了:{}", e);
        return "限流了";
    }
}
