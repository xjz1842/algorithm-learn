package com.algorithms.leetcode.onehundred;

public class leetcode_82_DeleteDuplicates {

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

        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = null;
        ListNode next = newHead;

        while (cur != null && cur.next != null) {
            prev = cur;
            cur = cur.next;
            if (prev.val == cur.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                if (newHead == null) {
                    newHead = prev;
                    next = newHead;
                } else {
                    next.next = prev;
                    next = next.next;
                }
            }
        }
        //处理最后一个节点
        if (cur != null) {
            if (next == null) {
                newHead = cur;
            } else {
                next.next = cur;
            }
        } else {
            if (next != null) {
                next.next = null;
            }
        }
        return newHead;
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
