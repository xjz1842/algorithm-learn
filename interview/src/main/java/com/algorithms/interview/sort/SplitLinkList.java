package com.algorithms.interview.sort;

/**
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (67.66%)
 * Likes:    960
 * Dislikes: 0
 * Total Accepted:    135.1K
 * Total Submissions: 199.6K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 *
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 *
 * 示例 3：
 *
 *
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -10^5
 *
 **/

import com.algorithms.interview.linklist.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SplitLinkList {

    private ListNode split(ListNode head) {
        ListNode s1 = head, s2 = head, pre = head;
        while (s2 != null && s2.next != null) {
            pre = s1;
            s1 = s1.next;
            s2 = s2.next.next;
        }
        return s2 != null ? s1 : pre;
    }

    private ListNode Qsort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final int x = split(head).val;

        ListNode small = new ListNode();
        ListNode stail = small;
        ListNode equal = new ListNode();
        ListNode etail = equal;
        ListNode large = new ListNode();
        ListNode ltail = large;

        ListNode p = head;

        while (p != null) {
            ListNode next = p.next;

            if (p.val < x) {
                stail.next = p;
                stail = p;
            } else if (p.val == x) {
                etail.next = p;
                etail = p;
            } else {
                ltail.next = p;
                ltail = p;
            }
            p = next;
        }

        stail.next = etail.next = ltail.next = null;
         //排序小的部分
        small.next = Qsort(small.next);
        //排序大的部分
        large.next = Qsort(large.next);

        p = small.next;
        while (p != null && p.next != null) {
            p = p.next;
        }

        if (p != null) {
            p.next = equal.next;
        } else {
            small.next = equal.next;
        }
        etail.next = large.next;

        return small.next;
    }

    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        return Qsort(head);
    }

}
