package com.lph.create.product.controller;

import com.lph.create.product.model.dto.ProductDto;
import com.lph.create.product.model.dto.ResultDataDto;
import com.lph.create.product.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author penghui.li
 * @version 2.0
 * @date 2019/9/12 9:44
 */
@RestController
@RequestMapping(value = "/pro")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    /**
     * 查询产品列表
     * @param
     * @return
     */
    @GetMapping
    public ResultDataDto<List<ProductDto>> queryProducts() {
        return productService.queryProducts();
    }
}
