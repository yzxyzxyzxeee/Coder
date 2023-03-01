package com.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.model.User;

public class UserImp implements UserDao {

    private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/javaweb";
    private final String userName = "root";
    private final String password = "123456";
    @Override
    public int insertUser(User user) {
        int rowsAffected = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO user  VALUES (?, ?, ?, ?)");
            System.out.println(user.toString());
            System.out.println(user.getName());
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getSex());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowsAffected;
    }

    @Override
    public int deleteUser(int id) {
        int rowsAffected = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM user WHERE id=?");
            preparedStatement.setInt(1, id);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowsAffected;
    }

    @Override
    public int updateUser(User user) {
        int rowsAffected = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE user SET name=?, age=?, sex=? WHERE id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getSex());
            preparedStatement.setInt(4, user.getId());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowsAffected;
    }

    @Override
    public List<User> selectUserByName(String name) {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM user WHERE name=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("sex"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> selectUserByAge(int age) {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM user WHERE age=?");
            preparedStatement.setInt(1, age);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("sex"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> selectUserBySex(String sex) {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM user WHERE sex=?");
            preparedStatement.setString(1, sex);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("sex"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> selectUserById(int id) {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM user WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("sex"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(url, userName, password);
            String sql = "SELECT * FROM user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                User user = new User(id, name, age, sex);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return userList;
    }

}