package com.algorithms.leetcode.onehundred;


public class leetcode_02_AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;
        ListNode head = null;
        if ((l1.val + l2.val + carry) > 9) {
            carry = 1;
            head = new ListNode(l1.val + l2.val - 10);
        } else {
            carry = 0;
            head = new ListNode(l1.val + l2.val);
        }
        l1 = l1.next;
        l2 = l2.next;
        ListNode newHead = head;
        while (l1 != null && l2 != null) {
            if ((l1.val + l2.val + carry) > 9) {
                head.next = new ListNode(l1.val + l2.val + carry - 10);
                carry = 1;
            } else {
                head.next = new ListNode(l1.val + l2.val + carry);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }

        while (l1 != null) {
            if (l1.val + carry > 9) {
                head.next = new ListNode(l1.val + carry - 10);
                carry = 1;
            } else {
                head.next = new ListNode(l1.val + carry);
                carry = 0;
            }
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            if (l2.val + carry > 9) {
                head.next = new ListNode(l2.val + carry - 10);
                carry = 1;
            } else {
                head.next = new ListNode(l2.val + carry);
                carry = 0;
            }
            head = head.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            head.next = new ListNode(1);
        }
        return newHead;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode2 = new ListNode(0);

        ListNode head = addTwoNumbers(listNode, listNode2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

}
