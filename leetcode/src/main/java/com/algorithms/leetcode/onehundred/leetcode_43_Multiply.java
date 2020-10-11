package com.algorithms.leetcode.onehundred;

public class leetcode_43_Multiply {

    public static String multiply(String num1, String num2) {
        if (num1 == null || num1 == null) {
            return null;
        }
        char[] arrA = num1.toCharArray();
        char[] arrB = num2.toCharArray();
        int l = 0;
        int r = arrA.length - 1;
        while (l < r) {
            swap(arrA, l, r);
            l++;
            r--;
        }
        l = 0;
        r = arrB.length - 1;
        while (l < r) {
            swap(arrB, l, r);
            l++;
            r--;
        }
        char[] newArr = new char[arrA.length + arrB.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = '0';
        }
        int carry = 0;
        for (int i = 0; i < arrA.length; i++) {
            for (int j = 0; j < arrB.length; j++) {
                int res = (arrA[i] - '0') * (arrB[j] - '0') +
                        (newArr[i + j] - '0') + carry;
                if (res >= 10) {
                    carry = res / 10;
                    newArr[i + j] = (char) (res % 10 + '0');
                } else {
                    newArr[i + j] = (char) (res + '0');
                    carry = 0;
                }
            }
            if (carry > 0) {
                newArr[i + arrB.length] = (char) ((newArr[i + arrB.length] - '0' + carry) + '0');
            }
            carry = 0;
        }
        l = 0;
        r = newArr.length - 1;
        while (l < r) {
            swap(newArr, l, r);
            l++;
            r--;
        }
        StringBuilder ans = new StringBuilder();
        for (char c : newArr) {
            ans.append(c);
        }
        String res = ans.toString();
        while (res.startsWith("0") && res.length() > 1) {
            res = res.substring(1);
        }
        return res;
    }

    private static void swap(char[] arrA, int l, int r) {
        char temp = arrA[l];
        arrA[l] = arrA[r];
        arrA[r] = temp;
    }

    public static void main(String[] args) {
        String nums1 = "999";
        String num2 = "999";
        System.out.println(multiply(nums1, num2));
    }
}
