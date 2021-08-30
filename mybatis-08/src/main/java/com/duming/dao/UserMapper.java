package com.duming.dao;

import com.duming.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> getUserById(@Param("id") int id);

    int updateUser(User user);
}
