package com.algorithms.leetcode.secondhundred;

import javax.crypto.MacSpi;

public class leetcode_124_MaxPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            maxSum = root.val;
            return maxSum;
        }
        process(root);
        return maxSum;
    }

    private static int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGrain = Math.max(process(root.left), 0);
        int rightGrain = Math.max(process(root.right), 0);

        maxSum = Math.max(maxSum, leftGrain + rightGrain + root.val);
        return Math.max(leftGrain, rightGrain) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        maxPathSum(root);
        System.out.println(maxSum);
    }
}


