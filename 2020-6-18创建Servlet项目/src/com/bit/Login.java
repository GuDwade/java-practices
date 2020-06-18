package com.bit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //设置http响应的Content-Type Header
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter writer=resp.getWriter();

        if (username!=null&&username.equals("gufucheng")
                &&password!=null&&password.equals("123456")){
            writer.println("登陆成功");
            System.out.println("登陆成功");
        }else{
            writer.println("登陆失败");
            System.out.println("登陆失败");
        }
    }
}
