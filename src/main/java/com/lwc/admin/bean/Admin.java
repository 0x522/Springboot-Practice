package com.lwc.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
