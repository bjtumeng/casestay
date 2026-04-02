package com.dudu.leetcode;

/**
 * @Description:
 * 环形链表
 * @author:zhaomeng
 * @date:2022/11/13 10:33 下午
 */
public class Demo12 {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
         ListNode quick = head;
         while(head !=null && quick!=null && quick.next !=null){
             head =head.next;
             quick =quick.next.next;
             if (head == quick){
                 return true;
             }
         }
         return false;
    }

    public static void main(String[] args) {
        //[-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5]
        ListNode node1 =new ListNode(-21);
        ListNode node31 =new ListNode(10);
        ListNode node2 =new ListNode(17);
        ListNode node3 =new ListNode(8);
        ListNode node4 =new ListNode(4);
        ListNode node5 =new ListNode(26);
        ListNode node6 =new ListNode(5);
        ListNode node11 =new ListNode(35);
        ListNode node12 =new ListNode(33);
        ListNode node13 =new ListNode(-7);
        ListNode node14 =new ListNode(-16);
        ListNode node15 =new ListNode(27);
        ListNode node16 =new ListNode(-12);
        ListNode node17 =new ListNode(6);
        ListNode node23 =new ListNode(29);
        ListNode node18 =new ListNode(-12);
        ListNode node19 =new ListNode(5);
        ListNode node21 =new ListNode(9);
        ListNode node22 =new ListNode(20);
        ListNode node24 =new ListNode(14);
        ListNode node25 =new ListNode(14);
        node1.next=node31;
        node31.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node11;
        node11.next=node12;
        ListNode node26 =new ListNode(2);
        ListNode node27 =new ListNode(13);
        ListNode node28 =new ListNode(-24);
        ListNode node29 =new ListNode(21);
        ListNode node30 =new ListNode(23);
        ListNode node32 =new ListNode(-21);
        ListNode node33 =new ListNode(5);


        System.out.println(hasCycle(node1));

    }
}
