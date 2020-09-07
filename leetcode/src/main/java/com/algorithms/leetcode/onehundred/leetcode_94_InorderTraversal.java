package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_94_InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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

    public static List<Integer> inorderTraversalIterator(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        root.right = new TreeNode(3);
        root.left = new TreeNode(1);

        for (Integer i : inorderTraversalIterator(root)) {
            System.out.println(i);
        }
    }
}
