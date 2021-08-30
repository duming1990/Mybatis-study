package com.duming.dao;

import com.duming.entity.User;
import com.duming.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlsession = null;
        try {
            //第一步获取sqlsession对象
            sqlsession = MyBatisUtils.getSqlsession();

            //执行sql
            //方式一：getMapper
            UserDao userDao = sqlsession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();

            //方式二：不推荐使用，知道即可
//        List<User> userList = sqlsession.selectList("com.duming.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlsession
            sqlsession.close();
        }
    }

    @Test
    public void  test2(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        mapper.getUserById(1);
        System.out.println(mapper.getUserById(1));
        //关闭sqlsession
        sqlsession.close();
    }
    @Test
    public void  getUserLike(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        List<User> userList =mapper.getUserLike("明");

        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlsession
        sqlsession.close();
    }

    //增删改需要提交事务
    @Test
    public void  addUser(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        int flag = mapper.addUser(new User(4, "灭世", "343434"));
        System.out.println(flag);

        //提交事务
        sqlsession.commit();

        //关闭sqlsession
        sqlsession.close();
    }
    @Test
    public void  addUser2(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);

        Map<String,String> user=new HashMap<String, String>();
        user.put("userId", "5");
        user.put("userName", "刀塔");
        user.put("userPwd", "666666");
        int flag = mapper.addUser2(user);
        System.out.println(flag);

        //提交事务
        sqlsession.commit();

        //关闭sqlsession
        sqlsession.close();
    }
}
