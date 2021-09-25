package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_15_ThreeSum {

    //计算三个数据和等于0
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        } 
        //首先排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                // 去重
                continue; 
            } 
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if ((nums[l] + nums[i] + nums[r]) > 0) {
                    while (l < r && nums[r] == nums[r - 1]){
                        r--;
                    } 
                    r--;
                } else if ((nums[l] + nums[i] + nums[r]) < 0) {
                    while (l < r && nums[l] == nums[l + 1]){
                        l++;
                    } 
                    l++;
                } else {
                    //等于0
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
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
        return result;
    }


    public static void main(String[] args) {
        int[] str = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};

        for (List<Integer> res : threeSum(str)) {
            System.out.println(res);
        }
    }
}
