package com.algorithms.leetcode.onehundred;

public class leetcode_38_CountAndSay {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        char[] arr = str.toCharArray();
        int count = 1;
        int l = 0;
        StringBuilder ans = new StringBuilder();
        while (l < arr.length) {
            if (l == (arr.length - 1)) {
                ans.append(count).append(arr[l]);
            } else if (arr[l] == arr[l + 1]) {
                count++;
            } else {
                ans.append(count).append(arr[l]);
                count = 1;
            }
            l++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
