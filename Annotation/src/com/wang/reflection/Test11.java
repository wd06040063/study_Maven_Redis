package com.wang.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author Wangdong
 * @date 2020/3/10 - 下午1:45
 * 通过反射获得注解
 */
public class Test11 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.wang.reflection.Student01");
        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解value值
        Tablewang tabblewang = (Tablewang) c1.getAnnotation(Tablewang.class);
        String value = tabblewang.value();
        System.out.println(value);

        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        Fieldwang annotation = f.getAnnotation(Fieldwang.class);
        System.out.println(annotation.columName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}
@Tablewang("db_student")
    class Student01{
    @Fieldwang(columName = "db_name",type = "int",length = 10)
        private String name;
        @Fieldwang(columName = "db_age",type = "int",length = 10)
        private int age;
        @Fieldwang(columName = "db_id",type = "int",length = 10)
        private int id;

        public Student01() {
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Student01(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }


        @Override
        public String toString() {
            return "Student01{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }


}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablewang{
    String value();
}
//属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldwang{
    String columName();
    String type();
    int length();
}
