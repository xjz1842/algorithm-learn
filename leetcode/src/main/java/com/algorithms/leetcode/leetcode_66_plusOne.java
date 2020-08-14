package com.algorithms.leetcode;


public class leetcode_66_plusOne {

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{};
        }
        int index = digits.length - 1;
        int carry = 0;
        if ((digits[index] + 1) >= 10) {
            carry = 1;
            digits[index--] = 0;
        } else {
            digits[index] = digits[index] + 1;
        }
        while (index >= 0) {
            if ((digits[index] + carry) >= 10) {
                carry = 1;
                digits[index--] = 0;
            } else {
                digits[index] = digits[index] + carry;
                carry = 0;
                break;
            }
        }

        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1,
                    digits.length);
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 9, 9};
        System.out.println();

        for (int a : plusOne(arr)) {
            System.out.println(a);
        }
    }
}
