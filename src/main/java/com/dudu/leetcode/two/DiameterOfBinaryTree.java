package com.dudu.leetcode.two;

import com.dudu.leetcode.TreeNode;

/**
 * @Description:
 * 二叉树直径
 * 不是直接按根结点的左右子树相加计算
 * 因为可能不是根结点，但是左子树+右子树大于根结点的左右子树
 * 例如非根结点，左4右4
 * 根结点 左5右1
 * @author:zhaomeng
 * @date:2022/11/19 11:16 下午
 */
public class DiameterOfBinaryTree {
    int depth =0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        method4(root);
        return depth;
    }
    public int method4(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = method4(root.left)+1;
        int right = method4(root.right)+1;
        //记录下所有节点最大的直径
        depth = Math.max(depth,left+right-2);
        return left>right?left:right;
    }
}
