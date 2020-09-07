package com.algorithms.leetcode.onehundred;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_95_GenerateTrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();

        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode head = new TreeNode(i);
                    head.left = leftNode;
                    head.right = rightNode;
                    ans.add(head);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);

        for (TreeNode treeNode : list) {
            for (String str : levelPrint(treeNode)) {
                System.out.printf("%s\t", str);
            }
            System.out.println();
        }
    }

    public static List<String> levelPrint(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<String> result = new ArrayList<>();
        if (head == null) {
            return new ArrayList<>();
        }
        queue.offer(head);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top == null) {
                result.add(null);
                continue;
            } else {
                result.add(String.valueOf(top.val));
            }
            if (top.left == null && top.right == null)
                continue;

            queue.offer(top.left != null ? top.left : null);
            queue.offer(top.right != null ? top.right : null);

        }
        if (result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result;
    }
}
