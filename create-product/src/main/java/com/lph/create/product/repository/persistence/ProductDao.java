package com.lph.create.product.repository.persistence;

import com.lph.create.product.repository.jooq.tables.records.TProductProductRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author penghui.li
 * @version 2.0
 * @date 2019/9/12 9:52
 */
@Repository
public class ProductDao extends BaseDao {

    public List<TProductProductRecord> queryProducts() {
        return create.selectFrom(T_PRODUCT_PRODUCT)
                .where(T_PRODUCT_PRODUCT.ID.isNotNull())
                .fetch();
    }

    /**
     * 单个插入
     * @param record
     * @return
     */
    public int insert(TProductProductRecord record){
        return create.executeInsert(record);
    }

    /**
     * 批量插入
     * @param records
     * @return
     */
    public int insertList(List<TProductProductRecord> records){
        return create.batchInsert(records).execute().length;
    }
}
