package com.dudu.leetcode;

/**
 * @Description:
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @author:zhaomeng
 * @date:2021/11/28 9:26 上午
 */
public class Demo1 {

    public TreeNode invertTree(TreeNode root) {
         if (root != null){
             TreeNode temp =root.left;
             root.left = root.right;
             root.right = temp;
             invertTree(root.left);
             invertTree(root.right);
         }
         return root;
    }
}
