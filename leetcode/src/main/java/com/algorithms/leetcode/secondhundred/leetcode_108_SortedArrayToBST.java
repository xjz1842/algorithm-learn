package com.algorithms.leetcode.secondhundred;

public class leetcode_108_SortedArrayToBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public TreeNode process(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        //头节点
        int mid = l + (r - l) / 2;

        TreeNode head = new TreeNode(nums[mid]);
        head.left = process(nums, l, mid - 1);
        head.right = process(nums, mid + 1, r);

        return head;
    }
}
