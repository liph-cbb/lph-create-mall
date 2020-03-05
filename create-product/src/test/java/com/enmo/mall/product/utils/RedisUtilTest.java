package com.enmo.mall.product.utils;

import com.lph.create.product.common.utils.RedisUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author penghui.li
 * @version 2.0
 * @date 2019/9/17 17:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisUtil.class)
@Ignore
public class RedisUtilTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void setString(){
        redisUtil.set("lipenghui","lipenhui");
    }

    @Test
    public void getString(){
        Object lipenghui = redisUtil.get("lipenghui");
//        log.info(lipenghui.toString());
    }
}
