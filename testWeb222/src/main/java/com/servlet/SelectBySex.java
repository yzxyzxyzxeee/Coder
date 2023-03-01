package com.servlet;

import com.imp.UserImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "selectBySex", value = "/selectBySex")
public class SelectBySex extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取信息，前端页面注册的信息

        UserImp userImp = new UserImp();
        request.setAttribute("factor", userImp.selectUserBySex(String.valueOf(request.getParameter("sex"))));
        request.getRequestDispatcher("/list2.jsp").forward(request, response);

    }
}

