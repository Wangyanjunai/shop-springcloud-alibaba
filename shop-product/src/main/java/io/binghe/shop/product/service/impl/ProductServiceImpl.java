package io.binghe.shop.product.service.impl;

import io.binghe.shop.bean.Product;
import io.binghe.shop.product.mapper.ProductMapper;
import io.binghe.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author binghe
 * @version 1.0.0
 * @description 商品业务实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;

    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    /**
     * 根据商品id获取商品信息
     *
     * @param pid
     */
    @Override
    public Product getProductById(Long pid) {
        return this.productMapper.selectById(pid);
    }

    /**
     * 扣减商品库存
     *
     * @param count
     * @param id
     */
    @Override
    public int updateProductStockById(Integer count, Long id) {
        return this.productMapper.updateProductStockById(count, id);
    }
}
