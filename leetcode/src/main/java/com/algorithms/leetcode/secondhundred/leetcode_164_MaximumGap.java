package com.algorithms.leetcode.secondhundred;


public class leetcode_164_MaximumGap {

    static class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public static int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int bucketSize = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        if (bucketSize == 0) {
            return 0;
        }
        Bucket[] buckets = new Bucket[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - min) / bucketSize;

            if (buckets[idx] == null) {
                buckets[idx] = new Bucket();
            }
            buckets[idx].max = Math.max(nums[i], buckets[idx].max);
            buckets[idx].min = Math.min(nums[i], buckets[idx].min);
        }
        //前一个桶的 max
        int preMax = -1;
        //最大间隔
        int maxGap = 0;
        for (int i = 0; i < buckets.length; i++) {
            //桶不为空,并且不是第一个桶
            if (buckets[i] != null && preMax != -1) {
                maxGap = Math.max(maxGap, buckets[i].min - preMax);
            }
            //记录前一个桶的 max
            if (buckets[i] != null) {
                preMax = buckets[i].max;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1000};

        System.out.println(maximumGap(nums));
    }
}
