package com.wang.reflection;

/**
 * @author Wangdong
 * @date 2020/2/25 - 下午8:54
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是"+person.name);
        //方式一：通过对象获得
        Class c1 = person.getClass();
        System.out.println("hash值为："+c1.hashCode());
        //方式二：通过forname获得
        Class c2 = Class.forName("com.wang.reflection.Student");
        System.out.println("hash值为："+c2.hashCode());
        Person person1 = new Teacher();
        System.out.println("这个人是"+person1.name);
    }
}
     class Person{
        String name;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public Person() {

        }

        public Person(String name) {
            this.name = name;
        }
    }
    class Student extends Person{
        public Student(){
            this.name = "学生";
        }

    }
    class Teacher extends Person{
        public Teacher(){
            this.name = "教师";
        }
    }

