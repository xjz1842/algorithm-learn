package com.algorithms.leetcode.onethousand.threehundred;

import java.util.*;

public class leetcode_MaxEvents_1353 {

    public static int maxEvents(int[][] events) {
        if (events == null || events.length == 0) {
            return 0;
        }
        List<Integer[]> meetings = new ArrayList<>();
        for (int[] i : events) {
            Integer[] ints = new Integer[2];
            ints[0] = i[0];
            ints[1] = i[1];
            meetings.add(ints);
        }
        // 按照开始时间排序
        Collections.sort(meetings, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int day = 0;
        int idx = 0;
        int result = 0;
        while (idx < events.length || !queue.isEmpty()) {
            //初始话
            if (queue.isEmpty()) {
                //开始时间
                day = meetings.get(idx)[0];
                queue.add(meetings.get(idx)[1]);
                idx++;
            }
            //加入可能的会议的结束时间
            while (idx < events.length && meetings.get(idx)[0] <= day) {
                queue.add(meetings.get(idx)[1]);
                idx++;
            }
            //如果没有没有到期
            if (!queue.isEmpty() && queue.peek() >= day) {
                day++;
                result++;
            }
            queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] events = new int[][]{
                {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}};
        System.out.println(maxEvents(events));
    }
}