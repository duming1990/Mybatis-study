package com.duming.dao;


import com.duming.entity.Student;
import com.duming.entity.Teacher;
import com.duming.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {


    @Test
    public void getStudent(){
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);
        List<Teacher> list =mapper.getTeacher(1);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }

        sqlsession.close();
    }
}
