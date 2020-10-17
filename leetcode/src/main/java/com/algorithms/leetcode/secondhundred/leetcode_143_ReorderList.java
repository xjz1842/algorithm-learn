package com.algorithms.leetcode.secondhundred;

import java.util.Stack;

public class leetcode_143_ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next.next == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        //找到上中位点
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode postNode = slow.next;
        slow.next = null;
        while (postNode != null) {
            stack.push(postNode);
            postNode = postNode.next;
        }
        while (cur != null) {
            if (!stack.isEmpty()) {
                ListNode node = stack.pop();
                ListNode temp = cur.next;
                cur.next = node;
                node.next = temp;
                cur = node.next;
                if (cur == null && !stack.isEmpty()) {
                    ListNode last = stack.pop();
                    last.next = null;
                    node.next = last;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        reorderList(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

}



