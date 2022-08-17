package io.binghe.shop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PageOrderVO {

    @JsonProperty(value = "records")
    private List<OrderVO> orderVOList;

    @JsonProperty(value = "total")
    private Long total;

    @JsonProperty(value = "totalPage")
    private Long totalPage;
}
