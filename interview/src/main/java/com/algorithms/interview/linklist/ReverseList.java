package com.algorithms.interview.linklist;

/**
 * 例 1：链表反转
 * 【题目】输入一个链表的头结点，反转该链表，并返回反转后链表的头结点。
 *
 * 输入：1->2->3
 *
 * 输出：3->2->1
 */
public class ReverseList {

    //头插法
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode cur = null; //当前插入的节点
        while (head != null){
            //只想原始头节点
            cur = head;
            //原始指针后移动一个
            head = head.next;
            //将新的后续索引指向当前节点
            cur.next = dummy.next;
            //插入假头的后面
            dummy.next = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);

        ListNode head = reverseList(root);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
