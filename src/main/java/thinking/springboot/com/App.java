package thinking.springboot.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@RestController
@SpringBootApplication
public class App {
    @RequestMapping
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
