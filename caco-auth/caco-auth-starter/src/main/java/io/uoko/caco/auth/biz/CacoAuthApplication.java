package io.uoko.caco.auth.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = {"io.uoko.caco.uc"})
@ComponentScan("io.uoko.caco")
@SpringCloudApplication
public class CacoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacoAuthApplication.class, args);
    }

}
