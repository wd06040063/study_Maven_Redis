package com.wang.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangdong
 * @date 2020/2/17 - 下午8:44
 */
public class Test01 extends Object{
    @Override
    public String toString() {
        return super.toString();
    }
    @Deprecated
    public static void test(){
        System.out.printf("Deprecated");
    }

    public void test02(){
        List list = new ArrayList();
    }

}
