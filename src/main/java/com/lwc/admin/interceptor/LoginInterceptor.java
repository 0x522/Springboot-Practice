package com.lwc.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* 登录检查
* 1.配置好拦截器要拦截那些请求
* 2.把这些配置放在容器中
* */

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法完成之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String requestURI = request.getRequestURI();
//        log.info("拦截到的请求是{}",requestURI);
        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null){
            //如果有数据，则登陆成功，放行
            return true;
        }
        //如果为空，则登录失败，拦截,一般会跳转到登录页面，并显示错误信息
        request.setAttribute("msg","请先登录");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    /*目标方法完成以后*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle请求的是{}",modelAndView);
    }

    /*页面渲染之后*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//      log.info("afterCompletion请求的是{}",ex);
    }
}
