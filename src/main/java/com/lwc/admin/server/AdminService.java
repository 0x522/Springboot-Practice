package com.lwc.admin.server;


import com.lwc.admin.bean.Admin;
import com.lwc.admin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public Admin getAdmin(Integer id){
        return  adminMapper.getAdmin(id);
    }
}
