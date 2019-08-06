package com.lph.create.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ProductApplication
 * @Description
 * @Author penghui.li
 * @Version V1.0.0
 * @Date 2019-06-18 15:27:06
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
public class ProductApplication {
    /**
     * http://localhost:8881/actuator/bus-refresh
     */
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
