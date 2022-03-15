package com.lwc.admin.service;

import com.lwc.admin.bean.Admin;
import com.lwc.admin.mapper.AnnoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnoServce {
    @Autowired
    AnnoMapper annoMapper;


    public Admin getById(Integer id){
        return  annoMapper.getById(id);
    }
}
