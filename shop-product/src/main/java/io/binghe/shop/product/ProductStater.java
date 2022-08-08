package io.binghe.shop.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value = { "io.binghe.shop.product.mapper" })
@EnableTransactionManagement(proxyTargetClass = true)
public class ProductStater {

    public static void main(String[] args) {
        SpringApplication.run(ProductStater.class, args);
    }

}
