package thinking.spring256.com.sample;

import thinking.spring256.com.annotation.StringRepository;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/22
 */
@StringRepository
public class ChineseNameRepository {
    public List<String> findAll() {
        return Arrays.asList("张飞", "刘备", "关云长");
    }
}
