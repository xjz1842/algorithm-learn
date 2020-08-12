package com.algorithms.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * (例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_33_Search {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            //右半段有序
            if (nums[mid] < nums[r]) {
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                //左半段有序
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * <p>
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[] searchRange(int[] nums, int target) {

        if (nums == null)
            return new int[]{1, 1};

        int[] result = new int[2];

        int l = 0;
        int r = nums.length - 1;

        int targetIndex = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                targetIndex = mid;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (targetIndex == -1) {
            return new int[]{-1, -1};
        }

        l = targetIndex;
        r = targetIndex;

        for (; l >= 0; l--) {
            if (nums[l] != target) {
                break;
            }
        }

        for (; r < nums.length; r++) {
            if (nums[r] != target) {
                break;
            }
        }
        return new int[]{l + 1, r - 1};
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1};

        int[] array = new int[]{1};

//      System.out.println(search(arr, 3));

        System.out.println(searchRange(array, 1));
    }

}
