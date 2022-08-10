package io.binghe.shop.order.feign;

import io.binghe.shop.bean.User;
//import io.binghe.shop.order.feign.fallback.UserServiceFallBack;
import io.binghe.shop.order.feign.fallback.factory.UserServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author binghe (公众号：冰河技术)
 * @version 1.0.0
 * @description 调用用户微服务的接口
 */
//@FeignClient(value = "server-user", fallback = UserServiceFallBack.class)
@FeignClient(value = "server-user", fallbackFactory = UserServiceFallBackFactory.class)
public interface UserService {

    @GetMapping(value = "/user/get/{uid}")
    User getUser(@PathVariable("uid") Long uid);
}
