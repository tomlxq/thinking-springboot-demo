import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.spring256.com.sample.ChineseNameRepository;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/22
 */
public class DerivedComponentAnnotationBootstrap {
    static {
        System.setProperty("java.version", "1.7.0");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("classpath*:/META-INF/spring/context.xml");
        context.refresh();
        ChineseNameRepository chineseNameRepository = (ChineseNameRepository) context.getBean("chineseNameRepository");
        System.out.println("chineseNameRepository:\n" + chineseNameRepository.findAll());
    }
}
