package com.dudu.leetcode.two;

import com.dudu.leetcode.ListNode;
import com.dudu.leetcode.TreeNode;

/**
 * @Description:
 * 合并有序列表
 * @author:zhaomeng
 * @date:2022/11/19 4:07 下午
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode node = mergeTwoLists(list1, list2);
        while(node !=null){
            System.out.print(node.val+"|");
            node =node.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode head = root;
        //都不为null时，进入判断
        while(list1 !=null && list2 != null){
            if(list1.val > list2.val){
                root.next = list2;
                root = root.next;
                list2 = list2.next;
            }else{
                root.next = list1;
                root = root.next;
                list1 = list1.next;
            }
        }
        //应该是当前位置的下一位等于未合并的当前位置
        if(list1 != null){
            root.next = list1;
        }
        if(list2 != null){
            root.next = list2;
        }
        return head.next;
    }
    public boolean method2(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if((left == null || right == null)){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return method2(left.left,right.right) && method2(left.right,right.left);
    }
}
