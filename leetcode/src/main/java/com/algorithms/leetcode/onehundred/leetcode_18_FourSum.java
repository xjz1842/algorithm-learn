package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_18_FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        //首先排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int tempTarget = target - nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重
            }
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                } // 去重
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if ((nums[l] + nums[j] + nums[r]) > tempTarget) {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    } else if ((nums[l] + nums[j] + nums[r]) < tempTarget) {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    } else {
                        //等于0
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[l]);
                        ans.add(nums[r]);
                        result.add(ans);
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (r > l && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }

            }
        }
        return result;
    }

<<<<<<< HEAD
    public static void main(String[] args) {

        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        int target = -1;

        List<List<Integer>> list = fourSum(arr, target);

        for (List<Integer> list1 : list) {
            for (Integer i : list1) {
                System.out.printf("%s\t", i);
            }
            System.out.println();
        }
    }

=======
>>>>>>> 增加leetcode 四数之和
}
