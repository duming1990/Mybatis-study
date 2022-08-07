package com.duming.interceptor;

import com.duming.constant.DataSourceType;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts(value = {
        @Signature(
                type = Executor.class,//要拦截哪个接口
                method = "update",//要拦截哪个方法
                args = {MappedStatement.class,Object.class} //被拦截方法的参数
                ),
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}
        )
})
public class ReadWritePlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement)args[0];

        //数据源类型
        DataSourceType dataSourceType=null;
        //类型为读
        if(ms.getSqlCommandType().equals(SqlCommandType.SELECT)){
            //！selectKey为自增id查询主键（SELECT LAST_INSERT_ID（））方法    使用主库
            if(ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)){
                dataSourceType=DataSourceType.WRITE;
            }else {
                dataSourceType=DataSourceType.READ;
            }
        }else{
            //类型为增删改
            dataSourceType=DataSourceType.WRITE;
        }
        //修改当前线程要选择的数据源的key
//        DataSourceHolder.setDataSourceType(dataSourceType);

        //最终调用被拦截的方法
        return invocation.proceed();
    }
}
