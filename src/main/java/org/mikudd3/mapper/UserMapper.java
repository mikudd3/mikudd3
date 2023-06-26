package org.mikudd3.mapper;

import org.apache.ibatis.annotations.*;
import org.mikudd3.entity.User;

import java.util.List;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public interface UserMapper {

    /**
     * 添加用户,用于注册
     *
     * @param user
     */
    @Insert("insert into user(username,pwd,phone,email) values(#{username},#{pwd},#{phone},#{email})")
    void add(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    @Delete("delete from user where id=#{id}")
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
    @Select("select * from user")
    List<User> selectAll();

    /**
     * 根据姓名查询用户
     *
     * @return
     */
    @Select("select * from user where username=#{username}")
    User selectByName(String username);

    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param pwd
     * @return
     */
    @Select("select * from user where username=#{username} and pwd=#{pwd}")
    User selectByNameAndPassword(@Param("username") String username, @Param("pwd") String pwd);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User selectById(Integer id);

    /**
     * 分页查询
     *
     * @param begin
     * @param size
     * @param
     * @return
     */
    List<User> selectByPage(@Param("begin") int begin, @Param("size") int size, @Param("username") String username);

    /**
     * 查询数量
     *
     * @return
     */
    int selectTotalCount();

}
