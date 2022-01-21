package com.lwc.admin.controller;


import com.lwc.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {


    @GetMapping("/basic_table")
    public String basic_table() {


        return "table/basic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        List<User> userList = Arrays.asList(new User("zhangsan", "123"),
                new User("lise", "45678"),
                new User("wangwu", "85236"));
        model.addAttribute("User", userList);

        return "table/dynamic_table";
    }


    @GetMapping("/responsive_table")
    public String responsive_table() {


        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {


        return "table/editable_table";
    }

}
