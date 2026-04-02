package com.dudu.leetcode.two;

import com.dudu.leetcode.TreeNode;

/**
 * @Description:
 * 翻转二叉树
 * 因为要返回原来的节点，所以不能重写一个方法
 * @author:zhaomeng
 * @date:2022/11/19 8:11 下午
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode temp =root.left;
        root.left =root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return new TreeNode();
        }
        //只是节点更换，下面的元素没有更换
        method3(root.left,root.right);
        return root;
    }
    public void method3(TreeNode left,TreeNode right) {
        if(left == null && right == null){
            return ;
        }
        if(left == null){
            left = right;
            right = null;
        }
        if(right == null){
            right = left;
            left = null;
        }
        TreeNode temp =left;
        left =right;
        right = temp;
        method3(left.left,right.right);
        method3(left.right,right.left);
    }
}
