package thinking.springboot.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/21
 */
@RestController
public class HelloController {
    @RequestMapping
    public String hello() {
        return "hello";
    }
}
