package io.binghe.shop.order.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.binghe.shop.bean.Order;
import io.binghe.shop.vo.PageOrderVO;

import java.util.Map;

/**
 * @author binghe
 * @version 1.0.0
 * @description 订单业务接口
 */
public interface OrderService2 {
    /**
     * 分页查询订单
     *
     * @param pageIndex
     * @param pageSize
     * @param queryWrapper
     */
    PageOrderVO selectPage(int pageIndex, int pageSize, QueryWrapper<Order> queryWrapper);
}
