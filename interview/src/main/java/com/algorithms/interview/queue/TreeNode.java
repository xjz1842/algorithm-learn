package com.algorithms.interview.queue;

// 二叉树结点的定义
public class TreeNode {

    // 树结点中的元素值
    int val = 0;
    // 二叉树结点的左子结点
    TreeNode left = null;
    // 二叉树结点的右子结点
    TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
