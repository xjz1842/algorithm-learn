package com.algorithms.leetcode.secondhundred;

public class leetcode_104_MaxDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null) {
            return 1 + maxDepth(root.left);
        }
        if (root.right != null) {
            return 1 + maxDepth(root.right);
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        System.out.println(maxDepth(treeNode));
    }
}
