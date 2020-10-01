package com.algorithms.leetcode.secondhundred;


/**
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 */
public class leetcode_106_BuildTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            return null;
        }
        return buildTree(inorder, 0, inLen - 1, postorder, 0, postLen - 1);
    }

    public static TreeNode buildTree(int[] inorder, int inLeft, int inRight,
                                     int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);

        int pivotIndex = inRight;
        for (int i = inRight; i >= inLeft; i--) {
            if (inorder[i] == postorder[postRight]) {
                pivotIndex = i;
                break;
            }
        }
        root.left = buildTree(inorder, inLeft, pivotIndex - 1, postorder, postLeft, postLeft + pivotIndex - inLeft - 1);
        root.right = buildTree(inorder, pivotIndex + 1, inRight, postorder, postLeft + pivotIndex - inLeft, postRight - 1);
        return root;
    }
}
