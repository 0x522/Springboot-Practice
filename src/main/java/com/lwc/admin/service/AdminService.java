package com.lwc.admin.service;


import com.lwc.admin.bean.vo.PageEntity;
import com.lwc.admin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    /**
     * 验证用户信息
     * @param username
     * @param password
     * @return
     */
    public Integer getAdmin(String username,String password){
        return  adminMapper.getAdmin(username,password);
    }

    /**
     * 所有用户信息
     * @return
     */
    public PageEntity allUser(int page, int limit, Map param){
        param.put("limit",limit);
        param.put("offset",(page - 1) * limit);
        return new PageEntity(adminMapper.allUser(param),adminMapper.allUserCount(param));
    }
}
