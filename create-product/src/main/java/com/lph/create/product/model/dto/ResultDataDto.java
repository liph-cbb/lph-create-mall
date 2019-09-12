package com.lph.create.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @ClassName:     package-info.java
 * @Description:
 * @Author         guo.yu
 * @Version        V1.0.0
 * @Date           2019-04-24 20:38:33
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class ResultDataDto<T> {

    private T data;

    @NonNull
    private String code;

    @NonNull
    private String msg;

}
