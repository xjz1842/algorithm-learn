package com.algorithms.leetcode.secondhundred;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_173_BSTIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Queue<Integer> treeNodes = new LinkedList<>();

    public leetcode_173_BSTIterator(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            TreeNode predecessor = cur.left;
            if (predecessor != null) {
                while (predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                }
                //第一次到达最右节点
                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    treeNodes.add(cur.val);
                    predecessor.right = null;
                }
            } else {
                treeNodes.add(cur.val);
            }
            cur = cur.right;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return treeNodes.poll();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return treeNodes.size() > 0;
    }
}
