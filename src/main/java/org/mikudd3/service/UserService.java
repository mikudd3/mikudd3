package org.mikudd3.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mikudd3.entity.PageBean;
import org.mikudd3.entity.User;

import java.util.List;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public interface UserService {
    /**
     * 添加用户,用于注册
     *
     * @param user
     */
    void add(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    void deleteById(Integer id);


    /**
     * 修改
     *
     * @param user
     */
    void update(User user);

    /**
     * 查询所有
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 根据姓名查询用户
     *
     * @return
     */
    User selectByName(String username);


    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    User selectByNameAndPassword(String username, String password);


    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 分页查询
     *
     * @param begin
     * @param size
     * @param
     * @return
     */
    PageBean<User> selectByPage(int begin, int size, String username);

}
