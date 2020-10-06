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


    public static class Info {
        public int maxPathSum;
        public int maxPathSumFromHead;

        public Info(int path, int head) {
            maxPathSum = path;
            maxPathSumFromHead = head;
        }
    }

    public static int maxPathSum1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process1(root).maxPathSum;
    }

    public static Info process1(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process1(x.left);
        Info rightInfo = process1(x.right);
        int p1 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p1 = leftInfo.maxPathSum;
        }
        int p2 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p2 = rightInfo.maxPathSum;
        }
        int p3 = x.val;
        int p4 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p4 = x.val + leftInfo.maxPathSumFromHead;
        }
        int p5 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p5 = x.val + rightInfo.maxPathSumFromHead;
        }
        int p6 = Integer.MIN_VALUE;
        if (leftInfo != null && rightInfo != null) {
            p6 = x.val + leftInfo.maxPathSumFromHead + rightInfo.maxPathSumFromHead;
        }
        int maxSum = Math.max(Math.max(Math.max(p1, p2), Math.max(p3, p4)), Math.max(p5, p6));
        int maxSumFromHead = Math.max(p3, Math.max(p4, p5));

        return new Info(maxSum, maxSumFromHead);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        maxPathSum(root);
        System.out.println(maxSum);
    }
}


