package com.algorithms.interview.stack;

import java.util.Stack;

/**
 * 【题目】给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，需要满足：1. 长度为 k；2.字典序最小。
 * <p>
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 */
public class FindSmallSeq {

    public static int[] findSmallSeq(int[] nums, int k) {
        if (nums.length < k) {
            return new int[]{};
        }
        int[] result = new int[k];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            int next = nums[i];
            final int rest = nums.length - i;

            while (!stack.isEmpty() && (stack.size() + rest) > k && stack.peek() > next) {
                stack.pop();
            }
            stack.push(next);
        }
        // 如果递增栈里面的数太多，那么我们只需要取出前k个就可以了。
        // 多余的栈中的元素需要扔掉。
        while (stack.size() > k) {
            stack.pop();
        }
        // 把k个元素取出来，注意这{里取的顺序!
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.peek();
            stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ans = new int[]{3, 5, 2, 6};
        int k = 2;
        for (int i : findSmallSeq(ans, k)) {
            System.out.println(i);
        }
    }

}
