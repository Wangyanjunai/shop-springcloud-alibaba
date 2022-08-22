package io.binghe.shop.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author binghe
 * @version 1.0.0
 * @description 启动用户服的类
 */
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value = {"io.binghe.shop.user.mapper"})
@EnableDiscoveryClient
@EnableAsync
public class UserStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserStarter.class, args);
    }
}
