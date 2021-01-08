package lightman.mybatis_generator.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * mybatis配置文件，为了注入自定义的拦截器
 *
 * @author Administrator
 * @date 2021/1/6 21:53
 */
@Configuration
public class MybatisConfig {
    QueryInterceptor queryInterceptor = new QueryInterceptor();
    ResultSetSizeLimitInterceptor resultSetSizeLimitInterceptor = new ResultSetSizeLimitInterceptor();
    @Value("${mybatis.maxRows:10}")
    String maxRows;

    @Bean
    public String myInterceptor(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addInterceptor(queryInterceptor);
        Properties properties = new Properties();
        properties.setProperty("maxRows", maxRows);
        queryInterceptor.setProperties(properties);
        return "interceptor";
    }

    @Bean
    public String myLimitInterceptor(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addInterceptor(resultSetSizeLimitInterceptor);
        return "limitInterceptor";
    }
}
