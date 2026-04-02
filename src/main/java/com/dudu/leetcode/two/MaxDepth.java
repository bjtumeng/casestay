package com.dudu.leetcode.two;

import com.dudu.leetcode.TreeNode;

/**
 * @Description:
 * 二叉树最大深度
 * @author:zhaomeng
 * @date:2022/11/19 5:36 下午
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left)+1;
        int right =  maxDepth(root.right)+1;
        return left >=right?left:right;
    }
}
