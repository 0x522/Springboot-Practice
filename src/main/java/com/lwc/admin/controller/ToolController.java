package com.lwc.admin.controller;


import com.lwc.admin.bean.Admin;
import com.lwc.admin.bean.FunctionSelect;
import com.lwc.admin.bean.vo.PageEntity;
import com.lwc.admin.server.AdminService;
import com.lwc.admin.server.FunctionSelectService;
import com.lwc.admin.util.DateUnit;
import com.lwc.admin.util.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lwc.admin.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/toolcontroller")
public class ToolController {

    @Autowired
    FunctionSelectService functionSelectService;
    @Autowired
    AdminService adminService;

    /**
     * 转大写
     *
     * @param text
     * @return
     */
    @ResponseBody
    @RequestMapping("/letter")
    public String Letter(@RequestParam("text") String text) {
        String putText = text.toUpperCase();
        return putText;
    }

    /**
     * 转小写
     *
     * @param text
     * @return
     */
    @ResponseBody
    @RequestMapping("/letterlower")
    public String LetterLower(@RequestParam("text") String text) {
        String putText = text.toLowerCase();
        return putText;
    }

    /**
     * 首字母转大写
     *
     * @param text
     * @return
     */
    @ResponseBody
    @RequestMapping("/letterFirstlower")
    public String letterFirstLower(@RequestParam("text") String text) {
        String putText = text.substring(0, 1).toUpperCase() + text.substring(1, text.length()).toLowerCase();
        return putText;
    }

//    /**
//     * 获取下拉框选项
//     * @param function_id
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping("/mainSelect")
//    public List<String> mainSelect(@RequestParam("function_id") String function_id){
//        List<String> list=functionSelectService.muchSelected(function_id);
//        return list;
//    }

    /**
     * 获取用户信息
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/allUser")
    public PageEntity allUser(int page, int limit, String keywords) {
        Map map = new HashMap<>();
        map.put("keywords", keywords);
        return adminService.allUser(page, limit, map);
    }

    /**
     * 正则匹配
     *
     * @param intext
     * @param puttext
     * @return
     */
    @ResponseBody
    @RequestMapping("/regularCheck")
    public boolean regularCheck(String intext, String puttext) {
        return intext.matches(puttext);
    }

    /**
     * 快速添加内容
     *
     * @param intext
     * @return
     */
    @ResponseBody
    @RequestMapping("/fastAdd")
    public String fastAdd(String intext) {
        if (StringUtils.isEmptyOrNull(intext)) {
            return null;
        }
        if (intext.contains(",")) {
            String[] strings = intext.split(",");
            String replace = strings[strings.length - 1];
            for (int i = 0; i < strings.length - 1; i++) {
                ArrayList<Integer> arr = new ArrayList<>();
                ArrayList<Integer> arr1 = new ArrayList<>();
                for (int j = 0; j < strings[i].length(); j++) {
                    if (Character.isDigit(strings[i].charAt(j))) {
                        arr.add(j);
                    }
                    if ('[' == strings[i].charAt(j)) {
                        arr1.add(j);
                    }
                }
                strings[i] = strings[i].replace("[]", "[" + replace + strings[i].substring(arr.get(0), arr1.get(0)) + "]");
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strings.length - 1; i++) {
                stringBuilder.append(strings[i] + "\n");
            }
            return stringBuilder.toString();
        }
        return "请正确输入添加内容的格式";
    }

    /**
     * 通过日期相差天数返回日期
     *
     * @param intext
     * @return
     */
    @ResponseBody
    @RequestMapping("/wrDayByDate")
    public String wrDayByDate(String intext) {
        String putText = "";
        if (intext.contains(",")) {
            String[] strings = intext.split(",");
            if (strings.length == 2) {
                String date = strings[0];
                String day = strings[1];
                if (StringUtils.isNotEmpty(date) || StringUtils.isNotEmpty(day)) {
                    if (date.length() == 8 && !date.contains("-") && !date.contains("/")) {
                        date = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
                    }
                    try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1 = sdf.parse(date);
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(date1);
                    calendar1.add(Calendar.DATE, Integer.parseInt(day));
                    putText=sdf.format(calendar1.getTime());
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    putText = "日期或者天数不能为空";
                }

            } else {
                putText = "请正确填写格式";
            }

        }
        return putText;

    }

}
