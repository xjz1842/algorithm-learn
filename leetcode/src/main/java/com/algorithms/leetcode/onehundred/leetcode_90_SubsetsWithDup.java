package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_90_SubsetsWithDup {


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();

        process(nums, 0, tmp, ans);
        return ans;
    }

    public static void process(int[] nums, int index, List<Integer> tmp, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            process(nums, i + 1, tmp, ans);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2};
        List<List<Integer>> list = subsetsWithDup(arr);

        for (List<Integer> i : list) {
            for (Integer in : i) {
                System.out.printf("%s\t", in);
            }
            System.out.println();
        }
    }
}
