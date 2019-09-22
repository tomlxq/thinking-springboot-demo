package thinking.in.spring.sample;

import thinking.in.spring.annotation.StringRepository;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/22
 */
@StringRepository(value = "chineseNameRepos")
public class ChineseNameRepository {
    public List<String> findAll() {
        return Arrays.asList("张飞", "刘备", "关云长");
    }
}
