package com.lwc.admin.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lwc.admin.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/toolcontroller")
public class ToolController {


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
}
