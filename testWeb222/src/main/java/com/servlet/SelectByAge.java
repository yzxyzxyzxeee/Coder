package com.servlet;

import com.imp.UserImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "selectByAge", value = "/selectByAge")
public class SelectByAge extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //��ȡ��Ϣ��ǰ��ҳ��ע�����Ϣ

        UserImp userImp = new UserImp();
        request.setAttribute("factor", userImp.selectUserByAge(Integer.parseInt(request.getParameter("age"))));
        request.getRequestDispatcher("/list2.jsp").forward(request, response);

    }
}

