package lightman.mybatis_generator.dao;

import lightman.mybatis_generator.Test;
import lightman.mybatis_generator.TestExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {
    long countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);
}