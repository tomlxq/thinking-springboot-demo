package thinking.springboot.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/21
 */
@Configuration
@EnableConfigurationProperties(ExternalProperties.class)
public class ExternalConfig {
    @Value("${spring.application.name}")
    private String name;
    @Autowired
    private Environment env;
    @Autowired
    private ExternalProperties properties;

    @Bean
    public ApplicationRunner runner3(WebServerApplicationContext context) {
        return args -> {
            System.out.println("Env -> spring.application.name:" + env.getProperty("spring.application.name"));
            System.out.println("Value -> spring.application.name:" + name);
            System.out.println("ConfigurationProperties -> thinking.springboot.host:" + properties.getHost());
        };
    }
}
