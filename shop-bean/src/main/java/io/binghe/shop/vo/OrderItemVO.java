package io.binghe.shop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

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
