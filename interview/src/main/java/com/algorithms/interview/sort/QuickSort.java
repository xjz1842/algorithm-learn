package com.algorithms.interview.sort;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 *
 * https://leetcode-cn.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (57.26%)
 * Likes:    761
 * Dislikes: 0
 * Total Accepted:    166.8K
 * Total Submissions: 291.4K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * 给定一个包含红色、白色和蓝色，一共 n
 * 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 *
 * 示例 2：
 *
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 *
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 提示：
 *
 * n == nums.length
 * 1
 * nums[i] 为 0、1 或 2
 *
 * 进阶：
 *
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 *
 */
public class QuickSort {

    // 交换数组中两个元素的值
    public void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    // 将数组[b, e)范围的元素进行排序
    void qsort(int[] A, int b, int e) {
        // 像二叉树一样，如果空树/只有一个结点，那么不需要再递归了
        // 如果给定的区间段为空，或者只有一个结点。
        if (b >= e || b >= (e + 1)) {
            return;
        }
        // 取数组中间的元素作为x
        final int m = b + ((e - b) >> 1);
        final int x = A[m];

        // 三路切分
        int l = b, i = b, r = e - 1;
        while ( i <= r){
            if (A[i] < x) {
                swap(A, l++, i++);
            }else if(A[i] == x){
                i++;
            }else{
                swap(A, r--, i);
            }
        }
        // 像二叉树的前序遍历一样，分别遍历左子树与右子树。
        qsort(A, b, l);
        qsort(A, i, e);
    }

    // 主函数，将数组nums排序
    void quickSort(int[] nums) {
        if (nums == null){
            return;
        }
        qsort(nums, 0, nums.length);
    }
}
