package com.lwc.admin.service;

import com.lwc.admin.bean.FunctionSelect;
import com.lwc.admin.mapper.FunctionSelectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionSelectService {

    @Autowired
    FunctionSelectMapper functionSelectMapper;

    public List<String>  muchSelected(String function_id){
        return functionSelectMapper.muchSelected(function_id);
    }

    public List<FunctionSelect> dataSelect(){
        return functionSelectMapper.dataSelect();
    }

}
