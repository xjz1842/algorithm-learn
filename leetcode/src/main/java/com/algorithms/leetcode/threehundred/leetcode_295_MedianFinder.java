package com.algorithms.leetcode.threehundred;

import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_295_MedianFinder {

    // java 大堆
    private Queue<Integer> front = new PriorityQueue<>((v1, v2) -> v2 - v1);
    // java小堆
    private Queue<Integer> back = new PriorityQueue<>((v1, v2) -> v1 - v2);

    /**
     * initialize your data structure here.
     */
    public leetcode_295_MedianFinder() {

    }

    public void addNum(int num) {
        // 我们总是把数字加到前面
        // 如果前面的比后面的多
        // 那么就把前面较大的取出来，放到后面
        front.offer(num);
        while (front.size() > back.size()){
            int l = front.poll();
            back.offer(l);
        }
        // 再看一下大小
        // 如果前半部分有数大于后半部分，那么需要交换
        if(!front.isEmpty() && !back.isEmpty()){
            while (back.peek() < front.peek()){
                int f = front.poll();
                int b = back.poll();
                back.add(f);
                front.add(b);
            }
        }
    }

    public double findMedian() {
        // 如果两个集合相等
        if (front.size() == back.size()){
            if(!front.isEmpty()){
                return (double) (front.peek() + back.peek())/2.0;
            }else{
                return 0;
            }
        }else{
            return back.isEmpty() ? 0 : back.peek();
        }
    }

    public static void main(String[] args) {
        leetcode_295_MedianFinder medianFinder = new leetcode_295_MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
