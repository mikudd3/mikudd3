package org.mikudd3.common;

/**
 * @project: 基于ThreadLocal封装的工具类，用户保存和获取当前登录id
 * @author: mikudd3
 * @version: 1.0
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

}
