package com.algorithms.interview.backtrace;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/submissions/
 *
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class CombinationSum3 {

    public static  List<List<Integer>> combinationSum3(int k, int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();

        backtrace(1,n,k,0,new ArrayList<>(),ans);
        return ans;
    }

    /**
     *
     * @param i 从i开始选择
     * @param n 选择从[i n]
     * @param k 组合数大小
     * @param sum 组合和
     * @param candidate 候选
     * @param ans 结果
     */
    private static void backtrace(int i, int n, int k, int sum,List<Integer> candidate, List<List<Integer>> ans) {
        if(i > n && candidate.size() > k){
            return;
        }
        if(sum == n && candidate.size() == k){
            ans.add(new ArrayList<>(candidate));
        }
        for(int j = i; j <= 9; j++){
            candidate.add(j);
            sum += j;
            //组合选j， 候选从[j+1,n]
            backtrace(j+1,n,k,sum,candidate,ans);
            sum -= j;
            candidate.remove(candidate.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        for(List<Integer> list : combinationSum3(k,n)){
            System.out.println(list);
        }
    }
}
