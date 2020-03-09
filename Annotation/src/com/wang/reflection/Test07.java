package com.wang.reflection;

/**
 * @author Wangdong
 * @date 2020/3/8 - 下午10:15
 */
public class Test07 {
    public static void main(String[] args) {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取系统类加载器的父类加载器-->拓展加载器
        ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(parent);
        //获取拓展类加载器的父类加载器-->根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        System.out.println(System.getProperty("java.class.path"));
        //双亲委派机制
        //java.lang.String-->
    }
}
