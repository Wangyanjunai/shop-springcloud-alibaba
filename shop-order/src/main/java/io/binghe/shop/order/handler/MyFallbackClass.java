package io.binghe.shop.order.handler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author binghe
 * @version 1.0.0
 * @description 定义异常时调用的方法
 */
@Slf4j
public class MyFallbackClass {
    public static String fallback(Throwable e){
        log.error("异常了:{}", e);
        return "异常了";
    }
}
