package algorithms.leetcode;

import java.util.Stack;

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap_42 {

    public static int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int l = 0;
        int r = height.length - 1;

        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {

            if (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();

                    if (stack.isEmpty()) break;

                    l = stack.peek();

                    int h = Math.min(height[i], height[l]) - height[mid];

                    result += h * (i - l - 1);
                }
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(height));
    }


}
