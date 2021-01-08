package lightman.mybatis_generator;

import lightman.mybatis_generator.dao.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisGeneratorApplicationTests {

    @Resource
    private TestMapper testMapper;

    /*    @Resource
        private TestExample testExample;*/
    @Test
    public void contextLoads() {
    }

    /**
     * 插入数据的用法
     */
    @Test
    public void insertTest() {
        lightman.mybatis_generator.Test record = new lightman.mybatis_generator.Test();
        record.setName("wzm2");
        record.setValue("123");
        testMapper.insert(record);
    }

    /**
     * 查询的用法
     */
    @Test
    public void selectTest() {
        TestExample testExample = new TestExample();
        testExample.createCriteria().andNameEqualTo("wzm4");
        List<lightman.mybatis_generator.Test> testList = testMapper.selectByExample(testExample);
        System.out.println(testList.get(0));
    }

    @Test
    public void selectTest2() {
        TestExample testExample = new TestExample();
        testExample.createCriteria().andNameEqualTo("wzm2").andValueEqualTo("123");
        List<lightman.mybatis_generator.Test> testList = testMapper.selectByExample(testExample);
        System.out.println(testList.get(0));
    }

    @Test
    public void delTest() {
        TestExample example = new TestExample();
        example.createCriteria().andNameEqualTo("wzm3");
        testMapper.deleteByExample(example);
    }

    /**
     * update：record是要更新成什么样的数据，example：符合此条件的数据将被更新
     */
    @Test
    public void updateTest() {
        lightman.mybatis_generator.Test record = new lightman.mybatis_generator.Test();
        record.setName("wzm3");
        TestExample example = new TestExample();
        example.createCriteria().andNameEqualTo("wzm2").andValueEqualTo("123");
        testMapper.updateByExample(record, example);
    }

    @Test
    public void updateTest2() {
        lightman.mybatis_generator.Test record = new lightman.mybatis_generator.Test();
        record.setValue("4567");
        TestExample example = new TestExample();
        example.createCriteria().andNameEqualTo("wzm4");
        testMapper.updateByExampleSelective(record, example);
    }

}
