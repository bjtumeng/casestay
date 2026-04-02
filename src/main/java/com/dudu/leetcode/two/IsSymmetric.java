package com.dudu.leetcode.two;

import com.dudu.leetcode.TreeNode;

/**
 * @Description:
 * 对称二叉树
 * 使用迭代的方式
 * @author:zhaomeng
 * @date:2022/11/19 5:25 下午
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return method2(root.left,root.right);
    }
    public boolean method2(TreeNode left,TreeNode right) {
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
