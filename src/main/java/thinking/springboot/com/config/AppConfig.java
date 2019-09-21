package thinking.springboot.com.config;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * 配置类
 *
 * @author TomLuo
 * @date 2019/9/21
 */
//@SpringBootApplication(scanBasePackages = "thinking.springboot.com.controller")
//@EnableAutoConfiguration
@Configuration
@ImportAutoConfiguration(ExternalConfig.class)
@ComponentScan(basePackages = "thinking.springboot.com.controller")
public class AppConfig {
    @EventListener(WebServerInitializedEvent.class)
    public void onReady(WebServerInitializedEvent event) {
        System.out.println("当前web server的实现类为：" + event.getWebServer().getClass().getName());
    }

    /**
     * ApplicationRunner 在spring boot启动后会回调
     *
     * @param context
     * @return
     */
    @Bean
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return args -> {
            System.out.println("当前web server的实现类为：" + context.getWebServer().getClass().getName());
        };
    }

    @Bean
    public ApplicationRunner runner2(BeanFactory beanFactory) {
        return args -> {
            System.out.println("当前helloWorld的实现类为：" + beanFactory.getBean("helloWorld").getClass().getName());
            System.out.println("当前web configuration的实现类为：" + beanFactory.getBean(AppConfig.class).getClass().getName());
        };
    }

    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("/hello"), request -> ok().body(Mono.just("hello, webflux!"), String.class));
    }
}
