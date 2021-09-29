package com.algorithms.leetcode.fourhundred;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode_347_TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counter = new HashMap<>();

        for(Integer i : nums){
            if(counter.containsKey(i)){
                counter.put(i,counter.get(i)+1);
            }else{
                counter.put(i,1);
            }
        }
        // 按照 count计算倒序
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(Map.Entry<Integer,Integer> entry : counter.entrySet()){
            priorityQueue.add(entry);
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
           ans[i] = priorityQueue.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums =  new int[]{1};
        int k = 1;
        for(int i : topKFrequent(nums,k)){
            System.out.println(i);
        }
    }
}

