package com.algorithms.leetcode.threehundred;

public class leetcode_275_Hindex {

    // 二分查询  O(N * log(N))
    public static int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }
        int left = 0;
        int right = citations.length - 1;

        int len = citations.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //引用次数
            int refCount = citations[mid];
            // 存在至少(right - mid) 个是大于 refCount，说明是符合情况
            if((len - mid) <= refCount){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return len - left;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{0,1};
        System.out.println(hIndex(citations));
    }
}
