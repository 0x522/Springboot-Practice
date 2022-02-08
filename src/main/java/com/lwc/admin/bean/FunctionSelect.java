package com.lwc.admin.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FunctionSelect {

    //内容id
    private Integer id;
    //下拉框内容
    private String function_name;
    //下拉框id
    private String function_id;

}
