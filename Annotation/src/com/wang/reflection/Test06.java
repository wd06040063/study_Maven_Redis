package com.wang.reflection;

/**
 * @author Wangdong
 * @date 2020/3/5 - 下午1:03
 */
public class Test06 {
    static{
        System.out.println("main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //1 主动引用
        //Son son = new Son();
        // 反射加载
       // Class.forName("com.wang.reflection.Son");
     //   System.out.println(Son.b);
        Son[] array = new Son[5];
    }
}
class Father{
    static int b = 2;
    static{
        System.out.println("父类被加载");
    }

}
class Son extends Father{
    static {
        System.out.println("子类被加载");
        m=3;
    }
    static int m =100;
    static final int M=1;
}
