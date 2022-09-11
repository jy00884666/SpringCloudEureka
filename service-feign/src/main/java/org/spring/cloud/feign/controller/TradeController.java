package org.spring.cloud.feign.controller;

import org.spring.cloud.feign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 是@controller和@ResponseBody 的结合
 * @Controller 将当前修饰的类注入SpringBoot IOC容器，使得从该类所在的项目跑起来的过程中，这个类就被实例化。
 * @ResponseBody 它的作用简短截说就是指该类中所有的API接口返回的数据，甭管你对应的方法返回Map或是其他Object，它会以Json字符串的形式返回给客户端
 */
@RestController
public class TradeController {
    
    /*编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。*/
    @Autowired
    private ProductService productService;
    
    /*对外暴露接口,来消费服务*/
    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return productService.sayHi(name);
    }
}
