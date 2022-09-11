package org.spring.cloud.parent.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/*在SpringCloud中当你需要使用Eureka注册中心的时候你在配置Eureka的客户端的时候需要在启动类上添加@EnableDiscoveryClient 或 @EnableEurekaClient注解
 * 仅仅@EnableEurekaClient是不够的，还需要在配置文件中注明自己的服务注册中心的地址，application.yml配置*/
@EnableEurekaClient
public class ServiceHiApplication {
    
    /*启动客户端,服务方法hi*/
    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }
    
}
