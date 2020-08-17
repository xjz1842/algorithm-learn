package com.algorithms.leetcode;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 */
public class leetcode_75_SortColors {

    //partition
    public static void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }

        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > l && nums[i] == 0) {
                swap(nums, i, l++);
            }
            if (i < r && nums[i] == 2) {
                swap(nums, i, r--);
                i--;
            }
        }
    }


    public static void swap(int[] arr, int l, int r) {
        int temp;
        temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 0};
        sortColors(arr);

        for (int a : arr) {
            System.out.println(a);
        }
    }
}
