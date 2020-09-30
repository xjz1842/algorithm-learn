package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_103_ZigzagLevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> zigzagLevelOrde(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> ans = new LinkedList<>();
        ans.add(root);
        LinkedList<TreeNode> temp = new LinkedList<>();
        List<Integer> tempList = new ArrayList<>();
        int level = 1;
        while (!ans.isEmpty()) {
            TreeNode treeNode = ans.poll();
            tempList.add(treeNode.val);
            if ((level & 1) == 1) {
                if (treeNode.left != null) {
                    temp.addFirst(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.addFirst(treeNode.right);
                }
            } else {
                if (treeNode.right != null) {
                    temp.addFirst(treeNode.right);
                }
                if (treeNode.left != null) {
                    temp.addFirst(treeNode.left);
                }
            }
            if (ans.isEmpty()) {
                result.add(new ArrayList<>(tempList));
                ans.addAll(temp);
                tempList.clear();
                temp.clear();
                level++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.left.left = new TreeNode(6);
        treeNode.left.right.right = new TreeNode(7);

        for (List<Integer> node : zigzagLevelOrde(treeNode)) {
            System.out.println(node);
        }
    }
}


