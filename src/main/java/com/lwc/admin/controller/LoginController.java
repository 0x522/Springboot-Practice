package com.lwc.admin.controller;


import com.lwc.admin.bean.User;
import com.lwc.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AdminService adminService;

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if ((!StringUtils.isEmpty(user.getUserName())) && StringUtils.hasLength(user.getPassword())) {
            Integer cnt = adminService.getAdmin(user.getUserName(), user.getPassword());
            if (cnt > 0) {
                session.setAttribute("loginUser", user);
                return "redirect:/main.html";//登录成功就去首页
            } else {
                model.addAttribute("msg", "账号或者密码错误");
            }
        } else {
            model.addAttribute("msg", "账号或者密码不能为空");
        }
        return "login";
    }

    //避免表单重复提交
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        log.info("当前方式是{}", "mainPage");
        Object loginUser = session.getAttribute("loginUser");
        if (StringUtils.isEmpty(loginUser)) {
            model.addAttribute("msg", "请重新登录");
            return "login";
        }
        return "main";
    }

}
