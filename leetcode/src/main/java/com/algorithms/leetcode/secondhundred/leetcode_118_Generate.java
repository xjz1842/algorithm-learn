package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_118_Generate {

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result;
        }

        if (numRows == 2) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            List<Integer> twoRow = new ArrayList<>();
            twoRow.add(1);
            twoRow.add(1);
            result.add(twoRow);
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        List<Integer> twoRow = new ArrayList<>();
        twoRow.add(1);
        twoRow.add(1);
        result.add(twoRow);
        List<Integer> preRow = twoRow;
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < preRow.size() - 1; j++) {
                row.add(preRow.get(j) + preRow.get(j + 1));
            }
            row.add(1);
            result.add(row);
            preRow = row;
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.printf("%s\t", i);
            }
            System.out.println();
        }
    }

}
