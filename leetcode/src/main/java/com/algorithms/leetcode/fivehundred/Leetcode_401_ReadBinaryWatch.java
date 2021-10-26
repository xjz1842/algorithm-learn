package com.algorithms.leetcode.fivehundred;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leetcode_401_ReadBinaryWatch {

    public static List<String> readBinaryWatch(int turnedOn) {

        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 1024; i++){
            //取高4w位
            int high = (i >> 6) & 15;
            //取低6位
            int low = i & 63;
            if(high < 12 && low < 60 &&
                    Integer.bitCount(i) == turnedOn){
                if(low <= 9){
                    ans.add(high + ":0"+ low);
                }else{
                    ans.add(high + ":"+ low);
                }
            }
        }
        return ans;
    }

    private static int getOneBits(int i) {
        int oneBitsCount = 0;
        for(int shif = 0; shif < 10; shif++){
            if(((i >> shif) & 1) == 1){
                oneBitsCount++;
            }
        }
        return oneBitsCount;
    }

    public static void main(String[] args)throws IOException {
        int turnedOn = 0;
        System.out.println(readBinaryWatch(turnedOn));;
    }

}
