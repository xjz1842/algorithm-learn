package com.algorithms.sword.to.offer;

public class Offer_10_NumWays {

    public static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        //从二个个台阶需要2步
        int curSteps = 2;
        //从一个个台阶需要一步
        int preSteps = 1;

        for (int i = 3; i <= n; i++) {
            int tmp = curSteps;
            curSteps = (curSteps + preSteps) % 1000000007;
            preSteps = tmp;
        }
        return curSteps;
    }

    public static void main(String[] args) {
        int n = 44;
        System.out.println(numWays(n));
    }
}
