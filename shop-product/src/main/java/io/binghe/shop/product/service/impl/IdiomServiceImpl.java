package io.binghe.shop.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.binghe.shop.bean.Idiom;
import io.binghe.shop.product.mapper.IdiomItemMapper;
import io.binghe.shop.product.mapper.IdiomMapper;
import io.binghe.shop.product.service.IdiomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IdiomServiceImpl implements IdiomService {

    private IdiomMapper idiomMapper;

    private IdiomItemMapper idiomItemMapper;

    @Autowired
    public void setIdiomMapper(IdiomMapper idiomMapper) {
        this.idiomMapper = idiomMapper;
    }

    @Autowired
    public void setIdiomItemMapper(IdiomItemMapper idiomItemMapper) {
        this.idiomItemMapper = idiomItemMapper;
    }

    @Override
    public Map<String, Object> getPageInfo(int pageIndex, int pageSize, QueryWrapper<Idiom> queryWrapper) {
        Page<Idiom> page = new Page<>(pageIndex, pageSize);
        Map<String, Object> map = new ConcurrentHashMap<>();
        Page<Idiom> idiomPage = this.idiomMapper.selectPage(page, queryWrapper);
        map.put("records", idiomPage.getRecords());
        map.put("total", idiomPage.getTotal());
        map.put("totalPage", idiomPage.getPages());
        return map;
    }
}
