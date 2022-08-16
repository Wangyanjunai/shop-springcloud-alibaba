package io.binghe.shop.product.controller;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.bean.Product;
import io.binghe.shop.product.service.IdiomService;
import io.binghe.shop.product.service.ProductService;
import io.binghe.shop.utils.constants.HttpCode;
import io.binghe.shop.utils.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author binghe
 * @version 1.0.0
 * @description 商品api
 */
@RestController
@Slf4j
public class ProductController {

    private ProductService productService;

    private IdiomService idiomService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setIdiomService(IdiomService idiomService) {
        this.idiomService = idiomService;
    }

    @GetMapping(value = "/get/{pid}")
    public Product getProduct(@PathVariable("pid") Long pid) {
        Product product = productService.getProductById(pid);
        log.info("获取到的商品信息为：{}", JSONObject.toJSONString(product));
        return product;
    }

    @GetMapping(value = "/update_count/{pid}/{count}")
    public Result<Integer> updateCount(@PathVariable("pid") Long pid, @PathVariable("count") Integer count) {
        log.info("更新商品库存传递的参数为: 商品id:{}, 购买数量:{} ", pid, count);
        int updateCount = productService.updateProductStockById(count, pid);
        Result<Integer> result = new Result<>(HttpCode.SUCCESS, "执行成功", updateCount);
        return result;
    }

    @GetMapping(value = "/pages/{pageNum}/{pageSize}")
    public Result<Map<String, Object>> updateCount(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        log.info("分页查询传递的参数为: 当前页码:{}, 每页条数:{} ", pageNum, pageSize);
        Map<String, Object> map = this.idiomService.getPageInfo(pageNum, pageSize, null);
        Result<Map<String, Object>> result = new Result<>(HttpCode.SUCCESS, "执行成功", map);
        return result;
    }
}
