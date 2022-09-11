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
/*是@controller和@ResponseBody 的结合
 * @Controller 将当前修饰的类注入SpringBoot IOC容器，使得从该类所在的项目跑起来的过程中，这个类就被实例化。
 * @ResponseBody 它的作用简短截说就是指该类中所有的API接口返回的数据，甭管你对应的方法返回Map或是其他Object，它会以Json字符串的形式返回给客户端*/
@RestController
public class ServiceHiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }
    
    /*子项目本身端口号(Eureka客户端)*/
    @Value("${server.port}")
    String port;
    
    /*接受请求,处理具体业务逻辑*/
    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "shashijie") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
