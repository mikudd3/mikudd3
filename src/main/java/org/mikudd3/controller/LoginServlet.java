package org.mikudd3.controller;

import com.alibaba.fastjson2.JSON;
import org.mikudd3.entity.User;
import org.mikudd3.service.UserService;
import org.mikudd3.service.serviceimpl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        User user = service.selectByNameAndPassword(username, password);
        if (user == null) {
//            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
            response.getWriter().write("0");
        } else {
            if (user.getIsAdmin() == 1) {
                response.getWriter().write("1");
//                request.getRequestDispatcher("/pages/admin/userlist.html").forward(request, response);
            } else {
                response.getWriter().write("2");
//                request.getRequestDispatcher("/pages/index.html").forward(request, response);
            }
        }

//        //获取请求体数据
//        BufferedReader br = request.getReader();
//        String params = br.readLine();
//        //将json数据转为Java对象
//        User user = JSON.parseObject(params, User.class);
//        System.out.println(user);
//        //调用service查询
//        User u = service.selectByNameAndPassword(user.getUsername(), user.getPassword());
//        System.out.println(u);
//        if (u != null) {
//            System.out.println(111);
//            //判断是否为管理员
//            if (user.getIsAdmin() == 1) {
//                //登录成功，跳转到info界面
//
//            } else {
//
//            }
//        } else {
//
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
