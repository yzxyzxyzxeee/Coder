package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
    List<User>selectUserByName(String name);
    List<User>selectUserByAge(int age);
    List<User>selectUserBySex(String sex);
    List<User> selectUserById(int id);
    List<User>selectAllUser();
}
