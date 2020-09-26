package com.algorithms.leetcode.onehundred;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_23_MergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1 && lists[0] == null) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        ListNode head = new ListNode(0);
        ListNode node = head;

        while (!priorityQueue.isEmpty()) {
            ListNode pop = priorityQueue.poll();
            ListNode next = new ListNode(pop.val);

            if (pop.next != null) {
                priorityQueue.offer(pop.next);
            }
            node.next = next;
            node = node.next;
        }
        return head.next;
    }
}
