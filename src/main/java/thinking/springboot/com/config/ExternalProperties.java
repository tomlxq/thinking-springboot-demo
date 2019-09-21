package thinking.springboot.com.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/21
 */
@ConfigurationProperties(prefix = "thinking.springboot")
@Setter
@Getter
public class ExternalProperties {
    private String host = "localhost";
}
