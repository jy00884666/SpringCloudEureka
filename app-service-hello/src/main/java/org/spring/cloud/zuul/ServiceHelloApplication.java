package org.spring.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
/**
 * 在SpringCloud中当你需要使用Eureka注册中心的时候你在配置Eureka的客户端的时候需要在启动类上添加
 * @EnableDiscoveryClient 或 @EnableEurekaClient注解, 都可以将Eureka Client注册到Eureka Server（注册中心）中
 * 区别
 * 1.@EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix
 * 2.@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient不仅适用于注册中心是Eureka Server 还使用于以其它组件（例如Zookeeper）作为注册中心的情况
 */
@EnableEurekaClient
@EnableDiscoveryClient
/*注解开启Feign的功能*/
@EnableFeignClients
public class ServiceHelloApplication {
    
    /*启动Feign,来消费服务*/
    public static void main(String[] args) {
        SpringApplication.run(ServiceHelloApplication.class, args);
    }
    
}
