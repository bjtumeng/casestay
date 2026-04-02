package com.dudu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/11/28 10:19 上午
 */
public class Main1 {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        Demo1 demo1 =new Demo1();
        TreeNode root =new TreeNode(8);
        TreeNode node1 =new TreeNode(6);
        TreeNode node2 =new TreeNode(10);
        TreeNode node3 =new TreeNode(5);
        TreeNode node4 =new TreeNode(7);
        TreeNode node5 =new TreeNode(9);
        TreeNode node6 =new TreeNode(11);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        TreeNode treeNode = demo1.invertTree(root);
        query(treeNode,list);
        list.forEach(item -> System.out.print(item+"|"));
    }
    public static List<Integer> query(TreeNode root,List<Integer> list){
        if (root !=null){
            list.add(root.val);
            query(root.left,list);
            query(root.right,list);
        }
        return list;
    }
}
