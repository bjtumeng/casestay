package com.dudu.leetcode;

import java.util.Stack;

/**
 * @Description:
 * 回文链表
 * @author:zhaomeng
 * @date:2022/11/14 11:02 下午
 */
public class Demo13 {
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode root =head;
        int count =0;
        while(head !=null){
            head =head.next;
            count++;
        }
        if(count ==1){
            return true;
        }
        for (int i= count/2;i>0;i--){
            stack.push(root.val);
            root =root.next;
        }
        //放在循环外，只用跳过一次
        if (count%2 !=0){
            root =root.next;
        }
        while(!stack.isEmpty() ){
            if (stack.pop() != root.val){
                return false;
            }
            root =root.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(node));
    }
}

