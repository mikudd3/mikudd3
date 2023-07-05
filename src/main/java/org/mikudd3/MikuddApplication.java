package org.mikudd3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */


@SpringBootApplication //springboot启动
@Slf4j //日志
@ServletComponentScan //扫描过滤器
@EnableTransactionManagement//开启事务
public class MikuddApplication {

    public static void main(String[] args) {
        //启动springboot
        SpringApplication.run(MikuddApplication.class, args);
        log.info("项目启动");
    }
}
