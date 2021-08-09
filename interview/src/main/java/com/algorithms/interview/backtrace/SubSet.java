package com.algorithms.interview.backtrace;


import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (76.55%)
 * Likes:    526
 * Dislikes: 0
 * Total Accepted:    143.1K
 * Total Submissions: 186.8K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 */

public class SubSet {

    private static void append(List<Integer> box,List<List<Integer>> ans){
        ans.add(new ArrayList<>());
        for(Integer x : box){
            ans.get(ans.size()-1).add(x);
        }
    }

    private static  void backtrack(int begin, int end, int k, List<Integer> box, List<List<Integer>> ans) {
        if (box.size() == k) {
            append(box, ans);
        }
        // 后面的不需要再处理了
        if (box.size() >= k || begin >= end) {
            return;
        }

        // 第i个人可以选择的宝石
        for (int i = begin; i < end; i++) {
            // 这里假设有一个数组A[], 但是由于A[i] == i
            // 所以这里我们直接放i
            box.add(i);
            backtrack(i + 1, end, k, box, ans);
            box.remove(box.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> box = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(1, n + 1, k, box, ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
