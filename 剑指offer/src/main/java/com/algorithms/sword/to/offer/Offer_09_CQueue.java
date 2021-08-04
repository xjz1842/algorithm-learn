package com.algorithms.sword.to.offer;

import java.util.*;

public class Offer_09_CQueue {
    Stack<Integer> s;
    Stack<Integer> s1;

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public Offer_09_CQueue() {
        s = new Stack<>();
        s1 = new Stack<>();

        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        //加入到尾部
        s.push(value);
        LinkedList<Integer> tmp = new LinkedList<>();
        while (!s1.isEmpty()){
            tmp.addFirst(s1.pop());
        }
        tmp.addFirst(value);
        for(Integer item : tmp){
            s1.push(item);
        }
    }



    public int deleteHead() {
        //删除头部
        if(s1.isEmpty()){
            return -1;
        }
        int head = s1.pop();

        List<Integer> tmp = new LinkedList<>();

        while (!s.isEmpty() && s.size() > 1){
            tmp.add(s.pop());
        }
        s.pop();
        for(Integer item : tmp){
            s.push(item);
        }
        return head;
    }

    public void appendTail1(int value) {
        stack1.push(value);
    }

    public int deleteHead1() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }

    public static void main(String[] args) {
        Offer_09_CQueue queue = new Offer_09_CQueue();
        queue.deleteHead();
        queue.appendTail(5);
        queue.appendTail(2);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
    }
}
