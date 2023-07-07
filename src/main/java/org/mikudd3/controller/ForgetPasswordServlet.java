package org.mikudd3.controller;

import org.mikudd3.entity.Employee;
import org.mikudd3.service.UserService;
import org.mikudd3.service.serviceimpl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/forgetPassword")
public class ForgetPasswordServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取输入参数
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
        //获取验证码
        String checkCode = request.getParameter("checkCode");
        // 程序生成的验证码，从Session获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        System.out.println(checkCodeGen);
        // 比对
        boolean flag = checkCodeGen.equalsIgnoreCase(checkCode);
        System.out.println(flag);
        if (!flag) {
            response.getWriter().write("checkError");
            // 不允许注册
            return;
        }

        //根据用户名获取用户
        Employee employee = service.selectByName(username);
        System.out.println(employee);

        //判断用户是否为空
        if (employee == null) {
            System.out.println(111);
            //返回找不到用户信息
            response.getWriter().write("userNotFound");
        } else {
            System.out.println(2222);
            //更新用户信息
            //更新用户的密码
//            employee.setPwd(password);
            //在数据库中更新数据
            service.update(employee);
            System.out.println(121212);
            response.getWriter().write("success");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
