package com.algorithms.leetcode.secondhundred;


public class leetcode_160_GetIntersectionNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(0);
        test.next = new ListNode(9);
        test.next.next = new ListNode(1);
        test.next.next.next = new ListNode(2);
        test.next.next.next.next = new ListNode(4);

        ListNode test1 = new ListNode(2);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(4);

        System.out.println(getIntersectionNode(test, test1).val);
    }
}
