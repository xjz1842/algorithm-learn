package com.algorithms.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class leetcode_398_RandomIndex {

    private Random random = new Random();

    private int[] nums;

    public leetcode_398_RandomIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> indexs = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indexs.add(i);
            }
        }
        if (indexs.size() == 0) {
            return -1;
        }
        return indexs.get(random.nextInt(indexs.size()));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        leetcode_398_RandomIndex randonIndex = new leetcode_398_RandomIndex(nums);
        System.out.println(randonIndex.pick(1));
    }
}
