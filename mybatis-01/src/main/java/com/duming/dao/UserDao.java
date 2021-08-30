package com.duming.dao;

import com.duming.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserList();

    User getUserById(int id);

    List<User> getUserLike(String name);

    int addUser(User user);
    //万能map
    int addUser2(Map<String,String> user);
}
