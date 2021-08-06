package com.algorithms.leetcode.threehundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_232_MyQueue {

    Stack<Integer> stack1;

    /**
     * Initialize your data structure here.
     */
    public leetcode_232_MyQueue() {
        stack1 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.push(x);
        } else {
            List<Integer> tmp = new ArrayList<>();
            while (!stack1.isEmpty()){
                tmp.add(stack1.pop());
            }
            stack1.push(x);
            for(int i = tmp.size()-1; i >= 0; i--){
                stack1.push(tmp.get(i));
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
       return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty();
    }
}
