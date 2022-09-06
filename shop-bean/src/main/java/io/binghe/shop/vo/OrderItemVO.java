package io.binghe.shop.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemVO {
    /**
     * 数据id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long proId;
    /**
     * 商品名称
     */
    private String proName;
    /**
     * 商品价格（单价）
     */
    private BigDecimal proPrice;
    /**
     * 购买数量
     */
    private Integer number;
}
