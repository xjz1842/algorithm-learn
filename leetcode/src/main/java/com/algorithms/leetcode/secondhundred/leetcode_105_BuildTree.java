package com.algorithms.leetcode.secondhundred;

public class leetcode_105_BuildTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preLen = preorder.length;
        int inLen = preorder.length;
        if (preLen != inLen) {
            return null;
        }
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = inLeft;
        for (int j = 0; j < inorder.length; j++) {
            if (pivot == inorder[j]) {
                pivotIndex = j;
            }
        }
        root.left = buildTree(preorder, preLeft + 1, preLeft + pivotIndex - inLeft, inorder, inLeft, pivotIndex - 1);
        root.right = buildTree(preorder, preLeft + pivotIndex - inLeft + 1, preRight, inorder, pivotIndex + 1, inRight);
        return root;
    }

    public static void main(String[] args) {

    }
}
