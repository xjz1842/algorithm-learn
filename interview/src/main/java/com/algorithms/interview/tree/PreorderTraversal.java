package com.algorithms.interview.tree;

import java.util.*;

public class PreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        // 用来进行递归的栈
        Stack<TreeNode> s = new Stack<>();
        // 用来存放遍历的结果，不算在空间复杂度里面
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }
        s.push(root);
        // 开始利用栈来进行遍历
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            ans.add(node.val);

            if (node.left != null) {
                s.push(node.left);
            }
            if (node.right != null) {
                s.push(node.right);
            }
        }
        return ans;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            return new ArrayList<>();
        }

        TreeNode cur = root;
        // 用来存放遍历的结果，不算在空间复杂度里面
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right; //right
            }
        }
        return ans;
    }

    /**
     *  post order
     */
    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == prev) {
                ans.add(stack.pop().val);
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(postorderTraversal(root));
    }
}
