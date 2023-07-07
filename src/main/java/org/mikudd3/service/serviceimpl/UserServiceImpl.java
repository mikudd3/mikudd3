package org.mikudd3.service.serviceimpl;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mikudd3.entity.Employee;
import org.mikudd3.entity.PageBean;
import org.mikudd3.jdbc.SqlSessionFactoryUtils;
import org.mikudd3.mapper.UserMapper;
import org.mikudd3.service.UserService;

import java.util.List;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public void add(Employee employee) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        userMapper.add(employee);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    @Override
    public void deleteById(Integer id) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        userMapper.deleteById(id);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    @Override
    public void update(Employee employee) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        userMapper.update(employee);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    @Override
    public List<Employee> selectAll() {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        List<Employee> employees = userMapper.selectAll();
        //关闭资源
        sqlSession.close();

        return employees;
    }

    @Override
    public Employee selectByName(String username) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        Employee employee = userMapper.selectByName(username);
        //关闭资源
        sqlSession.close();

        return employee;
    }

    @Override
    public Employee selectByNameAndPassword(String username, String password) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        Employee employee = userMapper.selectByNameAndPassword(username, password);
        //关闭资源
        sqlSession.close();

        return employee;
    }

    @Override
    public Employee selectById(Integer id) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        Employee employee = userMapper.selectById(id);
        //关闭资源
        sqlSession.close();

        return employee;
    }

    @Override
    public PageBean<Employee> selectByPage(int currPage, int pageSize, String username) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //计算开始索引
        int begin = (currPage - 1) * pageSize;
        int size = pageSize;

        //查询当前页数据
        List<Employee> rows = userMapper.selectByPage(begin, size, username);
        //查询数量
        int count = userMapper.selectTotalCount();

        //组合为pageBean
        PageBean<Employee> userPageBean = new PageBean<>(count, rows);
        //关闭资源
        sqlSession.close();
        return userPageBean;
    }


}
