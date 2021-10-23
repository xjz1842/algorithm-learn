package com.algorithms.leetcode.fivehundred;

public class Leetcode_492_ConstructRectangle {

    public static int[] constructRectangle(int area) {
        int sqrt = (int)Math.sqrt(area);

        while (sqrt > 0 ){
            if(area % sqrt == 0){
                break;
            }
            sqrt--;
        }
        return new int[]{area/sqrt,sqrt};
    }

    public static void main(String[] args) {
        int area = 4;
        for(int i : constructRectangle(area)){
            System.out.println(i);
        }
    }
}
