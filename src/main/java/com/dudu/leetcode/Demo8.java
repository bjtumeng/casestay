package com.dudu.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description:
 * 有效的括号
 * @author:zhaomeng
 * @date:2022/11/13 8:02 下午
 */
public class Demo8 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> maps = new HashMap<>();
        maps.put('{','}');
        maps.put('(',')');
        maps.put('[',']');
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == '{' ||
                s.charAt(i) == '[' ||
                s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                if (stack.empty() == false){
                    if (maps.get(stack.pop()) != s.charAt(i)){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
       if (stack.empty() ==true){
           return true;
       }else{
           return false;
       }
    }
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
}
