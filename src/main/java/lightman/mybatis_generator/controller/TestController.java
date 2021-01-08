package lightman.mybatis_generator.controller;

import lightman.mybatis_generator.Test;
import lightman.mybatis_generator.TestExample;
import lightman.mybatis_generator.config.QueryInterceptor;
import lightman.mybatis_generator.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;

/**
 * @Description ${todo}
 * @Author Administrator
 * @Date 2018/8/11 0011上午 10:45
 */
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("/insert")
    public int insertUser() {
        Test record = new Test();
        record.setValue("123");
        record.setName("wzm");
        return testMapper.insert(record);
    }

    @RequestMapping("/select")
    public String selcet() {
        TestExample example = new TestExample();
        example.createCriteria().andNameEqualTo("wzm4");
        List<Test> testList = testMapper.selectByExample(example);
        return testList.get(0).getName();
    }
    @RequestMapping("/selectAll")
    public  List<Test> selectAll() {
        TestExample example = new TestExample();
//        example.createCriteria().andNameEqualTo("wzm4");
        List<Test> testList = testMapper.selectByExample(example);
        return testList;
    }

}
