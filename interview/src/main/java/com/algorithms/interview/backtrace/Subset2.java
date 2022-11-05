package com.algorithms.interview.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【题目】给定一个可能包含重复元素的整数数组 A，返回该数组所有可能的子集。注意：解集不能包含重复的子集。
 *
 * 输入：A = [1, 2, 2]
 *
 * 输出：[[2], [1], [1,2,2], [2,2], [1,2],[]]
 *
 * 解释：注意：虽然 {A[0]=1, A[1]=2}, {A[0]=1, A[2]=2} 是选取不同位置的数，但是却都构成了{1,2} 这个子集，因此，只能算一个。
 */
public class Subset2 {

    private void append(List<Integer> box,
                        List<List<Integer>> ans) {
        ans.add(new ArrayList<>());
        for (Integer x : box) {
            ans.get(ans.size() - 1).add(x);
        }
    }
    private void backtrace(int[] A,
                           int start, /*第i个人的选择范围(start, N)*/
                           List<Integer> box,
                           List<List<Integer>> ans)
    {
        final int N = A == null ? 0 : A.length;
        append(box, ans);
        // 已经没得选了
        if (start >= N) {
            return;
        }
        for (int j = start; j < N; j++) {
            if (j > start && A[j] == A[j-1]){
                continue;
            } 
            box.add(A[j]);
            backtrace(A, j + 1, box, ans);
            box.remove(box.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] A) {
        final int N = A == null ? 0 : A.length;
        List<Integer> box = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (N <= 0) {
            return ans;
        }
        Arrays.sort(A);
        backtrace(A, 0, box, ans);
        return ans;
    }

}
