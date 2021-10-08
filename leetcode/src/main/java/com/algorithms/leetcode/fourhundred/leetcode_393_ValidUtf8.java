package com.algorithms.leetcode.fourhundred;

public class leetcode_393_ValidUtf8 {


    public static boolean validUtf8(int[] data) {
        int c = 0;
        // 0xxxxxxx, 110xxxxx, 1110xxxx, 11110xxx
        for (int num : data) {
            if (c == 0) {
                if ((num >> 5) == 0b110) {
                    c = 1;
                } else if ((num >> 4) == 0b1110){
                    c = 2;
                }
                else if ((num >> 3) == 0b11110) {
                    c = 3;
                } else if ((num >> 7) == 1){
                    return false;
                }
            } else {
                if ((num >> 6) != 0b10){
                    return false;
                }
                --c;
            }
        }
        return c == 0;
    }


    public static void main(String[] args) {
        int[] data = new int[]{197, 130, 1};
        System.out.println(validUtf8(data));
        System.out.println(16 * 16);
    }

}
