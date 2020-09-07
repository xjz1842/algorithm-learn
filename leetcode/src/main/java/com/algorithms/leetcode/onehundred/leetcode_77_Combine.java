package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 */
public class leetcode_77_Combine {

    public static List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(1, n, k, temp, result);
        return result;
    }

    public static void dfs(int depth, int n, int k, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = depth; i <= n; i++) {
            temp.add(i);
            dfs(i + 1, n, k, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(4, 2);

        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (Integer temp : list) {
                System.out.print("\t" + temp);
            }
            System.out.println();
        }
    }
}

