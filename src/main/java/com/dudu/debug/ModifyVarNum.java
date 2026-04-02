package com.dudu.debug;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/11/21 10:29 上午
 */
public class ModifyVarNum {
    public static void main(String[] args) {
        int num =10;
        int num2 = 11;
        int num3 = 0;
        if (num != 0 && num2 !=0 ){
            num3=num * num2;
        }

        System.out.println(num3);
    }
}
