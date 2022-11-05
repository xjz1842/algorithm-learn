package com.algorithms.leetcode.threehundred;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_284_PeekingIterator implements Iterator<Integer>{

    Queue<Integer> queue;

    public leetcode_284_PeekingIterator(Iterator<Integer> iterator) {
        queue = new LinkedList<>();
        while (iterator.hasNext()) {
           int i =   iterator.next();
           queue.add(i);
        }
	}

   /**
    * Returns the next element in the iteration without advancing the iterator.
    */
   public Integer peek() {
      return queue.peek();
    }

	/**
     * hasNext() and next() should behave the same as in the Iterator interface.
     */
	@Override
	public Integer next() {
      return queue.poll();
	}


    @Override
	public boolean hasNext() {
        return queue.size() > 0;
	}

}
