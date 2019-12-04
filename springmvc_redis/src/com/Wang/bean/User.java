package com.Wang.bean;

/**
 * @author Wangdong
 * @date 2019/12/4 - 下午7:53
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;

    public static String getKeyName(){
        return "user:";
    }
}
