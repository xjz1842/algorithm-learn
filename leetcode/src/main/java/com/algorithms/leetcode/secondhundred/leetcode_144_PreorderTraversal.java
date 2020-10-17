package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_144_PreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Morris序
    public static List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;

        List<Integer> result = new ArrayList<>();
        while (cur != null) {
            TreeNode predecessor = cur.left;
            if (predecessor != null) {
                while (predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                }
                //第一次到达最右节点
                if (predecessor.right == null) {
                    predecessor.right = cur;
                    result.add(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    predecessor.right = null;
                }
            } else {
                result.add(cur.val);
            }
            cur = cur.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(7);
        preorderTraversal(head);
    }

}
