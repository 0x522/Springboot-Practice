package com.lwc.admin.server;


import com.lwc.admin.bean.Admin;
import com.lwc.admin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public Integer getAdmin(String username,String password){
        return  adminMapper.getAdmin(username,password);
    }

    /**
     * 所有用户信息
     * @return
     */
    public List<Admin> allUser(String keywords){
        return adminMapper.allUser(keywords);
    }
}
