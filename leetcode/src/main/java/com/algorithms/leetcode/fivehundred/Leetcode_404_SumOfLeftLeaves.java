package com.algorithms.leetcode.fivehundred;



public class Leetcode_404_SumOfLeftLeaves {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
         if(root == null){
             return 0;
         }
         if(root.left != null) {
             sum += root.left.val;
            sumOfLeftLeaves(root.left);
        }
        if(root.right != null) {
            sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }
}
