package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_107_LevelOrderBottom {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
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
                result.addFirst(new ArrayList<>(tempList));
                ans.addAll(temp);
                tempList.clear();
                temp.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
