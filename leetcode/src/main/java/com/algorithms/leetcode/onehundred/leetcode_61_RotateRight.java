package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_61_RotateRight {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int lenght = 0;
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();

        while (cur != null) {
            lenght++;
            list.add(cur);
            cur = cur.next;
        }
        cur = head;
        ListNode[] reindexArr = new ListNode[lenght];
        int index = 0;
        while (cur != null) {
            int reindex = (index + k) % (lenght);
            reindexArr[reindex] = cur;
            cur = cur.next;
            index++;
        }

        ListNode newHead = new ListNode(reindexArr[0].val);
        ListNode newCur = newHead;
        for (int i = 1; i < reindexArr.length; i++) {
            newCur.next = new ListNode(reindexArr[i].val);
            newCur = newCur.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = rotateRight(head, 2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
