package com.algorithms.leetcode.secondhundred;

public class leetcode_137_SingleNumber {

    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }

}
