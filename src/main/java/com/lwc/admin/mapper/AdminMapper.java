package com.lwc.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwc.admin.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AdminMapper  extends BaseMapper<Admin> {

   public Admin getAdmin(Integer id);

   public List<Admin> allUser();

}
