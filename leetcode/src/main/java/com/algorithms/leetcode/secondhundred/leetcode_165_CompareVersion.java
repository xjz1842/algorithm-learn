package com.algorithms.leetcode.secondhundred;

public class leetcode_165_CompareVersion {

    public static int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) {
            return 0;
        }
        if (version1 == null) {
            return -1;
        }
        if (version2 == null) {
            return 1;
        }
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");

        int len = version1Arr.length < version2Arr.length ? version1Arr.length : version2Arr.length;

        int i = 0;
        while (i < len) {
            if (version1Arr[i].equals(version2Arr[i])) {
                i++;
            } else {
                version1Arr[i] = extractZero(version1Arr[i]);
                version2Arr[i] = extractZero(version2Arr[i]);
                if (Integer.parseInt(version1Arr[i]) > Integer.parseInt(version2Arr[i])) {
                    return 1;
                } else if (Integer.valueOf(version1Arr[i]).equals(Integer.valueOf(version2Arr[i]))){
                    i++;
                } else {
                    return -1;
                }
            }
        }

        while (i < version1Arr.length) {
            if ("0".equals(version1Arr[i])) {
                i++;
            } else {
                break;
            }
        }
        while (i < version2Arr.length) {
            if ("0".equals(version2Arr[i])) {
                i++;
            } else {
                break;
            }
        }
        while (i < version1Arr.length) {
            if ("0".equals(extractZero(version1Arr[i]))) {
                i++;
            } else {
                break;
            }
        }
        while (i < version2Arr.length) {
            if ("0".equals(extractZero(version2Arr[i]))) {
                i++;
            } else {
                break;
            }
        }
        if (i < version1Arr.length) {
            return 1;
        } else if (i < version2Arr.length) {
            return -1;
        } else {
            return 0;
        }
    }

    private static String extractZero(String str) {
        String zero = "0";
        while (str.startsWith(zero) && str.length() > 1) {
            str = str.substring(1);
        }
        return str;
    }

    public static void main(String[] args) {
        String version1 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
        String version2 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";

        System.out.println(compareVersion(version1, version2));
    }
}
