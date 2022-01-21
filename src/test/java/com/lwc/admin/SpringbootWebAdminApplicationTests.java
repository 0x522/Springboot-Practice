package com.lwc.admin;

import com.lwc.admin.bean.Admin;
import com.lwc.admin.bean.City;
import com.lwc.admin.mapper.AdminMapper;
import com.lwc.admin.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Slf4j
@SpringBootTest
class SpringbootWebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Autowired
    CityMapper cityMapper;


    @Test
    void contextLoads() {
       jdbcTemplate.update("delete  from user where id=1");


    }
    @Test
    public void findbuyid(){
        City city = cityMapper.selectById(1);
       log.info("输出的数据是{}",city);

    }

}
