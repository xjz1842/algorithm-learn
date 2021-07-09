package com.algorithms.interview.linklist;

// 实现单链表
// 1. 假设链表中的所有节点都是 0-index的。
public class ListNode {
    // val用来存放链表中的数据
    public int val = 0;
    // next指向下一个结点
    public ListNode next = null;

    public ListNode() {
    }
    public ListNode(int x) {
        val = x;
    }
}
