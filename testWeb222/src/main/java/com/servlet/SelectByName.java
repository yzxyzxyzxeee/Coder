package com.servlet;

import com.imp.UserImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "selectByName", value = "/selectByName")
public class SelectByName extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取信息，前端页面注册的信息

        UserImp userImp = new UserImp();
        System.out.println(String.valueOf(request.getParameter("name")));
        request.setAttribute("factor", userImp.selectUserByName(String.valueOf(request.getParameter("name"))));
        request.getRequestDispatcher("/list2.jsp").forward(request, response);

    }
}

