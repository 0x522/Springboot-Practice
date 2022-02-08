package com.lwc.admin.controller;


import com.lwc.admin.bean.Admin;
import com.lwc.admin.bean.FunctionSelect;
import com.lwc.admin.server.AdminService;
import com.lwc.admin.server.FunctionSelectService;
import com.lwc.admin.util.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lwc.admin.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/toolcontroller")
public class ToolController {

    @Autowired
    FunctionSelectService functionSelectService;
    @Autowired
    AdminService adminService;

    /**
     * 转大写
     * @param text
     * @return
     */
    @ResponseBody
    @RequestMapping("/letter")
    public String Letter(@RequestParam("text") String text){
            String putText = text.toUpperCase();
            return putText;
    }

    /**
     * 转小写
     * @param text
     * @return
     */
    @ResponseBody
    @RequestMapping("/letterlower")
    public String LetterLower(@RequestParam("text") String text){
        String putText=text.toLowerCase();
        return putText;
    }

    /**
     * 首字母转大写
     * @param text
     * @return
     */
    @ResponseBody
    @RequestMapping("/letterFirstlower")
    public String letterFirstLower(@RequestParam("text") String text){
        String putText=text.substring(0,1).toUpperCase()+text.substring(1,text.length()).toLowerCase();
        return putText;
    }

    /**
     * 获取下拉框选项
     * @param function_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/mainSelect")
    public List<String> mainSelect(@RequestParam("function_id") String function_id){
        List<String> list=functionSelectService.muchSelected(function_id);
        return list;
    }

    /**
     * 获取用户信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/allUser")
    public R allUser(){
        List<Admin> list=adminService.allUser();
        return  R.ok(adminService.allUser());
    }
}
