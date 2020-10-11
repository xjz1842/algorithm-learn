package com.algorithms.leetcode.onehundred;

public class leetcode_99_RecoverTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode x = null;
        TreeNode y = null;
        //记录中序遍历当前节点的前驱
        TreeNode pre = null;
        //用来完成Morris连接的寻找前驱的指针
        TreeNode predecessor = null;

        while (root != null) {
            //左子树不为空，1、链接root节点的前驱，它的前驱还没访问
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                //说明了1已经执行过了，我们执行2
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else if (predecessor.right == root) {
                    // 说明了1已经执行过了，我们执行2
                    if (pre != null && pre.val > root.val) {
                        y = root;
                        if (x == null) {
                            x = pre;
                        }
                    }
                    //更新前驱,为下一个节点做准备
                    pre = root;
                    //断开前驱连接
                    predecessor.right = null;
                    //访问root右子树
                    root = root.right;
                }
            } else { // root.left == null root不需要链接节点的前驱（他的前驱其实就是pre(第一个节点pre为null)，且已经被访问过了），那么直接访问root
                if (pre != null && pre.val > root.val) {
                    y = root;
                    if (x == null) {
                        x = pre;
                    }
                }
                //更新前驱,为下一个节点做准备
                pre = root;
                //访问root的右子树
                root = root.right;
            }
        }
        if (x != null && y != null) {
            int t = x.val;
            x.val = y.val;
            y.val = t;
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(2);

        recoverTree(treeNode);
    }
}
