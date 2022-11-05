package com.algorithms.leetcode.fourhundred;


public class leetcode_365_CanMeasureWater {


    public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity){
            return false;
        }
        if(jug1Capacity == 0 || jug2Capacity == 0){
            return targetCapacity == 0 || (jug1Capacity+jug2Capacity)==targetCapacity;
        }
        if(jug1Capacity < jug2Capacity){
            int temp = jug1Capacity;
            jug1Capacity = jug2Capacity;
            jug2Capacity = temp;
        }
        return targetCapacity % (gcd(jug1Capacity,jug2Capacity)) == 0;
    }

    //求解公约数
    public static int gcd(int x,int y){
         int remainder = x % y;
         while(remainder != 0){
             x = y;
             y = remainder;
             remainder = x % y;
         }
         return y;
    }


    public static void main(String[] args) {
        int x = 34, y = 5, z = 6;
        System.out.println(canMeasureWater(x,y,z));
    }
}
