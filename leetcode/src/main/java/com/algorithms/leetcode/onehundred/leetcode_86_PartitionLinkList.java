package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_86_PartitionLinkList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        int len = 0;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            len++;
            list.add(head.val);
            head = head.next;
        }
        int l = 0;
        int r = len - 1;
        int index = 0;
        while (l <= r) {
            if (list.get(l) < x) {
                Integer moved = list.remove(l);
                list.add(index++, moved);
            }
            l++;
        }
        ListNode newHead = new ListNode(list.get(0));
        ListNode next = newHead;
        for (int i = 1; i < list.size(); i++) {
            next.next = new ListNode(list.get(i));
            next = next.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);

        ListNode node = partition(head, 2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


}
