package io.binghe.shop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderVO {
    /**
     * 数据id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 商品价格（总价）
     */
    private BigDecimal totalPrice;
    /**
     * 订单条目列表
     */
    @JsonProperty(value = "itemList")
    private List<OrderItemVO> orderItemVOList;
}
