package com.algorithms.leetcode.threehundred;

public class leetcode_234_IsPalindrome {

    public static class ListNode {
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        if(head.next.next == null){
            return head.next.val == head.val;
        }
        //使用快慢指针 ,找到中点
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode fastNode = head.next;

        while (fastNode != null) {
            //反转链表
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
            //偶数
            if(fastNode.next == null){
                break;
            }
            //奇数
            if(fastNode.next != null && fastNode.next.next == null) {
                cur = cur.next;
                break;
            }
            fastNode = fastNode.next.next;
        }
        //cur就是中心点
        while (pre != null && cur != null) {
            if (pre.val != cur.val) {
                return false;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next= new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
