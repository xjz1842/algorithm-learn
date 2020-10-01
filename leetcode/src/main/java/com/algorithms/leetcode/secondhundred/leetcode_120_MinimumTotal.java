package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_120_MinimumTotal {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int row = triangle.size();
        int col = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[row][col];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 0; i < col; i++) {
            dp[row - 1][i] = triangle.get(row - 1).get(i);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        test.add(row);
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        row1.add(3);
        test.add(row1);

        System.out.println(minimumTotal(test));
    }
}


