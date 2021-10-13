package com.algorithms.leetcode.fourhundred;

import java.util.Random;

public class leetcode_382_RandomListNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode head;

    private Random random = new Random();

    public leetcode_382_RandomListNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int count = 0;
        int result = head.val;
        ListNode cur = head;
        while (cur != null) {
            count = count + 1;
            int rand = 1 + random.nextInt(count);
            if(rand == count){
                result = cur.val;
            }
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        leetcode_382_RandomListNode listNode = new leetcode_382_RandomListNode(head);
        System.out.println(listNode.getRandom());
        System.out.println(listNode.getRandom());
        System.out.println(listNode.getRandom());
    }
}
