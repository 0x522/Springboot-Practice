package com.lwc.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwc.admin.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper  extends BaseMapper<Admin> {

   public Integer getAdmin(String username,String password);

   public List<Admin> allUser(Map param);

   public Integer allUserCount(Map param);

}
