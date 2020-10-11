package com.algorithms.leetcode.onehundred;


public class leetcode_67_AddBinary {

    public static String addBinary(String a, String b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
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
        char[] newArr = new char[arrA.length > arrB.length ? arrA.length : arrB.length];
        int carry = 0;
        l = 0;
        while (l < arrA.length && l < arrB.length) {
            int res = arrA[l] - '0' + arrB[l] - '0' + carry;
            if (res >= 2) {
                carry = 1;
                newArr[l] = (char) (res - 2 + '0');
            } else {
                newArr[l] = (char) (res + '0');
                carry = 0;
            }
            l++;
        }
        while (l < arrA.length) {
            int res = arrA[l] - '0' + carry;
            if (res >= 2) {
                carry = 1;
                newArr[l] = (char) (res - 2 + '0');
            } else {
                newArr[l] = (char) (res + '0');
                carry = 0;
            }
            l++;
        }
        while (l < arrB.length) {
            int res = arrB[l] - '0' + carry;
            if (res >= 2) {
                carry = 1;
                newArr[l] = (char) (res - 2 + '0');
            } else {
                carry = 0;
                newArr[l] = (char) (res + '0');
            }
            l++;
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
        if (carry == 1) {
            return "1" + ans.toString();
        } else {
            return ans.toString();
        }
    }

    private static void swap(char[] arrA, int l, int r) {
        char temp = arrA[l];
        arrA[l] = arrA[r];
        arrA[r] = temp;
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
    }
}
