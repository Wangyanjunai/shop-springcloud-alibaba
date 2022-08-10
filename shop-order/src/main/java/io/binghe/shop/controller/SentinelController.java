package io.binghe.shop.controller;

import io.binghe.shop.order.service.SentinelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试Sentinel
 */
@Slf4j
@RestController
public class SentinelController {

    private SentinelService sentinelService;

    @Autowired
    public void setSentinelService(SentinelService sentinelService) {
        this.sentinelService = sentinelService;
    }

    @GetMapping(value = "/request_sentinel1")
    public String requestSentinel1(){
        log.info("测试Sentinel1");
        sentinelService.sendMessage();
        return "sentinel1";
    }
    @GetMapping(value = "/request_sentinel2")
    public String requestSentinel2(){
        log.info("测试Sentinel2");
        sentinelService.sendMessage();
        return "sentinel2";
    }
}
