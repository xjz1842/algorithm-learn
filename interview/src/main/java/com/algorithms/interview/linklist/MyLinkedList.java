package com.algorithms.interview.linklist;

// 实现单链表
public class MyLinkedList {

    private ListNode dummy = new ListNode();

    private ListNode tail = dummy;

    private int length = 0;

    private ListNode getPreNode(int index) {
        ListNode cur = dummy.next;
        ListNode pre = dummy;

        for(int i = 0; i < index; i++){
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        return getPreNode(index).next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = dummy.next;
        dummy.next = node;
        // change tail
        if(tail == dummy){
            tail = node;
        }
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        tail.next = node;
        tail = tail.next;
        length++;
    }

    // 在链表中的第 index 个节点之前添加值为 val  的节点。
    // 1. 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
    // 2. 如果 index 大于链表长度，则不会插入节点。
    // 3. 如果index小于0，则在头部插入节点。
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length)return;
        if(index == length){
            addAtTail(val);
            return;
        }else if(index <= 0){
            addAtHead(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode pre = getPreNode(index);

        node.next = pre.next;
        pre.next = node;
        //length ++
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= length || index < 0)return;

        ListNode pre = getPreNode(index);

        if(pre.next == tail){
            tail = pre;
        }
        length--;
        pre.next = pre.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.deleteAtIndex(1);
        obj.addAtHead(2);
        obj.addAtHead(7);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(5);
        obj.addAtTail(5);
        System.out.println(obj.get(5));
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);
    }
}
