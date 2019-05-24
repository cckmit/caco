package io.uoko.caco.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author uokoer
 */
@MapperScan(value = "io.uoko.caco.gateway.dao")
@ComponentScan(value = "io.uoko")
@SpringCloudApplication
@EnableZuulProxy
public class CacoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacoGatewayApplication.class, args);
    }

}
