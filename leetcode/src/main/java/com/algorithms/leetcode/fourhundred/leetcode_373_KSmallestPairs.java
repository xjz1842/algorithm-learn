package com.algorithms.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_373_KSmallestPairs {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1=nums1.length,len2=nums2.length;
        int[] pos=new int[len1];
        List<List<Integer>> res = new ArrayList<>();

        //nums1[index]是组合的第一个数，nums2[pos[index]]是组合的第二个数
        Queue<Integer> queue=new PriorityQueue<>((index1, index2)->nums1[index1]+nums2[pos[index1]]-nums1[index2]-nums2[pos[index2]]);
        for(int i=0;i<Math.min(k,len1);++i){
            queue.offer(i);
        }
        while(res.size()<k && !queue.isEmpty()){
            int index=queue.poll();
            List<Integer> list=new ArrayList<>();
            list.add(nums1[index]);
            list.add(nums2[pos[index]]);
            res.add(list);
            if(++pos[index]<len2){
                queue.offer(index);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2};
        int[] nums2 = new int[]{1,2,3};
        int k = 3;
        System.out.println(kSmallestPairs(nums1,nums2,k));
    }
}
