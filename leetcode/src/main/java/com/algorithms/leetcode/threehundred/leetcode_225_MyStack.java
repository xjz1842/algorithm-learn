package com.algorithms.leetcode.threehundred;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_225_MyStack {

    Queue<Integer> queue1;

    /**
     * Initialize your data structure here.
     */
    public leetcode_225_MyStack() {
        queue1 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        //入队对
       int size = queue1.size();
       queue1.add(x);
       for(int i = 0; i < size; i++){
           queue1.add(queue1.poll());
       }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
       return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
       return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

