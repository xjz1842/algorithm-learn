package com.algorithms.sword.to.offer;

public class Offer_51_ReversePairs {

    /**
     * 归并排序 O(N * log(N))
     */
    public static int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] temp = new int[nums.length];
        return mergeSort(nums,0,nums.length-1,temp);
    }

    private static int mergeSort(int[] nums,int left,int right,int[] temp) {
        if(left == right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        // 分治
        int leftReversPair = mergeSort(nums,left,mid,temp);
        int rightReversPair = mergeSort(nums,mid+1,right,temp);
        if(nums[mid] <= nums[mid+1]){
            return leftReversPair + rightReversPair;
        }
        //合并
        int crossReversPair = merge(nums,left,mid,right,temp);
        return leftReversPair + rightReversPair + crossReversPair;
    }

    private static int merge(int[] nums, int left, int mid, int right, int[] temp) {
        // back up
        if (right + 1 - left >= 0) System.arraycopy(nums, left, temp, left, right + 1 - left);
        int result = 0;
        int i = left;
        int j = mid + 1;
        for(int index = left; index <= right; index++) {
            if(i == (mid+1)){
                nums[index] = temp[j];
                j++;
            }else if(j == (right+1)) {
                nums[index] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]) {
                nums[index] = temp[i];
                i++;
            }else{
                nums[index] = temp[j];
                j++;
                // nums[i] > nums[j] 时， nums[i...mid] 和 nums[j] 组成逆序对
                result += (mid - i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,5,6,4};
        System.out.println(reversePairs(nums));
        for(int i : nums){
            System.out.println(i);
        }
    }
}
