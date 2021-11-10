package com.algorithms.leetcode.fourhundred;

import java.util.HashSet;
import java.util.Set;

public class leetcode_291_IsRectangleCover {

    public static boolean isRectangleCover(int[][] rectangles) {
        if(rectangles.length == 0){
            return false;
        }
        if (rectangles[0].length < 4) {
            return false;
        }
        // 完美矩形的左下角和右上角坐标
        int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;

        // 小矩形面积之和
        int areas = 0;
        // 记录所有顶点的出现情况
        Set<String> points = new HashSet<>();
        for (int[] rectangle: rectangles){
            int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
            // 更新坐标
            X1 = Math.min(x1, X1);
            Y1 = Math.min(y1, Y1);
            X2 = Math.max(x2, X2);
            Y2 = Math.max(y2, Y2);

            areas += Math.abs(x2 - x1) * Math.abs(y2 - y1);
            // 判断顶点是否出现过
            String[] point = {x1 + " " + y1, x2 + " " + y2, x1 + " " + y2, x2 + " " + y1};

            for(String p : point){
                // 没有出现过，添加；否则，移除
                if(points.contains(p)){
                    points.remove(p);
                }else{
                    points.add(p);
                }
            }
        }
        //2. 校验面积是否像扽
        // 面积是否相等
        int expected = (X2 - X1) * (Y2 -Y1);
        if(areas != expected){
            return false;
        }
        // 顶点情况是否满足
        if(points.size() != 4 || !points.contains(X1 + " " + Y1) || !points.contains(X2 + " " + Y2) || !points.contains(X1 + " " + Y2) || !points.contains(X2 + " " + Y1)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] rectangles = new int[][] {{1,1,3,3},{3,1,4,2},{1,3,2,4},{3,2,4,4}};
        System.out.println(isRectangleCover(rectangles));
    }
}
