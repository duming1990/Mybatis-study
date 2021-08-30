package com.duming.dao;

import com.duming.entity.User;
import com.duming.utils.MyBatisUtils;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {
    Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
        //关闭sqlsession
        sqlsession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info:进入log4j");
        logger.debug("debug:进入log4j");
        logger.error("error:进入log4j");
    }

    @Test
    public void testLimit(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userList=mapper.getUserByLimit(map);
        for (User user : userList) {
            logger.info(user);
        }
        sqlsession.close();
    }

    @Test
    public void  getUserByRowBounds(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();

        //rowbounds实现
        RowBounds rowBounds = new RowBounds(1,2);


        //通过java代码层面实现分页
        List<User>userList=sqlsession.selectList("com.duming.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : userList) {
            logger.info(user);
        }
        sqlsession.close();
    }
}
