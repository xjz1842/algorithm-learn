package com.algorithms.leetcode.secondhundred;


public class leetcode_101_IsSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return process(root, root);
    }

    private static boolean process(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && process(p.left, q.right) && process(p.right, q.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.left.left = new TreeNode(6);
        treeNode.left.right.right = new TreeNode(7);

        System.out.println(isSymmetric(treeNode));
    }


}
