package com.wang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Wangdong
 * @date 2020/3/9 - 下午10:36
 */
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        //获得class对象
        Class c1 = Class.forName("com.wang.reflection.User");
        //构造方法
        User user =(User)c1.newInstance();
        System.out.println(user);
        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class,int.class,int.class);
        User user2 = (User) constructor.newInstance("王东", 001, 20);
        System.out.println(user2);
    }
}
