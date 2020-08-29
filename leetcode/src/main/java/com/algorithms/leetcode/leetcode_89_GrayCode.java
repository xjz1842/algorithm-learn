package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_89_GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        int index = 1;
        while (index <= n) {
            int len = ans.size();
            for (int i = len - 1; i >= 0; i--) {
                ans.add(ans.get(i) + (1 << (index - 1)));
            }
            index++;
        }
        return ans;
    }


    public static void main(String[] args) {
        List<Integer> list = grayCode(3);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
