package com.algorithms.interview.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 * 示例1:
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例2:
 * <p>
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(candidates, 0, target,0, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrace(int[] candidates, int i, int target, int sum,List<Integer> candidate, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(candidate));
        }
        if (i >= candidates.length) {
            return;
        }
        for(int j = i; j < candidates.length; j++) {
            //为了不选取重复的开头元素
            if(j > i && candidates[j] == candidates[j-1]){
                continue;
            }
            candidate.add(candidates[j]);
            sum += candidates[j];

            backtrace(candidates, j+1, target,sum, candidate, ans);
            candidate.remove(candidate.size() - 1);
            sum -= candidates[j];
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}
