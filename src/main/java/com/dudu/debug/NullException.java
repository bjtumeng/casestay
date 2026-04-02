package com.dudu.debug;

import java.util.ArrayList;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/11/21 11:12 上午
 */
public class NullException {
    public static void main(String[] args) {
        method1(null);
    }

    public static void method1(Integer integer){
        int i = integer + 1;
        System.out.println(i);
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.get(0).toString());
    }
}
