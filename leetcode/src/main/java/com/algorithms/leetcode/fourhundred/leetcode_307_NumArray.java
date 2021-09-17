package com.algorithms.leetcode.fourhundred;

public class leetcode_307_NumArray {

    static int[] tree;
    static int n;

    public leetcode_307_NumArray(int[] nums) {
        if(nums.length > 0){
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        for(int i = n,j = 0; i < 2 * n; i++,j++){
            tree[i] = nums[j];
        }
        for(int i = n-1; i > 0; i--){
            tree[i] = tree[i * 2] + tree[i * 2 +1];
        }
    }

    public static void update(int index, int val) {
        index += n;
        tree[index] = val;
        while (index > 0){
            int left = index;
            int right = index;
            if(index % 2 == 0){
                right = index+1;
            }else{
                left = index - 1;
            }
            tree[index/2] = tree[left] + tree[right];
            index /= 2;
        }
    }

    public static int sumRange(int left, int right) {
        //get leaf index
        left = left + n;
        right = right + n;

        int sum = 0;
        while (left <= right){
           if((left % 2) == 1){
               sum += tree[left];
               left++;
           }else if((right % 2) == 0){
               sum += tree[right];
               right--;
           }
           left /= 2;
           right /= 2;
        }
        return sum;
    }
}
