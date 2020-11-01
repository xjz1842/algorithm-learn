package com.algorithms.leetcode.threehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_216_CombinationSum3 {


    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        process(k, 1, n, new ArrayList<>(), result);
        return result;
    }

    private static void process(int k, int i, int n, List<Integer> tmp, List<List<Integer>> result) {
        if (tmp.size() == k && n == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int j = i; j <= 9; j++) {
            tmp.add(j);
            process(k, j + 1, n - j, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int k = 2;
        int n = 6;

        for (List<Integer> list : combinationSum3(k, n)) {
            System.out.println(list);
        }
    }


}
