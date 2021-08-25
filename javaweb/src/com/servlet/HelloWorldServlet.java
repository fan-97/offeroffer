package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        request.setAttribute("name", "request 张三");
        request.getSession().setAttribute("name", "session 张三");
        if ("1".equals(method))
            response.sendRedirect("index.jsp");
        else
            request.getRequestDispatcher("hello.jsp").forward(request,response);
    }
}
