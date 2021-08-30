package com.duming.dao;

import com.duming.entity.User;
import com.duming.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlsession
        sqlsession.close();
    }

}
