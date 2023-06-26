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
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取验证码
        String checkCode = request.getParameter("checkCode");
        System.out.println(checkCode);
        //获取user对象
        BufferedReader br = request.getReader();
        String params = br.readLine();
        User user = JSON.parseObject(params, User.class);
        System.out.println(user);


        // 程序生成的验证码，从Session获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        System.out.println(checkCodeGen);
        // 比对
        boolean flag = checkCodeGen.equalsIgnoreCase(checkCode);
        System.out.println(flag);
        if (!flag) {
            response.getWriter().write("codeFail");
            // 不允许注册
            return;
        }

        // 3. 判断注册成功与否
        User u = service.selectByName(user.getUsername());
        if (u == null) {
            //2. 调用service 注册
            service.add(user);
            response.getWriter().write("success");
        } else {
            response.getWriter().write("usernameHad");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
