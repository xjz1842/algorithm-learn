package com.algorithms.leetcode;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 */
public class leetcode_39_CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {


        Map<Integer, List<List<Integer>>> dict = new HashMap<>(target + 1);

        for (int i = 0; i <= target; i++) {

            for (int j = 0; j < candidates.length; j++) {

                if (i == candidates[j]) {

                    List<List<Integer>> list = dict.get(i);

                    if (list != null && list.size() > 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(candidates[j]);
                        list.add(temp);
                        dict.put(i, list);
                    } else {
                        list = new ArrayList<>();
                        List<Integer> temp = new ArrayList<>();
                        temp.add(candidates[j]);
                        list.add(temp);
                        dict.put(i, list);
                    }
                } else if (i > candidates[j]) {

                    List<List<Integer>> list = dict.get(i - candidates[j]);

                    if (list != null && list.size() > 0) {

                        List<List<Integer>> copy = new ArrayList<>();
                        for (List<Integer> l : list) {
                            copy.add(new ArrayList<>(l));
                        }
                        for (List<Integer> candidate : copy) {
                            candidate.add(candidates[j]);
                            Collections.sort(candidate);
                        }

                        if (dict.get(i) != null) {
                            for (List<Integer> temp : copy) {
                                Collections.sort(temp);
                                if (!dict.get(i).contains(temp)) {
                                    dict.get(i).add(temp);
                                }
                            }
                        } else {
                            dict.put(i, copy);
                        }

                    }
                }
            }
        }
        return dict.get(target) != null ? dict.get(target) : new ArrayList<>();
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        process(candidates, 0, candidates.length, target, res);

        return res;
    }

    public static void process(int[] arr, int l, int r, int rest, List<List<Integer>> res) {
        if (rest == 0) {
            res.add(new ArrayList<>(ans));
        }

        for (int i = 0; i < r; i++) {
            // 大剪枝
            if (rest - arr[i] < 0) {
                break;
            }
            if (i > l && arr[i] == arr[i - 1]) {
                continue;
            }
            ans.add(arr[i]);

            process(arr, i + 1, r, rest - arr[i], res);

            ans.remove(ans.size() - 1);
        }
    }

    private static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 5;

//      List<List<Integer>> list = combinationSum2(arr, 8);

        int[] array = new int[]{2, 3, 5};

        List<List<Integer>> list1 = combinationSum(array, 8);

        for (List<Integer> ans : list1) {
            System.out.println(ans);
        }
    }
}
