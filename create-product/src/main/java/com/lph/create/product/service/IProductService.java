package com.lph.create.product.service;

import com.lph.create.product.model.dto.ProductDto;
import com.lph.create.product.model.dto.ResultDataDto;

import java.util.List;

/**
 * @author penghui.li
 * @version 2.0
 * @date 2019/9/12 9:44
 */
public interface IProductService {
    ResultDataDto<List<ProductDto>> queryProducts();
}
