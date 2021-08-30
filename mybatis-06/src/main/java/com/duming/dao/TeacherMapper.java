package com.duming.dao;

import com.duming.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("select  * from teacher where id = #{id}")
    Teacher getTeacherById(@Param("id") int id);
}
