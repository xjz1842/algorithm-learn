package com.algorithms.leetcode.fourhundred;

public class leetcode_328_OddEvenList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        //存放奇数链表 (虚拟头节点)
        ListNode oddHead = new ListNode();
        //存放偶数链表 (虚拟头节点)
        ListNode eventHead = new ListNode();

        ListNode copyOddHead = oddHead;
        ListNode copyEventHead = eventHead;
        while (head != null){
            oddHead.next = head;
            eventHead.next = head.next;
            //后移一个
            oddHead = oddHead.next;
            eventHead = eventHead.next;
            if(head.next == null){
                break;
            }
            head = head.next.next;
        }
        //链接偶离链表到奇数链表上
        oddHead.next = copyEventHead.next;
        return copyOddHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode h = oddEvenList(head);
        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}
