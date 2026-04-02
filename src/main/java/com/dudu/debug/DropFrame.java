package com.dudu.debug;

import java.util.HashMap;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/11/21 10:12 上午
 */
public class DropFrame {
    public static void main(String[] args) {
        HashMap<String,String> maps= new HashMap<>();
        maps.put("1","2");
        maps.put("2","3");
        dropFrameDebug(maps);
    }
    public static void dropFrameDebug(HashMap<String,String> maps){
        int i = 99;
        maps.put("3","4");
        method1(i);
    }

    private static void method1(int i) {
        System.out.println("method1:"+i);
        method2(i);
    }

    private static void method2(int i) {
        i++;
        System.out.println("method2:"+i);
    }

}
