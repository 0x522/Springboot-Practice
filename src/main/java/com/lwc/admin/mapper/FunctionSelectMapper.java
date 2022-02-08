package com.lwc.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwc.admin.bean.Admin;
import com.lwc.admin.bean.FunctionSelect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FunctionSelectMapper extends BaseMapper<FunctionSelect> {

   public List<String> muchSelected(String function_id);

   public List<FunctionSelect> dataSelect();
}
