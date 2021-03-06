package com.lwc.admin.controller;


import com.lwc.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
@Slf4j
@Controller
public class FormTestController {


    @GetMapping("/form_layouts")
    public String  form_layouts(){
        return "form/form_layouts";
    }

    @GetMapping("/data_table")
    public String data_table(HttpSession session){
        //获取用户信息，判断用户是否可以访问该页面
        User user=(User) session.getAttribute("loginUser");
        String username=user.getUserName();
        if("admin".equals(username)) {
            return "form/data_table";
        }
        return "error/ultra_vires.html";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={}，username={}，headerImg={}，photos={}",
                email,username,headerImg.getSize(),photos.length);
        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("F:\\cache\\"+originalFilename));
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("F:\\cache\\"+originalFilename));
                }
            }
        }
        return "main";
    }
}
