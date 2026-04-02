package com.dudu.leetcode.two;

import com.dudu.leetcode.TreeNode;

/**
 * @Description:
 * 合并二叉树
 * @author:zhaomeng
 * @date:2022/11/19 10:11 下午
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null){
            root1 = root2;
             return root1;
        }
        if(root1 != null && root2 != null){
            root1.val += root2.val;
            //只有这样才能组成一棵树
            root1.left = mergeTrees(root1.left,root2.left);
            root1.right = mergeTrees(root1.right,root2.right);
        }
        return root1;
    }
}
