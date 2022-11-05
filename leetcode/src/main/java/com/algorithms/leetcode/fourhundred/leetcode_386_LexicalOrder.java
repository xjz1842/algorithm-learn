package com.algorithms.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_386_LexicalOrder {


    public static List<Integer> lexicalOrder(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        dfs(0,n,ans);
        return ans;
    }

    private static void dfs(int i,int n, List<Integer> ans) {
        for(int delta = 0; delta <= 9; delta++){
             if(i == 0 && delta == 0){
                 continue;
             }
             int cand = i * 10 + delta;
             if(cand > n){
                 return;
             }
            ans.add(cand);
            dfs(cand,n,ans);
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(lexicalOrder(n));
    }
}
