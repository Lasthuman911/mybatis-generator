package lightman.mybatis_generator.config;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

/**
 * 自定义拦截器，控制查询的最大量
 *
 * @author Administrator
 * @date 2021/1/6 21:46
 */
@Intercepts(
        @Signature(method = "prepare",
                type = StatementHandler.class,
                args = {Connection.class, Integer.class})
)
public class QueryInterceptor implements Interceptor {
    private static final String DEFAULT_MAX_ROWS = "10";
    private int maxRows = 10;

    /**
     * 拦截时执行的操作
     *
     * @param invocation { 代理对象，被监控方法对象，当前被监控方法运行时需要的实参 }
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("被拦截方法执行前的操作。。。");
        Statement proceed = (Statement) invocation.proceed();
        System.out.println("maxRows："+maxRows);
        if (maxRows > 0) {
            proceed.setMaxRows(maxRows);
        }
        System.out.println("被拦截方法执行后的操作。。。");
        return proceed;
    }

    /**
     * 拦截器用于封装目标对象的
     * 通过该方法我们可以返回目标对象本身，也可以返回一个它的代理
     *
     * @param o
     * @return
     */
    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    /**
     * 用于在 Mybatis 配置文件中指定一些属性的。
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        if (properties == null) {
            properties = new Properties();
        }
        maxRows = Integer.valueOf(properties.getProperty("maxRows", DEFAULT_MAX_ROWS));
    }

    public int getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }
}