package org.mikudd3.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @project: 员工
 * @author: mikudd3
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    //员工id
    private Integer id;
    //用户名
    private String username;
    private String name;
    //密码
    private String password;
    //是否为管理员，1是管理员，0是买家
    private Integer isAdmin;
    //账号状态
    private Integer status;
    @TableField(fill = FieldFill.INSERT)//插入时填充
    //注册时间
    private LocalDateTime createTime;

}
