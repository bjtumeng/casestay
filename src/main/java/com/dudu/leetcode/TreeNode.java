package com.dudu.leetcode;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/11/28 9:57 上午
 */
public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
}
