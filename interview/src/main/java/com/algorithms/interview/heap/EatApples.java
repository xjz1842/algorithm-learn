package com.algorithms.interview.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 练习题 6：一只蚂蚁在树下吃果子，第 i 天会掉 落A[i] 个果子，这些果子会在接下来的 B[i] 天（即第 i+B[i] 天）立马坏掉不能吃。给定 A，B 两个数组，蚂蚁一天只能吃一个果子。吃不完了它可以存放起来。请问最多蚂蚁可以吃多少个果子。
 * <p>
 * 输入：A = [3, 1], B = [3, 1]
 * <p>
 * 输出：3
 */
public class EatApples {

    private static class Node {
        Integer fruitCount;
        Integer overdue;

        public Node(Integer fruitCount, Integer overdue) {
            this.fruitCount = fruitCount;
            this.overdue = overdue;
        }
    }

    public static int eatenApples(int[] apples, int[] days) {
        if (apples == null || apples.length == 0) {
            return 0;
        }
        //小根堆
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.overdue - o2.overdue;
            }
        });
        int eatDays = 0;
        int i = 0 ;
        final int N = apples == null ? 0 : apples.length;
        while (i < N || !priorityQueue.isEmpty()){
            // 第i天得到 num 个苹果
            // 会在 overdue 那天坏掉
            if(i < N) {
                priorityQueue.add(new Node(apples[i], i + days[i] + 1));
            }
            // 把已经过期的都扔掉
            while (!priorityQueue.isEmpty()
              && (priorityQueue.peek().overdue <= (i+1)) ){
                priorityQueue.poll();
            }
            if(!priorityQueue.isEmpty()){
                // 选出今天吃的
                Node cur = priorityQueue.peek();
                eatDays++;
                //吃完放回
                if(--cur.fruitCount == 0 ){
                    priorityQueue.poll();
                }
            }
            i++;
        }
        return eatDays;
    }

    public static void main(String[] args) {
        int[] fruit = new int[]{1,2,3,5,2};
        int[] overdue = new int[]{3,2,1,4,2};
        System.out.println(eatenApples(fruit,overdue));
    }
}
