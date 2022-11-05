package com.algorithms.leetcode.threehundred;

public class leetcode_274_Hindex {

    /**
     *  桶排序 算法复杂度 0(N)
     */
    public static int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }
        int max = 0;
        int len = citations.length;
        for(int i = 0; i < len; i++){
            max = Math.max(citations[i],max);
        }
        //桶个数
        int[] buckets = new int[max+1];

        for(int i = 0; i < len; i++){
             buckets[citations[i]]++;
        }
        //第一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
        //从后往前遍历
        int h = 0;
        // i 代表引用次数
        for(int i = buckets.length-1; i > 0; i--){
            if(buckets[i] == 0){
                continue;
            }
            while (buckets[i] > 0){
                h++;
                buckets[i] -= 1;
                //表示 h篇文章 至少h次引用是不满足，取上一次满足情况
                if(i < h){
                   return h-1;
                }
            }
        }
        return h;
    }

    public static void main(String[] args) {
        int[] citations  = new int[]{1,3,1};
        System.out.println(hIndex(citations));
    }

}
