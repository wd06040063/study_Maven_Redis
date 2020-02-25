package com.wang.annotation;

import java.lang.annotation.*;

/**
 * @author Wangdong
 * @date 2020/2/17 - 下午8:55
 */
@MyAnnotation()
public class Test02 {

}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface MyAnnotation{
    String name() default "";
    int age() default 0;
    int id() default 1;
    String[] school() default {"沈阳师范大学"};

}
