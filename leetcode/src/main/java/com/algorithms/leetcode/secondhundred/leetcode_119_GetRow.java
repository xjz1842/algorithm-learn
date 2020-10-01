package com.algorithms.leetcode.secondhundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_119_GetRow {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            return row;
        }
        if (rowIndex == 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result.get(rowIndex - 1);
        }
        if (rowIndex == 2) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            List<Integer> twoRow = new ArrayList<>();
            twoRow.add(1);
            twoRow.add(1);
            result.add(twoRow);
            return result.get(rowIndex - 1);
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
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < preRow.size() - 1; j++) {
                row.add(preRow.get(j) + preRow.get(j + 1));
            }
            row.add(1);
            result.add(row);
            preRow = row;
        }
        return result.get(rowIndex);
    }
}
