package com.lph.create.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ConfigClientApplication
 * @Description
 * @Author penghui.li
 * @Version V1.0.0
 * @Date 2019-06-18 15:27:06
 */
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MemberApplication {
    /**
     * http://localhost:8881/actuator/bus-refresh
     */
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}
