package com.algorithms.leetcode.secondhundred;

public class leetcode_147_InsertionSortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            ListNode fromHead = head;
            while (fromHead != cur && cur != null) {
                //交换的node 和 fromHead节点
                if (cur.val < fromHead.val) {
                    int temp = cur.val;
                    ListNode tempNode = fromHead;
                    int pre = tempNode.val;
                    int post = 0;
                    //移动fromHead的元素
                    while (tempNode != cur) {
                        post = tempNode.next.val;
                        tempNode.next.val = pre;
                        tempNode = tempNode.next;
                        pre = post;
                    }
                    fromHead.val = temp;
                    break;
                }
                fromHead = fromHead.next;
            }
        }
        return head;
    }


    public static ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head, cur = head.next;           //使用前驱节点pre便于后续节点的删除操作
        ListNode dummy = new ListNode(0);         //建立一个头结点，便于链表的插入
        dummy.next = head;
        while (cur != null) {
            if (pre.val < cur.val) {                   //前后节点已经有序，无需重排
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                while (p.next != cur && p.next.val < cur.val)
                    p = p.next;
                pre.next = cur.next;         //删除当前节点
                cur.next = p.next;          //将当前节点连接到对应位置
                p.next = cur;               // 将cur放在正确的位置
                cur = pre.next;           //往后移动
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        ListNode head = insertionSortList(root);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
