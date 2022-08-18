package io.binghe.shop.user.service.impl;

import io.binghe.shop.bean.User;
import io.binghe.shop.user.mapper.UserMapper;
import io.binghe.shop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author binghe
 * @version 1.0.0
 * @description 用户业务实现类
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectById(userId);
    }

    /**
     * 异步方法
     */
    @Override
    @Async
    public void asyncMethod() {
        log.info("执行了异步任务……");
    }
}
