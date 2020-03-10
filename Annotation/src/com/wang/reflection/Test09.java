package com.wang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Wangdong
 * @date 2020/3/9 - 下午10:36
 */
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        //获得class对象
        Class c1 = Class.forName("com.wang.reflection.User");
        //构造一个对象
        User user =(User)c1.newInstance(); //原为Object类，但是我们知道原方法是User，强制转换为User，且只能原调用无参构造器
        System.out.println(user);
        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class,int.class,int.class); //调用有参构造器
        User user2 = (User) constructor.newInstance("王东", 1, 20);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke 激活，
        //（对象，"方法的值"）
        setName.invoke(user3,"王东");
        System.out.println(user3.getName());

        System.out.println("==========================");
        //通过反射操作属性
        //常见面试题：privite方法不使用get方法如何取值并修改
        //使用方法:关键：setAccessible安全检测关闭
        User user4 = (User) c1.newInstance();  //强制类型转换为User，通过反射实例化User 测试第4个用户
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要关闭安全检测，setAccessible(true)为关闭
        name.setAccessible(true);
        name.set(user4,"王东2"); //此时可进行修改
        System.out.println(user4.getName());


    }
}
