package com.lph.create.product.service.impl;

import com.lph.create.product.common.utils.RedisUtil;
import com.lph.create.product.model.dto.ProductDto;
import com.lph.create.product.model.dto.ResultDataDto;
import com.lph.create.product.repository.jooq.tables.records.TProductProductRecord;
import com.lph.create.product.repository.persistence.ProductDao;
import com.lph.create.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author penghui.li
 * @version 2.0
 * @date 2019/9/12 9:45
 */

@Service
@Slf4j
public class ProductService implements IProductService {

    private final ProductDao dao;

    private final RedisUtil redisUtil;

    public ProductService(ProductDao dao,RedisUtil redisUtil){
        this.dao = dao;
        this.redisUtil = redisUtil;
    }

    @Override
    public ResultDataDto<List<ProductDto>> queryProducts() {
        List<TProductProductRecord> tProductProductRecords = dao.queryProducts();
        List<ProductDto> collect = tProductProductRecords.stream().map(this::assembleDto).collect(Collectors.toList());
        //测试redis
        redisUtil.set("lipenghui","lipenhui");
        log.info(redisUtil.get("lipenghui").toString());
        return new ResultDataDto<>(collect,"1000","query success");
    }

    public ProductDto assembleDto(TProductProductRecord record){
        ProductDto productDto = new ProductDto();
        productDto.setId(record.getId());
        productDto.setName(record.getName());
        return productDto;
    }
}
