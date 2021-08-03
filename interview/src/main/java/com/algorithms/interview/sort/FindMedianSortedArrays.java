package com.algorithms.interview.sort;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 4.寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArrays {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        final int len = len1 + len2;
        int i = 0;
        int j = 0;
        // 如果两个数组的总长度为0
        //那么不用再找了，肯定是没有中位数的，这里直接返回一个0
        if (len == 0) {
            return 0;
        }

        // 总长度为偶数的情况：
        // 如果有4个数，那么当扔掉1个数之后
        // 接下来需要合并的两个数排[2,3]就是中位数
        // 总长度为奇数的情况：
        // 比如如果有5个数，那么当合并掉2个数之后
        // 接下来的那个排[3]位的就是中位数。
        // 所以这里k表示：要扔掉的数的个数
        int k = (len - 1) >> 1;

        while (k > 0) {
            // 我们需要比较A[p]与B[p]
            // 只不过当数组的起始位置是i和j的时候。
            // 比较的元素就变成 A[i+p], B[j+p]
            final int p = (k - 1) >> 1;
            // 这时直接比较A[i + p]和B[j+p]来决定谁可以被扔掉掉
            // 注意这里扔掉的时候，只需要前移p + 1即可。
            if ((j + p >= len2) || (i + p < len1 && nums1[i + p] < nums2[j + p])) {
                i += p + 1;
            } else {
                j += p + 1;
            }
            k -= p + 1;
        }
        // 把排在前面的数取出来
        double front = (j >= len2) || (i < len1 && nums1[i] < nums2[j])
                ? nums1[i++] : nums2[j++];

        if ((len & 1) == 1) {
            return front;
        }
        // 此时总的数目为偶数，那么需要再取一个数，求平均值。
        double back =
                (j >= len2 || (i < len1 && nums1[i] < nums2[j])) ? nums1[i] : nums2[j];

        return (front + back) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
