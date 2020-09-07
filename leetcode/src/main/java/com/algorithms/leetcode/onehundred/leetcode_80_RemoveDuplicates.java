package com.algorithms.leetcode.onehundred;

public class leetcode_80_RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        int i = 0;
        int startIndex = 0;

        while ((i + 2) < len) {
            while (nums[i] == nums[i + 1] && (i + 2) < len && nums[i + 1] == nums[i + 2]) {
                i++;
            }
            if (nums[i] == -47) {
                System.out.println(nums[i]);
            }

            nums[startIndex++] = nums[i++];
        }

        for (; i < len; i++) {
            nums[startIndex++] = nums[i];
        }
        return startIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-50, -50, -49, -48, -47, -47, -47, -46, -45, -43, -42, -41, -40, -40, -40, -40, -40, -40, -39, -38, -38, -38, -38, -37, -36, -35, -34, -34, -34, -33, -32, -31, -30, -28, -27, -26, -26, -26, -25, -25, -24, -24, -24, -22, -22, -21, -21, -21, -21, -21, -20, -19, -18, -18, -18, -17, -17, -17, -17, -17, -16, -16, -15, -14, -14, -14, -13, -13, -12, -12, -10, -10, -9, -8, -8, -7, -7, -6, -5, -4, -4, -4, -3, -1, 1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9, 9, 10, 10, 10, 11, 11, 12, 12, 13, 13, 13, 14, 14, 14, 15, 16, 17, 17, 18, 20, 21, 22, 22, 22, 23, 23, 25, 26, 28, 29, 29, 29, 30, 31, 31, 32, 33, 34, 34, 34, 36, 36, 37, 37, 38, 38, 38, 39, 40, 40, 40, 41, 42, 42, 43, 43, 44, 44, 45, 45, 45, 46, 47, 47, 47, 47, 48, 49, 49, 49, 50};

        int len = removeDuplicates(arr);

        int a = -40;
        int b = -40;
        System.out.println(a == b);
        for (int i = 0; i < len; i++) {
            System.out.printf("\t" + arr[i]);
        }
    }

}
