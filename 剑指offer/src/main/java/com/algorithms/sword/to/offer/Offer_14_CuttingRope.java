package com.algorithms.sword.to.offer;

/**
 * &#064;Author:  zxj
 * &#064;Date:  2022/11/10 4:35 PM
 */
public class Offer_14_CuttingRope {

    // 动态规划
    public static int cuttingRope(int n) {
        // dp[i] 表示 i 最大切分的值
        int[] dp = new int[n + 1];

        //初始化值
        dp[0] = 0;
        dp[1] = 0;
        // 算法复杂度 O(n^2)
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static int cuttingRope1(int n) {
        if (n < 3) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (n * res % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(4));
        System.out.println(cuttingRope1(4));
    }

}
