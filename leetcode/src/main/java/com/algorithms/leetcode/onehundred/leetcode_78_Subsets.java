package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_78_Subsets {

    public static List<List<Integer>> subsets(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, arr, temp, result);
        result.add(new ArrayList<>());
        return result;
    }

    public static void dfs(int depth, int[] arr, List<Integer> temp, List<List<Integer>> result) {
        if (depth > arr.length) {
            return;
        }
        result.add(new ArrayList<>(temp));
        for (int i = depth; i < arr.length; i++) {
            temp.add(arr[i]);
            dfs(i + 1, arr, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> result = subsets(arr);

        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (Integer temp : list) {
                System.out.print("\t" + temp);
            }
            System.out.println();
        }
    }
}
