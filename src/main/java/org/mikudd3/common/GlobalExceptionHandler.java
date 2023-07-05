package org.mikudd3.common;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @project: 全局异常处理类
 * @author: mikudd3
 * @version: 1.0
 */
//拦截加了RestController注解的Controller进行异常处理
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 进行异常处理方法
     *
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException exception) {

        log.error(exception.getMessage());

        if (exception.getMessage().contains("Duplicate entry")) {
            String[] spilt = exception.getMessage().split(" ");
            String msg = spilt[2] + "已存在";
            return R.error(msg);
        }

        return R.error("未知错误");

    }

    /**
     * 进行自定义异常处理方法
     *
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException exception) {
        return R.error(exception.getMessage());
    }


}
