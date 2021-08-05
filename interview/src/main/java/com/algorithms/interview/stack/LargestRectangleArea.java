package com.algorithms.interview.stack;

import java.util.Stack;

/**
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (42.74%)
 * Likes:    1213
 * Dislikes: 0
 * Total Accepted:    126.1K
 * Total Submissions: 294.1K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 思路：
 *
 *  1. 暴力解法 ： 枚举每一个位置i, 找到比i 左右最近位置小的left，right， 最大面积为 (right-left-1) * height[i]
 *
 *  2 单调递增栈:
 *    [i,j]  此时 height[k] < height[j], 则k是是小于j的最近右边界，最近左边界姐就饿height[j-1]
 *    那么 maxArea = (k- (j-1) -1) * height[j]
 *   此题，特别注意两边的边界问题
 *   如果栈中没有元素了，此时左边界为 -1处理
 *   如果所有元素都是递增的，则需要一个右边界为 height.length
 **/

public class LargestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        //利用递增栈
        Stack<Integer> stack = new Stack<>();
        //初始化
        stack.push(0);
        int maxArea = 0;

        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty()
                    && heights[stack.peek()] > heights[i]) {
                maxArea = maxArea(stack,heights,i,maxArea);
            }
            //大的往栈上放
            stack.push(i);
        }
        //如果栈还有，则右边界为height.length
        int rightPos = heights.length;
        while (!stack.isEmpty()){
            maxArea = maxArea(stack,heights,rightPos,maxArea);
        }
        return maxArea;
    }

    public static  int maxArea(Stack<Integer> stack,int[] heights,int rightPos,int maxArea){
        int height = heights[stack.pop()];
        //左边界为-1
        int leftPos = !stack.isEmpty() ? stack.peek() : -1;
        //包含i和leftPos本身
        int width = (rightPos - leftPos - 1);
        //取最大
       return Math.max(maxArea, height * width);
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,4};

        System.out.println(largestRectangleArea(heights));
    }
}
