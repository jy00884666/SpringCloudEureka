package org.spring.cloud.feign.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.feign.service.ProductService;
import org.springframework.stereotype.Service;

@Service
/*熔断器,服务端宕机调用*/
public class ProductServiceError implements ProductService {
    
    private static Logger logger = LoggerFactory.getLogger(ProductServiceError.class);
    
    @Override
    public String sayHi(String name) {
        logger.info("调用service-hi服务的hi方法宕机");
        return "service-hi服务的hi方法宕机";
    }
}
