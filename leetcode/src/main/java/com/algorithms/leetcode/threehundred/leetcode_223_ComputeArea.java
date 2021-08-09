package com.algorithms.leetcode.threehundred;

public class leetcode_223_ComputeArea {

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //宽度
        int width = Math.abs(ax2 - ax1);
        //长度
        int height = Math.abs(ay2 - ay1);

        int area1 = width * height;

        //宽度
        int width1 = Math.abs(bx2 - bx1);
        //长度
        int height1 = Math.abs(by2 - by1);

        int area2 = width1 * height1;


        // 线段的重叠
        int width2= Math.max(0,Math.min(ay2,by2) - Math.max(by1,ay1));
        int height2 = Math.max(0,Math.min(bx2,ax2) - Math.max(ax1,bx1));

        //重叠的长度和宽度，
        int union = width2 * height2;
        return area1 + area2 - union;
    }

    public static void main(String[] args) {
       int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1= -1, bx2 = 9, by2 = 2;
       System.out.println(computeArea( ax1,  ay1,  ax2,  ay2,  bx1,  by1,  bx2,  by2));
    }
}
