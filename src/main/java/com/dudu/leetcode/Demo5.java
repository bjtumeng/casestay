package com.dudu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 * @author:zhaomeng
 * @date:2021/11/29 9:00 下午
 */
public class Demo5 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val ==0 ||l2.val == 0){
            return new ListNode(0);
        }
        ListNode pre = new ListNode(0);
        ListNode head =pre;
        int flag =0;
        while(l1 !=null  || l2 !=null){
            //如果l1或者l2为null，则置为0
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum =value1+value2+flag;
            if (sum>9){
                flag=1;
            }
            ListNode node = new ListNode(sum%10);
            head.next =node;
            head =head.next;
            if (l1 !=null){
                l1 =l1.next;
            }
            if (l2 !=null){
                l2 =l2.next;
            }
            if (flag ==1){
                head.next=new ListNode(1);
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 =  new ListNode(2);
        ListNode node2 =  new ListNode(4);
        ListNode node3 =  new ListNode(3);
        ListNode node4 =  new ListNode(5);
        ListNode node5 =  new ListNode(6);
        ListNode node6 =  new ListNode(4);
        ListNode node7 =  new ListNode(8);
        node1.next=node2;
        node2.next=node3;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        addTwoNumbers(node1,node4);
    }
}
