import com.duming.dao.UserMapper;
import com.duming.entity.User;
import com.duming.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    @Test
    public void getUserById() throws IOException {

        //使用Mybatis第一步：获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建sqlSessionFactory(框架初始化) == new DefaultSqlSessionFactory(config)持有Configuration对象 Configuration属性是由xml解析配置文件得到
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //打开sqlsession
        SqlSession sqlsession =sqlSessionFactory.openSession(true);
//        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        //获取mapper接口对象（底层时动态代理）
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        //调用mapper接口对象的方法操作数据库

        List<User> list = mapper.getUserById(1);

        System.out.println(list);

//       int flag = mapper.updateUser(new User(2, "无敌", "181818"));
//        sqlsession.clearCache();//清理缓存
        System.out.println("========================");
        sqlsession.close();

//        SqlSession sqlsession2 = MyBatisUtils.getSqlsession();
//        UserMapper mapper2 = sqlsession2.getMapper(UserMapper.class);
//        System.out.println(mapper2.getUserById(1));
//        sqlsession2.close();
    }

}
