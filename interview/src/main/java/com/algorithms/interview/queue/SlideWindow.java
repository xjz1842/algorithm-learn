package com.algorithms.interview.queue;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 【题目】给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *
 * 输入：nums = [1,3,-1,-3,5,3], k = 3
 *
 * 输出：[3,3,5,5]
 */
public class SlideWindow {

    // 单调队列使用双端队列来实现
    private static ArrayDeque<Integer> Q = new ArrayDeque<Integer>();

    // 入队的时候，last方向入队，但是入队的时候
    // 需要保证整个队列的数值是单调的
    // (在这个题里面我们需要是递减的)
    // 并且需要注意，这里是Q.getLast() < val
    // 如果写成Q.getLast() <= val就变成了严格单调递增
    private static void push(int val) {
        while (!Q.isEmpty() && Q.getLast() < val) {
            Q.removeLast();
        }
        // 将元素入队
        Q.addLast(val);
    }

    // 出队的时候，要相等的时候才会出队
    private static void pop(int val) {
        if (!Q.isEmpty() && Q.getFirst() == val) {
            Q.removeFirst();
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            push(nums[i]);
            // 如果队列中的元素还少于k个
            // 那么这个时候，还不能去取最大值
            if (i < k - 1) {
                continue;
            }
            // 队首元素就是最大值
            ans.add(Q.getFirst());
            // 尝试去移除元素
            pop(nums[i - k + 1]);
        }
        // 将ans转换成为数组返回!
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        int[] window = new int[]{1,3,-1,-3,5,3};

        for(int x : maxSlidingWindow(window,3)){
            System.out.println(x);
        }
    }

}
