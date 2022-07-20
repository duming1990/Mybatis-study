import com.duming.dao.UserMapper;
import com.duming.entity.User;
import com.duming.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void getUserById() {
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
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
