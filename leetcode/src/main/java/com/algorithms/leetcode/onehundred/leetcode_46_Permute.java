package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_46_Permute {

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            out.add(nums[i]);
        }
        process(nums.length - 1, 0, out, result);
        return result;
    }

    private static void process(int n, int index, List<Integer> out, List<List<Integer>> result) {
        if (index == n) {
            List<Integer> list = new ArrayList<>(out);
            if (!result.contains(list)) {
                result.add(list);
            }
        } else {
            for (int i = index; i <= n; i++) {
                Collections.swap(out, i, index);
                process(n, index + 1, out, result);
                Collections.swap(out, i, index);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> list = permute(nums);

        for (List<Integer> subList : list) {
            System.out.println(subList);
        }
    }
}
