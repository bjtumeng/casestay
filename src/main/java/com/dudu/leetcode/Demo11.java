package com.dudu.leetcode;

/**
 * @Description:
 * 反转链表
 * @author:zhaomeng
 * @date:2022/11/13 10:12 下午
 */
public class Demo11 {
    public ListNode reverseList(ListNode head) {
      ListNode pre =null;
      ListNode next=head;
      while(head != null){
          //保留next
         next = head.next;
         //反转链表
         head.next =pre;
         //移位
         pre =head;
         head =next;
      }
      return pre;
    }
}
