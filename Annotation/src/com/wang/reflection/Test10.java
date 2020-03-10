package com.wang.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Wangdong
 * @date 2020/3/10 - 下午1:10
 */
public class Test10 {
    public static void test01(){
        User user = new User();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法执行10亿次所用时间："+(endTime-startTime)+"ms");

    }
    // 反射方式调用所需要时间
    public static void test02() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        Class c1 = user.getClass();
       // Method getName = c1.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            c1.getDeclaredMethod("getName",null).invoke(user,null);
            //getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方法执行10亿次所用时间："+(endTime-startTime)+"ms");

    }
    // 反射方式调用所需要时间，关闭安全检测状态
    public static void test03() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方法关闭检测执行10亿次所用时间："+(endTime-startTime)+"ms");

    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        test01();
        test02();
        test03();
    }
}
