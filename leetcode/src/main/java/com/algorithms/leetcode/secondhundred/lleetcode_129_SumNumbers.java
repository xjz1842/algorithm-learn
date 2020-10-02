package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.List;

public class lleetcode_129_SumNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        process(root, 0, result);
        int sum = 0;
        for (Integer i : result) {
            sum += i;
        }
        return sum;
    }

    private static void process(TreeNode root, Integer ans, List<Integer> result) {
        //到了根节点
        if (root.left == null && root.right == null) {
            ans = ans * 10 + root.val;
            result.add(ans);
            return;
        }
        ans = ans * 10 + root.val;
        if (root.left != null) {
            process(root.left, ans, result);
        }
        if (root.right != null) {
            process(root.right, ans, result);
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        System.out.println(sumNumbers(treeNode));
    }
}
