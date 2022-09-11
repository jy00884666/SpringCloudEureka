package org.spring.cloud.parent.servicehi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.parent.servicehi.service.HelloWordService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*是@controller和@ResponseBody 的结合
 * @Controller 将当前修饰的类注入SpringBoot IOC容器，使得从该类所在的项目跑起来的过程中，这个类就被实例化。
 * @ResponseBody 它的作用简短截说就是指该类中所有的API接口返回的数据，甭管你对应的方法返回Map或是其他Object，它会以Json字符串的形式返回给客户端*/
@RestController
public class HelloWordServiceImpl implements HelloWordService {
    
    private static Logger logger = LoggerFactory.getLogger(HelloWordServiceImpl.class);
    
    /*子项目本身端口号(Eureka客户端)*/
    @Value("${server.port}")
    String port;
    
    @Override
    /*接受请求,处理具体业务逻辑*/
    @RequestMapping("/hi")
    public String helloWord(@RequestParam(value = "name", defaultValue = "shashijie") String name) {
        String hello = "Hello Word!!!";
        if (false) {
            throw new NullPointerException(hello + "没事玩玩!!!");
        }
        return "hi " + name + " ,i am from port:" + port;
    }
}
