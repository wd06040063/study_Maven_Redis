package com.wang.reflection;

import java.lang.reflect.Field;

/**
 * @author Wangdong
 * @date 2020/3/8 - 下午10:38
 * 使用反射方法对使用变量进行取值
 */
public class Test08 {
    private static Field declaredField;

    public static void main(String[] args) throws Exception{
        Class clazz = Student2.class;
        Student2 student2 = (Student2) clazz.newInstance();
        declaredField = clazz.getDeclaredField("name");
        declaredField.setAccessible(true);
        declaredField.set(student2, "Wang");
        student2.syso();
    }
}

class Student2{
    private String name;
    public void syso() {
        System.out.println(name);
    }
}