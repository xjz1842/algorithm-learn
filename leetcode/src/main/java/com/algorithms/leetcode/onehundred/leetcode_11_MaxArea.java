package com.algorithms.leetcode.onehundred;

public class leetcode_11_MaxArea {

    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;

        int l = 0;
        int r = height.length - 1;

        int ans = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                ans = Math.max(ans, (r - l) * height[l]);
                l++;
            } else {
                ans = Math.max(ans, (r - l) * height[r]);
                r--;
            }
        }
        return ans;

    }
}
