package com.dudu.leetcode;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/11/28 11:51 上午
 */
public class Demo3 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if (root1 ==null){
          return root2;
      }
      if (root2 == null){
          return root1;
      }
      TreeNode node = new TreeNode(root1.val+root2.val);
      node.left = mergeTrees(root1.left,root2.left);
      node.right = mergeTrees(root1.right,root2.right);
      return node;
    }
}
