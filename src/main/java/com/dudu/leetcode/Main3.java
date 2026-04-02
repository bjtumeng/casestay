package com.dudu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/11/28 12:26 下午
 */
public class Main3 {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        Demo3 demo1 =new Demo3();
        TreeNode root =new TreeNode(1);
        TreeNode node1 =new TreeNode(3);
        TreeNode node2 =new TreeNode(2);
        TreeNode node21 =new TreeNode(5);
        TreeNode node3 =new TreeNode(2);
        TreeNode node4 =new TreeNode(1);
        TreeNode node5 =new TreeNode(3);
        TreeNode node6 =new TreeNode(4);
        TreeNode node7 =new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node1.left=node21;

        node3.left=node4;
        node3.right=node5;

        node4.right=node6;
        node4.right=node7;
       demo1.mergeTrees(root,node4);
}
}

