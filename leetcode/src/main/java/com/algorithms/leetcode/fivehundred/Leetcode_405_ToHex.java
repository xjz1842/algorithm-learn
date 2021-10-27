package com.algorithms.leetcode.fivehundred;


public class Leetcode_405_ToHex {

    public static String toHex(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int partSize = 7;
        for(int i = partSize; i >= 0; i--){
           int low4Bits =  (num >> i * 4) & 0xF;
            if(stringBuilder.length() > 0 || low4Bits > 0){
                stringBuilder.append(low4Bits < 10 ? (char)('0' + low4Bits) : (char)(low4Bits - 10 + 'a'));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int num = 16;
        System.out.println(toHex(num));
    }

}
