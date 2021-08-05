package com.algorithms.leetcode.threehundred;

import sun.reflect.generics.tree.Tree;

public class leetcode_236_LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null && right == null){
            return null;
        }
        if(left == null && right != null){
            return right;
        }
        if(left != null && right == null){
            return left;
        }
        //分再两侧
        return root;
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(lowestCommonAncestor(root,new TreeNode(1),new TreeNode(1)));
    }

}
