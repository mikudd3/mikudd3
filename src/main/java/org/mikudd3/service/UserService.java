package org.mikudd3.service;

import org.mikudd3.entity.PageBean;
import org.mikudd3.entity.Employee;

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
     * @param employee
     */
    void add(Employee employee);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    void deleteById(Integer id);


    /**
     * 修改
     *
     * @param employee
     */
    void update(Employee employee);

    /**
     * 查询所有
     *
     * @return
     */
    List<Employee> selectAll();

    /**
     * 根据姓名查询用户
     *
     * @return
     */
    Employee selectByName(String username);


    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    Employee selectByNameAndPassword(String username, String password);


    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    Employee selectById(Integer id);

    /**
     * 分页查询
     *
     * @param begin
     * @param size
     * @param
     * @return
     */
    PageBean<Employee> selectByPage(int begin, int size, String username);

}
