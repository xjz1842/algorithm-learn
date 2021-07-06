package com.algorithms.interview.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 例 2：跳跃游戏
 * 【题目】假设你正在玩跳跃游戏，从低处往高处跳的时候，可以有两种方法。
 * <p>
 * 方法一：塞砖块，但是你拥有砖块数是有限制的。为了简单起见，高度差就是你需要砖块数。
 * <p>
 * 方法二：用梯子，梯子可以无视高度差（你可以认为再高也能爬上去），但是梯子的个数是有限的(一个只能用一次)。
 * <p>
 * 其他无论是平着跳，还是从高处往低处跳，不需要借助什么就可以完成（在这道题中我们默认无论从多高跳下来，也摔不死）。
 * <p>
 * 给你一个数组，用来表示不同的高度。假设你总是站在 index = 0 的高度开始。那么请问，你最远能跳到哪里?
 * <p>
 * 输入：[3, 1, 6, 20, 10, 20], bricks = 5, landers = 1
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * Step 1. 从 3 跳到 1 时，因为是从高往低处跳，直接跳就可以了
 * <p>
 * Step 2. 从 1 到 6 时，用掉 5 个砖块
 * <p>
 * Step 3. 从 6 到 20 时，用掉梯子
 * <p>
 * Step 4. 从 20 到 10 可以直接跳
 * <p>
 * Step 5.到 10 这里就停住了，没有东西可以帮助你跳到 20 了，所以只能跳到下标 index = 4 这里。
 */
public class JumpGame {

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        //大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (heights == null || heights.length == 0) {
            return -1;
        }
        int preHeight = heights[0];
        int lastPos = 0;
        int deltaSum = 0;
        for (int i = 1; i < heights.length; i++) {
            int curHeight = heights[i];
            //如果前面一步大于后面，直接跳下去即可
            if (preHeight >= curHeight) {
                lastPos = i;
                preHeight = curHeight;
                continue;
            }
            // 记录gap
            int delta = curHeight - preHeight;
            deltaSum += delta;
            //记录高度差
            priorityQueue.add(delta);

            while (deltaSum > bricks && ladders > 0) {
                Integer maxDelta = priorityQueue.poll();deltaSum -= maxDelta;
                ladders--;
            }
            //砖块不够用,跳出循环!
            if (deltaSum > bricks) {
                break;
            }
            lastPos = i;
            preHeight = curHeight;
        }
        return lastPos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 6, 20, 10, 20};
        int bricks = 5;
        int ladders = 1;

        System.out.println(furthestBuilding(nums, bricks, ladders));
    }
}
