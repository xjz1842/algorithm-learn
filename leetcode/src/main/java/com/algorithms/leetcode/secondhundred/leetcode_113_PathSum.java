package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_113_PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        process(root, sum, new ArrayList<>(), result);
        return result;
    }

    private void process(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> result) {
        //叶子节点
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                temp.add(root.val);
                result.add(new ArrayList<>(temp));
            }
        }
        temp.add(root.val);
        if (root.left != null) {
            process(root.left, sum - root.val, new ArrayList<>(temp), result);
        }
        if (root.right != null) {
            process(root.right, sum - root.val, new ArrayList<>(temp), result);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

    }
}
