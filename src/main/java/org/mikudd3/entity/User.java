package org.mikudd3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //用户id
    private Integer id;
    //用户名
    private String username;
    //密码
    private String pwd;
    //是否为管理员，1是管理员，0是买家
    private Integer isAdmin;
    //电话号码
    private String phone;
    //邮箱
    private String email;
    //头像地址
    private String url;
    //账号状态
    private Integer status;

}
