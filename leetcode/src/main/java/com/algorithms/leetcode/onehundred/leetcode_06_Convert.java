package com.algorithms.leetcode.onehundred;

public class leetcode_06_Convert {

    public static String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();

        int group = chars.length / (numRows + numRows - 2);
        int col = (numRows - 1) * group;
        int remain = chars.length % (numRows + numRows - 2);
        col = col + (remain == 0 ? 0 : (remain <= numRows ? 1 : (remain - numRows + 1)));

        char[][] arr = new char[numRows][col];

        int i = 0;
        int startRow = 0;
        int startCol = 0;
        while (i < chars.length) {
            //填竖行
            for (; startRow < numRows && i < chars.length; startRow++) {
                arr[startRow][startCol] = chars[i++];
            }
            startRow--;
            //折线
            int tempCol = startCol;
            for (startCol = startCol + 1; startCol < (tempCol + numRows - 1) && startCol < col && i < chars.length; startCol++) {
                arr[--startRow][startCol] = chars[i++];
            }
            startRow--;
        }

        StringBuilder result = new StringBuilder();
        for (int m = 0; m < arr.length; m++) {
            for (int n = 0; n < arr[0].length; n++) {
                if (arr[m][n] != '\u0000') {
                    result.append(arr[m][n]);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(str, numRows));
    }
}
