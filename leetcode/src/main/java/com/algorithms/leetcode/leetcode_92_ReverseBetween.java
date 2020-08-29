package com.algorithms.leetcode;

public class leetcode_92_ReverseBetween {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 0 && n == 0) {
            return head;
        }
        int index = 0;
        ListNode newHead = head;

        ListNode[] tmp = new ListNode[n - m + 1];

        while (head != null) {
            index++;
            if (index >= m && index <= n) {
                tmp[index - m] = head;
            }
            head = head.next;
        }
        //交换数据
        int l = 0;
        int r = tmp.length - 1;
        while (l < r) {
            int temp = tmp[l].val;
            tmp[l].val = tmp[r].val;
            tmp[r].val = temp;
            l++;
            r--;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = reverseBetween(head, 2, 4);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
