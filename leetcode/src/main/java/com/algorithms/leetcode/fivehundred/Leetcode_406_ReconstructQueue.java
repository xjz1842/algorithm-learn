package com.algorithms.leetcode.fivehundred;

import java.util.*;

public class Leetcode_406_ReconstructQueue {

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people[0].length == 0) {
            return new int[][]{};
        }

        //H 从高到底排序  k 从低到高排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });

        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < people.length; i++) {
            if (list.size() <= people[i][1]) {
                list.add(people[i]);
            } else {
                list.add(people[i][1], people[i]);
            }
        }
        int[][] ans = new int[people.length][people[0].length];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };

        for(int[] arr : reconstructQueue(people)){
            for(int i  : arr){
                System.out.printf("%d \t",i);
            }
            System.out.println();
        }
    }
}
