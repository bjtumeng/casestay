package com.dudu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/11/28 11:18 上午
 */
public class Main2 {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        Demo2 demo1 =new Demo2();
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
        System.out.println(demo1.depth(root));
    }
}
