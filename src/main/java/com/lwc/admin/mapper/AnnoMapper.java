package com.lwc.admin.mapper;

import com.lwc.admin.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface AnnoMapper {



    @Select("select * from user where id =#{id}")
    public Admin getById(Integer id);
}
