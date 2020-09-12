package com.algorithms.leetcode.onehundred;

import java.util.ArrayList;
import java.util.List;

public class leetcode_93_RestoreIpAddresses {

    public static List<String> restoreIpAddresses(String s) {
        if (s == null) return new ArrayList<>();

        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = i + 1; j <= i + 3 && j < s.length(); j++) {
                for (int k = j + 1; k <= j + 3 && k < s.length(); k++) {
                    s1 = s.substring(0, i);
                    s2 = s.substring(i, j);
                    s3 = s.substring(j, k);
                    s4 = s.substring(k);
                    if (s4.length() == 0 || s4.length() > 3) {
                        continue;
                    }
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(s1).append(".").append(s2)
                                .append(".").append(s3).append(".").append(s4);
                        result.add(stringBuilder.toString());
                    }
                }
            }
        }
        return result;
    }

    public static boolean isValid(String str) {
        if (str.length() > 1 && str.startsWith("0")) {
            return false;
        }
        if (Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "25525511135";

        List<String> result = restoreIpAddresses(str);

        for (String s : result) {
            System.out.printf("%s\t", s);
        }
    }

}
