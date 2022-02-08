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

    public Admin getAdmin(Integer id){
        return  adminMapper.getAdmin(id);
    }

    /**
     * 所有用户信息
     * @return
     */
    public List<Admin> allUser(){
        return adminMapper.allUser();
    }
}
