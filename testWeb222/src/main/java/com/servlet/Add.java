package com.servlet;

import com.imp.UserImp;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "add", value = "/add")
public class Add extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取信息，前端页面注册的信息

        UserImp userImp = new UserImp();
        User user = new User(Integer.valueOf(request.getParameter("id")), request.getParameter("name"),
                Integer.valueOf(request.getParameter("age")), request.getParameter("sex"));

        userImp.insertUser(user);
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }
}

