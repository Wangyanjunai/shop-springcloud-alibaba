package io.binghe.shop.user.service;

import io.binghe.shop.bean.User;

/**
 * @author binghe
 * @version 1.0.0
 * @description 用户业务接口
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     */
    User getUserById(Long userId);

    /**
     * 异步方法
     */
    void asyncMethod();
}
