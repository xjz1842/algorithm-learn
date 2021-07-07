package com.algorithms.interview.heap;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 【题目】一辆汽车携带 startFuel 升汽油从位置 0 出发前往位置 target，按顺序有一系列加油站 stations。第 i 个加油站位于 stations[i][0]，
 * 可以加 stations[i][1] 升油（一个加油站只能加一次）。
 * 如果想要到达 target，输出最少加油次数。如果不能到达 target，那么返回 -1。
 * <p>
 * 两个条件：
 * <p>
 * 假设汽车油箱总是很大；
 * <p>
 * 假设行走一单位距离，消耗一升汽油。
 * <p>
 * 示例：
 * <p>
 * 输入：target = 100, startFuel = 10, stations = [[10, 60], [20, 30], [30, 30], [60, 40]]
 * <p>
 * 输出：2
 */
public class AddOilTimes {

    public static Integer getMinAddOilTimes(int[][] stations, int startFuel, int target) {
        if (stations == null || stations.length == 0) {
            return 0;
        }
        Queue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        final int N = stations.length;
        int curLoc = 0;
        int times = 0;
        int i = 0;
        int restOils = startFuel;
        while ((curLoc + restOils) < target) {
            // 默认期望的下一站，站点设置为target
            // 此时能加的汽油为0
            int nextLoc = target;
            int addOil = 0;
            if (i < N && stations[i][0] <= target) {
                nextLoc = stations[i][0];
                addOil = stations[i][1];
            }
            // 如果当前汽车的状态，不能到达期望的下一站
            while (curLoc + restOils < nextLoc) {
                // 惨了，副油箱没有油了，
                if (priorityQueue.isEmpty()) {
                    return -1;
                }
                // 拿出副油箱啊
                // 从副油箱里面拿出最大的汽油加上去
                final int curMaxFuel = priorityQueue.poll();
                restOils += curMaxFuel;
                 // 加油次数++
                times++;
            }
            // 好了，现在可以到达期望的下一站了
            final int fuelCost = nextLoc - curLoc;
            restOils -= fuelCost;
            //到达下一站
            curLoc = nextLoc;
            // 这个汽油站里面的汽油加到副油箱
             if (addOil > 0) {
               priorityQueue.offer(addOil);
            }
             // 这个站就过去了
             i++;
        }
        // 能到达target吗？如果能，返回加油次数，不能返回-1
        return curLoc + restOils >= target ? times : -1;
    }

    public static void main(String[] args) {
        int[][] stations = new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int startFuel = 10;
        int target = 100;
        System.out.println(getMinAddOilTimes(stations, startFuel, target));
    }
}
