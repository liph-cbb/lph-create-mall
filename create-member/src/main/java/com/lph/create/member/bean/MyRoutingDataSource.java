package com.lph.create.member.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @ClassName MyRoutingDataSource
 * @Description
 * @Author penghui.li
 * @Version V1.0.0
 * @Date 2019-08-07 11:09:03
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
