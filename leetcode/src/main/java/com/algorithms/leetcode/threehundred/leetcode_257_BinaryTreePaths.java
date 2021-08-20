package com.algorithms.leetcode.threehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_257_BinaryTreePaths {

    public static class TreeNode {
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

    //DFS 层次遍历
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        List<String> tmp = new ArrayList<>();

        dfs(root, tmp, ans);
        return ans;
    }

    private static void dfs(TreeNode root, List<String> tmp, List<String> ans) {
        //叶子节点
        if (root.left == null && root.right == null) {
            tmp.add(String.valueOf(root.val));
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                if (i == tmp.size() - 1) {
                    builder.append(tmp.get(i));
                } else {
                    builder.append(tmp.get(i)).append("->");
                }
            }
            ans.add(builder.toString());
            return;
        }
        tmp.add(String.valueOf(root.val));
        tmp = new ArrayList<>(tmp);
        if (root.left != null) {
            dfs(root.left, tmp, ans);
            tmp.remove(tmp.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, tmp, ans);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(binaryTreePaths(root));
    }
}
