package com.algorithms.leetcode.threehundred;


public class leetcode_203_RemoveElements {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, curr = head;

        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(1);
//        test.next.next = new ListNode(6);
//        test.next.next = new ListNode(3);
//        test.next.next.next = new ListNode(4);
//        test.next.next.next.next = new ListNode(5);
//        test.next.next.next.next.next = new ListNode(6);

        ListNode head = removeElements(test, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
