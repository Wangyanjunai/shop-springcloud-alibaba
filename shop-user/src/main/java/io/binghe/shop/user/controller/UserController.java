package io.binghe.shop.user.controller;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.bean.User;
import io.binghe.shop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author binghe
 * @version 1.0.0
 * @description 用户接口
 */
@Slf4j
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get/{uid}")
    public User getUser(@PathVariable("uid") Long uid) {
        User user = this.userService.getUserById(uid);
        log.info("获取到的用户信息为：{}", JSONObject.toJSONString(user));
        return user;
    }

    @GetMapping(value = "/api1/demo1")
    public String api1Demo1() {
        log.info("访问了api1Demo1接口");
        return "api1Demo1";
    }

    @GetMapping(value = "/api1/demo2")
    public String api1Demo2() {
        log.info("访问了api1Demo2接口");
        return "api1Demo2";
    }

    @GetMapping(value = "/api2/demo1")
    public String api2Demo1() {
        log.info("访问了api2Demo1接口");
        return "api2Demo1";
    }

    @GetMapping(value = "/api2/demo2")
    public String api2Demo2() {
        log.info("访问了api2Demo2接口");
        return "api2Demo2";
    }

    @GetMapping(value = "/async/api")
    public String asyncApi() {
        log.info("执行异步任务开始……");
        this.userService.asyncMethod();
        log.info("异步任务执行结束……");
        return "asyncApi";
    }

    @GetMapping(value = "/sleuth/filter/api")
    public String sleuthFilter(HttpServletRequest request) {
        Object traceIdObj = request.getAttribute("traceId");
        String traceId = traceIdObj == null ? "" : traceIdObj.toString();
        log.info("获取到的traceId为: " + traceId);
        return "sleuthFilter";
    }


}
