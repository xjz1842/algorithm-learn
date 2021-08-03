package com.algorithms.interview.sort;

import com.algorithms.interview.linklist.ListNode;

public class MergeLinkList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //虚拟头节点
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null || l2 != null) {
            if ((l2 == null)|| (l1 != null && l1.val <= l2.val)) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        tail.next = null;
        return dummy.next;
    }
}
