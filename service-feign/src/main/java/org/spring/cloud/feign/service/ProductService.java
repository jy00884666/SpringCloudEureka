package org.spring.cloud.feign.service;

import org.spring.cloud.feign.error.ProductServiceError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*为了让Controller应用到,其实不加也可以,只是为了编译通过*/
@Service
/**定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务。
 * 熔断器宕机回调,@FeignClient注解中加上fallback的指定类就行了*/
@FeignClient(value = "${spring.application.customer-service-hi}", fallback = ProductServiceError.class)
public interface ProductService {
    
    /*调用service-hi服务的hi接口来消费服务*/
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name);
    
}
