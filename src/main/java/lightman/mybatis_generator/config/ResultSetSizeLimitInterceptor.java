package lightman.mybatis_generator.config;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Collection;
import java.util.Properties;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/1/7 9:42
 */
@Intercepts(@Signature(type = ResultSetHandler.class,method = "handleResultSets",args = {Statement.class}))
public class ResultSetSizeLimitInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object result = invocation.proceed();
        int size = ((Collection<?>)result).size();
        System.out.println("size = "+size);
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
