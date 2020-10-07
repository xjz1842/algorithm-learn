package com.algorithms.leetcode.secondhundred;

public class leetcode_129_SumNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int sum = 0;

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root, 0);
        return sum;
    }

    public static void process(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        //根节点
        if (root.left == null && root.right == null) {
            sum += num * 10 + root.val;
            ;
        }
        num = num * 10 + root.val;
        if (root.left != null) {
            process(root.left, num);
        }
        if (root.right != null) {
            process(root.right, num);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);


        System.out.println(sumNumbers(treeNode));
    }
}
