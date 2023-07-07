package org.mikudd3.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.mikudd3.common.BaseContext;
import org.mikudd3.common.R;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @project: 检查用户是否已经完成登录
 * 过滤器名字：loginCheckFilter
 * 拦截：/*  拦截全部
 * <p>
 * 实现filter接口
 * @author: mikudd3
 * @version: 1.0
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取本次请求的URL
        String url = request.getRequestURI();
        System.out.println(url);

        //定义放行数组
        String[] uris = new String[]{
//                "/employee/login",
                "/backend/**",
        };

        //2.判断本次请求是否需要处理
        boolean check = check(uris, url);

        System.out.println(check);
        //3.如果不需要处理
        if (check) {
            log.info("本次请求不需要处理");
            //放行
            filterChain.doFilter(request, response);
            return;
        }

        //4.判断用户登录状态，
        if (request.getSession().getAttribute("employee") != null) {
            log.info("用户已登录");
            //获取修改人id
            Long empId = (Long) request.getSession().getAttribute("employee");
            //设置当前线程的id
            BaseContext.setCurrentId(empId);

            //用户已登录，则放行
            filterChain.doFilter(request, response);
            return;
        }
        //移动端用户
        if (request.getSession().getAttribute("user") != null) {
            log.info("用户已登录");
            //获取移动端用户id
            Long userId = (Long) request.getSession().getAttribute("user");
            //设置当前线程的id
            BaseContext.setCurrentId(userId);

            //用户已登录，则放行
            filterChain.doFilter(request, response);
            return;
        }

        log.info("用户未登录");
        //5.用户未登录则返回登录结果,通过输出流返回结果
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));

    }

    /**
     * 判断不需要处理的资源
     *
     * @param uris
     * @param requestUrI
     * @return
     */
    private boolean check(String[] uris, String requestUrI) {
        //遍历数组
        for (String url : uris) {
            boolean match = PATH_MATCHER.match(url, requestUrI);
            if (match) {
                return match;
            }
            return true;
        }
        return false;
    }
}
