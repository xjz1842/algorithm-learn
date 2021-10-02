package com.algorithms.leetcode.fourhundred;

public class leetcode_371_GetSum {

    public static int getSum(int a, int b) {
        //需要进位
        int carry = a & b;
        //不需要进位
        int res = a ^ b;

        while(carry != 0){
            carry =  carry << 1;
            int nextCarry = res & carry;
            res = res ^ carry;
            carry = nextCarry;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = -12, b = -8;
        System.out.println(getSum(a,b));
    }
}
