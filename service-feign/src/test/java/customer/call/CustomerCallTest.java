package customer.call;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.feign.ServiceFeignApplication;
import org.spring.cloud.feign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**Junit测试*/
@SpringBootTest(classes = {ServiceFeignApplication.class})
public class CustomerCallTest {
    
    private static Logger logger = LoggerFactory.getLogger(CustomerCallTest.class);
    
    @Autowired
    private ProductService productService;
    
    /*Junit测试使用http请求调用接口sayHi(...),通过@FeignClient*/
    @Test
    public void callHelloWord() {
        logger.info("junit测试-----{}", productService.sayHi("shashijie"));
    }
}
