package org.spring.cloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务。*/
@FeignClient(value = "${spring.application.customer-service-hi}")
public interface ProductService {
    
    /*调用service-hi服务的hi接口来消费服务*/
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name);
    
}
