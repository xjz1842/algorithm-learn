package com.algorithms.leetcode.threehundred;


public class leetcode_206_ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextTemp = cur.next;
            //然后将当前节点指向pre
            cur.next = prev;
            //pre和cur节点都前进一位
            prev = cur;
            //cur往下一个节点
            cur = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        while (reverseList(head) != null) {

        }
        ;
    }
}
