package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_98_IsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = inorderTraversal(root);

        int len = list.size();
        for (int i = 0; i < len - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        process(root, result);
        return result;
    }

    public static void process(TreeNode head, List<Integer> ans) {
        if (head == null) {
            return;
        }
        process(head.left, ans);
        ans.add(head.val);
        process(head.right, ans);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        System.out.println(isValidBST(p));
    }
}
