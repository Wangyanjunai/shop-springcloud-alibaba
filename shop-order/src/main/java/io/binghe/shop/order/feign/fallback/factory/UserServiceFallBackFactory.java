package io.binghe.shop.order.feign.fallback.factory;

import feign.hystrix.FallbackFactory;
import io.binghe.shop.bean.User;
import io.binghe.shop.order.feign.UserService;
import org.springframework.stereotype.Component;

/**
 * @author binghe (公众号：冰河技术)
 * @version 1.0.0
 * @description 用户微服务容错Factory
 */
@Component
public class UserServiceFallBackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable cause) {
        return new UserService() {
            @Override
            public User getUser(Long uid) {
                User user = new User();
                user.setId(-1L);
                return user;
            }

        };
    }
}
