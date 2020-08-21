package com.algorithms.leetcode;

public class leetcode_83__DeleteDuplicates {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            prev = cur;
            cur = cur.next;
            if (prev.val == cur.val) {
                if (cur.next != null) {
                    prev.next = cur.next;
                    cur = prev;
                } else {
                    prev.next = null;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);


        ListNode rHead = deleteDuplicates(head);

        while (rHead != null) {
            System.out.println(rHead.val);
            rHead = rHead.next;
        }
    }
}
