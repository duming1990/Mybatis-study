package com.duming.dao;

import com.duming.entity.User;
import com.mysql.jdbc.log.Log;
import jdk.nashorn.internal.runtime.logging.Logger;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(int id);

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

    //分页2
    List<User> getUserByRowBounds();


}
