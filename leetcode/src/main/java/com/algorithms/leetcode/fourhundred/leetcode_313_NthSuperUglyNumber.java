package com.algorithms.leetcode.fourhundred;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class leetcode_313_NthSuperUglyNumber {

    /**
     * 来自 https://leetcode-cn.com/problems/super-ugly-number/
     * <p>
     * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
     * <p>
     * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
     * <p>
     * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内
     * <p>
     * 输入：n = 12, primes = [2,7,13,19]
     * 输出：32
     * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32]
     * 1 .使用优先级队列
     */
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        Set<Long> exist = new HashSet<>();
        //建立优先级队列  从小到大排序
        PriorityQueue<Long> priorityQue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.intValue() - o2.intValue();
            }
        });
        //初始化为1
        priorityQue.add(1L);
        exist.add(1L);
        Long min = 1L;
        while (n > 0) {
            min = priorityQue.poll();
            for (int i = 0; i < primes.length; i++) {
                Long e = min * primes[i];
                if (!exist.contains(e)) {
                    exist.add(e);
                    priorityQue.add(e);
                }
            }
            n--;
        }
        return min.intValue();
    }

    /**
     * 多路归并
     */
    public static int nthSuperUglyNumber1(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            q.add(new int[]{primes[i], i, 0});
        }
        int[] ans = new int[n];
        ans[0] = 1;
        for (int j = 1; j < n; ) {
            int[] poll = q.poll();
            int val = poll[0], i = poll[1], idx = poll[2];
            if (val != ans[j - 1]) {
                ans[j++] = val;
            }
            q.add(new int[]{ans[idx + 1] * primes[i], i, idx + 1});
        }
        return ans[n - 1];
    }

    /**
     * 动态规划
     */
    public static int nthSuperUglyNumber2(int n, int[] primes) {
        // 质数长度
        int len = primes.length;
        // 索引
        int[] indexes = new int[len];
        // dp[i] 代表 n个 超级丑数的值
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[indexes[j]] * primes[j]);
            }
            // dp[i] 是之前的哪个丑数乘以对应的 primes[j] 选出来的，给它加 1
           for(int k = 0; k < primes.length; k++) {
               // 注意：这里不止执行一次，例如选出 14 的时候，2 和 7 对应的最小丑数下标都要加 1，大家可以打印 indexes 和 dp 的值加以验证
               if(dp[i] == dp[indexes[k]] * primes[k]) {
                   indexes[k]++;
               }
           }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int n = 12;
        int[] primes = new int[]{2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(n, primes));
        System.out.println(nthSuperUglyNumber2(n,primes));
    }
}
