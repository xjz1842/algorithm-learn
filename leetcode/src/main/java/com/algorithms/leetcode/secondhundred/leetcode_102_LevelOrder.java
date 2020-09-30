package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_102_LevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> ans = new LinkedList<>();
        ans.add(root);
        Queue<TreeNode> temp = new LinkedList<>();
        List<Integer> tempList = new ArrayList<>();
        while (!ans.isEmpty()) {
            TreeNode treeNode = ans.poll();
            tempList.add(treeNode.val);
            if (treeNode.left != null) {
                temp.add(treeNode.left);
            }
            if (treeNode.right != null) {
                temp.add(treeNode.right);
            }
            if (ans.isEmpty()) {
                result.add(tempList);
                ans.addAll(temp);
                tempList.clear();
                temp.clear();
            }
        }
        return result;
    }
}
