package com.algorithms.leetcode.threehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_228_SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((end + 1) != nums[i]) {
                //出现区间
                if (start == end) {
                    ans.add(String.valueOf(start));
                } else {
                    ans.add(start + "->" + end);
                }
                //新的区间开始
                start = nums[i];
            }
            end = nums[i];
        }
        //加入最后一个
        if (start == end) {
            ans.add(String.valueOf(start));
        } else {
            ans.add(start + "->" + end);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
