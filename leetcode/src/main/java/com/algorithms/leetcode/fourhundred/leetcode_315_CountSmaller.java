package com.algorithms.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zxj
 */
public class leetcode_315_CountSmaller {

    /**
     * 归并排序
     */
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if(len == 0){
            return result;
        }
        int[] temp = new int[len];
        int[] res = new int[len];

        //索引数组
        int[] indexes = new int[len];
        for(int i = 0; i < len; i++){
            indexes[i] = i;
        }

        mergeAndCountSmaller(nums,0,len-1,indexes,temp,res);

        for(int i = 0; i < res.length; i++){
            result.add(res[i]);
        }
        return result;
    }

    /**
     * @param nums 原始数组
     * @param l 开始索引
     * @param r 结束索引 
     * @param indexes 索引数组
     * @param temp 临时数组
     * @param res 结果数据
     */
    private static void mergeAndCountSmaller(int[] nums, int l, int r, int[] indexes, int[] temp, int[] res) {
        if(l == r){
           return;
       }
       int mid = l + (r - l)/2;
       mergeAndCountSmaller(nums, l, mid, indexes, temp, res);
       mergeAndCountSmaller(nums, mid+1,r, indexes, temp, res);
        // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
            return;
        }
        mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r, indexes, temp, res);
    }

    private static void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r, int[] indexes, int[] temp,
            int[] res) {
        //保存原来的索引
         for(int i = l; i <= r; i++){
             temp[i] = indexes[i];
         }
        int i = l;
        int j = mid+1;

        for(int k = l; k <= r; k++){
            if( i > mid){
                indexes[k] = temp[j];
                j++;
            }else if(j > r){
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (r - mid);
            }else if(nums[temp[i]] <= nums[temp[j]]){
                indexes[k] = temp[i];
                i++;
                //temp[i] 大于 [mid+1,j-1] = (j-1 = (mid+1) + 1) = (j - mid -)
                res[indexes[k]] += (j - mid-1);
            }else{
                indexes[k] = temp[j];
                j++;
            }
        }
     }

    /**
    * ----------------------------------------------------------------
    */
     private static int[] count;
     private static int[] buckets;

     /**
      * 树状数组
      */
     public static List<Integer> countSmaller1(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        //离散化
        discretization(nums);
        //初始化
        init(nums.length);
        //从右往左
        for(int i = nums.length-1; i >= 0; i--){
            int index = getIndex(nums[i]);
            resultList.add(query(index));
            update(index+1);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private static void init(int length) {
        count = new int[length];
        Arrays.fill(count, 0);
    }

    /**
     * 二进制从右往左 第一个为1的bit位置
     */
    private static int lowBit(int x){
        return x & (-x);
    }

    private static int getIndex(int x){
        return Arrays.binarySearch(buckets, x);
    }

    /**
     * 获取pos之前的前缀和
     * @param pos 索引
     * @return 前缀和
     */
    private static int query(int pos){
        int ret = 0;
        while(pos > 0){
            ret += count[pos];
            pos -=  lowBit(pos);
        }
        return ret;
    }

    private static void update(int pos){
        while(pos < count.length){
            count[pos] += 1;
            pos += lowBit(pos);
        }
    }
    //离散化
    private static void discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //去重
        for (Integer i : nums) {
            set.add(i);
        }
        int size = set.size();
        buckets = new int[size];
        int index = 0;
        for (Integer i : set) {
            buckets[index++] = i;
        }
        //排序
        Arrays.sort(buckets);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,2,6,1};
        System.out.println(countSmaller(nums));
        System.out.println(countSmaller1(nums));
    }
}
