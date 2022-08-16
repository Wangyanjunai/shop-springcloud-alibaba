package io.binghe.shop.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.binghe.shop.bean.Idiom;

import java.util.Map;

public interface IdiomService {

    Map<String, Object> getPageInfo(int pageIndex, int pageSize, QueryWrapper<Idiom> queryWrapper);
}
