package com.algorithms.leetcode.secondhundred;

public class leetcode_111_MinDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(minDepth(root));
    }
}
