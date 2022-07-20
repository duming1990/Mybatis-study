package com.duming.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory -->sqlSession
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory ;

    static {
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //new DefaultSqlSessionFactory(config)持有Configuration对象 Configuration属性是由xml解析配置文件得到
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //sqlSession包含了面向数据库执行sql的 命令所需的所有方法
    public static SqlSession getSqlsession(){
        return sqlSessionFactory.openSession(true);
    }
}
