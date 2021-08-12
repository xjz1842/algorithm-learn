package com.algorithms.interview.dp;

import java.util.Scanner;

/**
 * （0/1 背包）有 N 件物品和一个容量是 V 的背包，每件物品只能使用一次。
 * <p>
 * 第 i 件物品的体积是 vi，价值是 wi。求解将哪些物品装入背包，可
 * <p>
 * 使这些物品的总体积不超过背包容量，且总价值最大。输出最大价值。
 */
public class Bag {

    public static void main(String[] args) {
        // 读入数据的代码
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int V = reader.nextInt();
        // 一个长度为N的数组，第i个元素表示第i个物品的体积；
        int[] v = new int[N + 1];
        // 一个长度为N的数组，第i个元素表示第i个物品的价值；
        int[] w = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            v[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        reader.close();

        int[] dp = new int[V + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= 0; j--) {
                //可以使用无限次
                for (int m = 1; m <= j / v[i]; m++) {
                    dp[j] = Math.max(dp[j], dp[j - v[i] * m] + w[i]*m);
                }
            }
        }
        System.out.println(dp[V]);
    }

}
