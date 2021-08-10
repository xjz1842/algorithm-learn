package com.algorithms.interview.backtrace;

import java.util.ArrayList;
import java.util.List;

public class PrmuteUnique {

    private void append(int[] box, List<List<Integer>> ans) {
        ans.add(new ArrayList<>());
        for (Integer x : box) {
            ans.get(ans.size() - 1).add(x);
        }
    }
    private void swap(int[] box, int i, int j) {
        int t = box[i];
        box[i] = box[j];
        box[j] = t;
    }
    private boolean find(int[] box, int start, int end, int val) {
        for (int i = start; i < end; i++) {
            if (box[i] == val) {
                return true;
            }
        }
        return false;
    }
    private void backtrace(int[] box,
                           int start,
                           List<List<Integer>> ans)
    {
        final int N = box == null ? 0 : box.length;
        // box中只有[0, ..., N)几个空位置
        // 当第i个人进来放东西的时候，
        // 并且要取的范围是[start, N)
        // 也就是[N, N)
        // 1. 肯定是没有东西放的
        // 2. 并且box此时已经放满了
        if (start == N) {
            append(box, ans);
            return;
        }
        // 第i个人的选择范围[start, end)
        for (int j = start; j < N; j++) {
            if (!find(box, start, j, box[j])) {
                swap(box, start, j);
                backtrace(box, start + 1, ans);
                swap(box, start, j);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] A) {
        List<List<Integer>> ans = new ArrayList<>();
        final int N = A == null ? 0 : A.length;
        if (N == 0) {
            return ans;
        }
        backtrace(A, 0, ans);
        return ans;
    }
}
