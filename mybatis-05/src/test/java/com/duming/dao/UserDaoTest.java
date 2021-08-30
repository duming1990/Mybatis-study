package com.duming.dao;

import com.duming.entity.User;
import com.duming.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;


public class UserDaoTest {

    @Test
    public void  getUser(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        //底层主要应用反射
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUser();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlsession.close();
    }
    @Test
    public void  getUserById(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        //底层主要应用反射
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlsession.close();
    }
    @Test
    public void  insertUser(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        //底层主要应用反射
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int flag= mapper.insertUser(new User(7, "小怪兽", "888888"));
        System.out.println(flag);
        sqlsession.close();
    }
}
