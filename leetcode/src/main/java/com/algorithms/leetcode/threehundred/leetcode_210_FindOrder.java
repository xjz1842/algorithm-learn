package com.algorithms.leetcode.threehundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_210_FindOrder {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }
        // Get the indegree and adjacency of every course.
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for (int i = 0; i < numCourses; i++){
            if (indegrees[i] == 0) {
                queue.add(i);
                result.add(i);
            }
        }
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;

            for (int cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) {
                    queue.add(cur);
                    result.add(cur);
                }
            }
        }
        if (result.size() < indegrees.length) {
            return new int[]{};
        }
        int[] ans = new int[result.size()];
        int len = result.size();
        for (int i = 0; i < len; i++) {
            ans[i] = result.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 0},
        };
        int n = 2;
        for (int i : findOrder(n, arr)) {
            System.out.println(i);
        }
    }

}
