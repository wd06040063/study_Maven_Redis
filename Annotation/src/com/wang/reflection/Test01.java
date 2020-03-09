package com.wang.reflection;

/**
 * @author Wangdong
 * @date 2020/2/18 - 下午10:32
 */

public class Test01 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.wang.reflection.User");
        System.out.println(c1);
        Class c2 = Class.forName("com.wang.reflection.User");

    }
}
//entity
class User{
    private int id;
    private String name ;
    private int age;
    public User(){

    }
    public User(String name,int id,int age){
        this.age=age;
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
