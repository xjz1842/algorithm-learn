package com.algorithms.leetcode.onehundred;

public class leetcode_5_LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : chars) {
            stringBuilder.append(ch).append("#");
        }
        String newStr = stringBuilder.toString();
        String newS = newStr.substring(0, newStr.length() - 1);

        char[] newArr = newS.toCharArray();
        int maxLength = 1;
        int ansStartIndex = 0;
        int ansEndIndex = 0;
        int startIndex = 0;
        int endIndex = 0;
        int j = 0;
        for (int i = 1; i < newS.length(); i++) {

            boolean flag = false;
            for (j = i + 1; j < newS.length(); j++) {
                //以 i为轴的对称点
                int k = 2 * i - j;
                if (k >= 0) {
                    if (newArr[k] == '#')
                        continue;
                    if (newArr[k] == newArr[j]) {
                        startIndex = k;
                        endIndex = j;
                        flag = true;
                    } else {
                        break;
                    }
                    if (flag) {
                        if (maxLength < (endIndex - startIndex + 1)) {
                            ansStartIndex = startIndex;
                            ansEndIndex = endIndex;
                            maxLength = (ansEndIndex - ansStartIndex + 1);
                        }
                    }
                } else {
                    break;
                }
            }
        }
        if (ansEndIndex < newS.length()) {
            return newS.substring(ansStartIndex, ansEndIndex + 1).replaceAll("#", "");
        } else {
            return newS.substring(ansStartIndex).replaceAll("#", "");
        }
    }

    public static void main(String[] args) {
        String a = "bb";
        System.out.println(longestPalindrome(a));
    }

}


