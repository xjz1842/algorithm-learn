package com.algorithms.leetcode.secondhundred;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_179_LargestNumber {

    private static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        }
    };

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, comparator);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        String s = sb.toString();
        while (s.startsWith("0") && s.length() > 1) {
            s = s.substring(1);
        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        System.out.println(largestNumber(nums));
    }

}
