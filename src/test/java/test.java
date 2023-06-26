import org.junit.Test;
import org.mikudd3.entity.PageBean;
import org.mikudd3.entity.User;
import org.mikudd3.service.UserService;
import org.mikudd3.service.serviceimpl.UserServiceImpl;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class test {


    private UserService userService = new UserServiceImpl();

    //添加用户
    @Test
    public void testAdd() {
        User user = new User();
        //添加方法
        user.setUsername("zhaoliu");
        user.setPwd("123456");
        user.setPhone("13312345678");
        user.setEmail("133123456@qq.com");
        userService.add(user);

    }

    //修改用户信息
    @Test
    public void testUpdate() {
        User user = new User();
        //添加方法
        user.setId(24);
        user.setPwd("123494");
        user.setUsername("zhj");
        System.out.println(user);
        userService.update(user);
    }

    //根据id删除用户
    @Test
    public void testDeleteById() {
        userService.deleteById(22);
    }


    //根据ID查询用户
    @Test
    public void testSelectById() {
        User user = userService.selectById(3);
        System.out.println(user);
    }


    //根据用户名和密码查询用户
    @Test
    public void testSelectByNameAndPassword() {
        User user = userService.selectByNameAndPassword("mikudd3", "123456");
        System.out.println(user);
    }

    //查询全部数据
    @Test
    public void testSelectAll() {
        List<User> users = userService.selectAll();
        System.out.println(users);
    }


    //根据用户名查询用户
    @Test
    public void testSelectByName() {
        User user = userService.selectByName("mikudd3");

        System.out.println(user);
    }

    @Test
    public void testSelectByPage() {
        User user = new User();
        user.setUsername("zhj");
        PageBean<User> userPageBean = userService.selectByPage(1, 5, user.getUsername());
        System.out.println(userPageBean.toString());
    }
}
