package com.algorithms.interview.linklist;

/**
 * 例 2：删除结点
 * 【题目】给定一个链表头及一个整数值，要求把链表里面等于整数值的结点都从链表中移除出去。
 * <p>
 * 输入：1->2->3->2->4, remove = 2
 * <p>
 * 输出：1->3->4。
 */
public class DeleteListNode {

    /**
     *  新建链表
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val != val) {
                tail.next = cur;
                tail = cur;
            }
            cur = next;
        }
        tail.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(4);

        ListNode head = removeElements(root, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
