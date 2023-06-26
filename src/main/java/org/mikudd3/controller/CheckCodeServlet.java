package org.mikudd3.controller;

import org.mikudd3.service.UserService;
import org.mikudd3.service.serviceimpl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final char[] CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        // 随机数生成器
        final Random random = new Random();

        // 图片宽度
        final int WIDTH = 100;

        // 图片高度
        final int HEIGHT = 50;

        // 验证码字符个数
        final int LENGTH = 4;



        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 在内存中创建图像
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文
        Graphics2D g2 = image.createGraphics();

        // 设置背景色
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        // 生成随机验证码
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            char c = CHARS[random.nextInt(CHARS.length)];
            code.append(c);
        }

        // 种子信息保存到 Session 中，用于后续验证
        request.getSession().setAttribute("checkCodeGen", code.toString());

        // 绘制验证码
        g2.setFont(new Font("宋体", Font.BOLD, 34));
        for (int i = 0; i < LENGTH; i++) {
            g2.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g2.drawString(String.valueOf(code.charAt(i)), (i + 1) * 20, 30);
        }

        // 释放图形上下文
        g2.dispose();

        try {
            // 将图片输出到输出流
            ServletOutputStream outputStream = response.getOutputStream();
            javax.imageio.ImageIO.write(image, "JPEG", outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
