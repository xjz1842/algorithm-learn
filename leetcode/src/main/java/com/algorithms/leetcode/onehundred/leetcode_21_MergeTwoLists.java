package com.algorithms.leetcode.onehundred;

public class leetcode_21_MergeTwoLists {

    public static leetcode_19_RemoveNthFromEnd.ListNode mergeTwoLists(leetcode_19_RemoveNthFromEnd.ListNode l1, leetcode_19_RemoveNthFromEnd.ListNode l2) {

        leetcode_19_RemoveNthFromEnd.ListNode newNode = null;

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                newNode = new leetcode_19_RemoveNthFromEnd.ListNode(l2.val);
                l2 = l2.next;
            } else {
                newNode = new leetcode_19_RemoveNthFromEnd.ListNode(l1.val);
                l1 = l1.next;
            }
        }
        leetcode_19_RemoveNthFromEnd.ListNode head = newNode;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                newNode.next = new leetcode_19_RemoveNthFromEnd.ListNode(l2.val);
                l2 = l2.next;
            } else {
                newNode.next = new leetcode_19_RemoveNthFromEnd.ListNode(l1.val);
                l1 = l1.next;
            }
            newNode = newNode.next;
        }

        while (l1 != null) {
            newNode.next = new leetcode_19_RemoveNthFromEnd.ListNode(l1.val);
            newNode = newNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            newNode.next = new leetcode_19_RemoveNthFromEnd.ListNode(l2.val);
            newNode = newNode.next;
            l2 = l2.next;
        }

        return head;
    }

    public static void main(String[] args) {

        leetcode_19_RemoveNthFromEnd.ListNode head = new leetcode_19_RemoveNthFromEnd.ListNode(1);
        head.next = new leetcode_19_RemoveNthFromEnd.ListNode(2);
        head.next.next = new leetcode_19_RemoveNthFromEnd.ListNode(4);

        leetcode_19_RemoveNthFromEnd.ListNode head1 = new leetcode_19_RemoveNthFromEnd.ListNode(1);
        head1.next = new leetcode_19_RemoveNthFromEnd.ListNode(3);
        head1.next.next = new leetcode_19_RemoveNthFromEnd.ListNode(4);

        leetcode_19_RemoveNthFromEnd.ListNode resHead = mergeTwoLists(head, head1);

        while (resHead != null) {

            System.out.println(resHead.val);
            resHead = resHead.next;
        }
    }

}
