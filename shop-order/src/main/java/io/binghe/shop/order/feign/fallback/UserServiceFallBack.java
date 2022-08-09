package io.binghe.shop.order.feign.fallback;

import io.binghe.shop.bean.User;
import io.binghe.shop.order.feign.UserService;
import org.springframework.stereotype.Component;

/**
 * @author binghe (公众号：冰河技术)
 * @version 1.0.0
 * @description 用户服务容错类
 */
@Component
public class UserServiceFallBack implements UserService {
    @Override
    public User getUser(Long uid) {
        User user = new User();
        user.setId(-1L);
        return user;
    }
}
