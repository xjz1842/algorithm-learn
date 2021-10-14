package com.algorithms.leetcode.fourhundred;

import java.util.Map;
import java.util.TreeMap;

public class leetcode_392_SummaryRanges {

    /**
     * 使用TreeMap<Integer,Integer> 护连续区间
     * 首先找到 val <= l0 的区间  [L0,r0]  l1 > val区间 [l1,r1]
     * 分情况合并区间
     * 1) 当 l0 <= value <= l1  直接return，区间保持不变
     * 2) 当 r0+1 = value = l1-1, 合并大区间 [l0,r1]
     * 3) 当 value = r0 +1, 则合并区间 [l0,r0+1]
     * 4) 当 value = l1 - 1, 则合并区间 [value, r1];
     * 5) 不满足以上四种情况， 自身单独成一个区间
     */
    private static TreeMap<Integer,Integer> internals;

    public leetcode_392_SummaryRanges() {
        internals = new TreeMap<>();
    }

    public static void addNum(int val) {
         //小于val的区间
        Map.Entry<Integer, Integer> lowInternals = internals.floorEntry(val);
        //大于val的全进
        Map.Entry<Integer, Integer>  highInternals = internals.ceilingEntry(val+1);

        boolean mergeToLeft = lowInternals != null && lowInternals.getValue() + 1 == val;
        boolean mergeToRight = highInternals != null && highInternals.getKey() - 1 == val;
        //情况1
        if(lowInternals != null && lowInternals.getKey() <= val && val <= lowInternals.getValue()){
            return;
        }
        if(mergeToLeft && mergeToRight){
            //情况二
            internals.remove(lowInternals.getKey());
            internals.remove(highInternals.getKey());
            internals.put(lowInternals.getKey(),highInternals.getValue());
        }else if (mergeToLeft) {
            //情况三
            internals.put(lowInternals.getKey(),val);
        }else if(mergeToRight){
            //情况四
            internals.remove(highInternals.getKey());
            internals.put(val,highInternals.getValue());
        }else{
            //情况五 自身成一对
            internals.put(val,val);
        }
    }

    public static int[][] getIntervals() {
        int[][] ans = new int[internals.size()][2];
        int index = 0;
        for(Map.Entry<Integer,Integer> entry : internals.entrySet()){
            ans[index][0] = entry.getKey();
            ans[index][1] = entry.getValue();
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode_392_SummaryRanges sumaryRanges = new leetcode_392_SummaryRanges();
        addNum(1);
        addNum(3);
        addNum(7);
        for (int[] arr : getIntervals()) {
            for(int i = 0; i < arr.length; i++){
                System.out.printf("%d \t",arr[i]);
            }
            System.out.println();
        }
    }
}
