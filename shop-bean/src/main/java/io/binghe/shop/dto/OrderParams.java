package io.binghe.shop.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class OrderParams {

    private int count;

    private Long productId;

    private Long userId;

    public boolean isEmpty() {
        return Objects.isNull(this) || Objects.isNull(this.getCount()) || this.getCount() <= 0 || Objects.isNull(this.getProductId()) || Objects.isNull(this.getUserId());
    }
}
