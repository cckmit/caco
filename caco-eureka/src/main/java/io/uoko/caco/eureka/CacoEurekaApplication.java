package io.uoko.caco.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CacoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacoEurekaApplication.class, args);
    }

}
