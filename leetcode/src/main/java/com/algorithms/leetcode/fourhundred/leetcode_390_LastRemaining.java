package com.algorithms.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_390_LastRemaining {

    /**
     *  暴力求解
     */
    public static int lastRemaining(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        List<Integer> list = new LinkedList<>();
        int start = 2;
        while (start <= n) {
            list.add(start);
            start += 2;
        }
        //循环次数
        int loopCount = 1;
        while (list.size() != 1) {
            loopCount++;
            List<Integer> temp = new ArrayList<>();
            //循环偶数次
            if((loopCount & 1) == 0){
                for (int i = list.size()-2; i >= 0; i -= 2) {
                    temp.add(0,list.get(i));
                }
            }else{
                //循环奇数次
                for (int i = 1; i < list.size(); i += 2) {
                    temp.add(list.get(i));
                }
            }
            list = temp;
        }
        return list.get(0);
    }

    /**
     *  1，2,3,4
     *  规律求解
     *  变更头节点，最后一个头节点为答案
     *  头结点变更的情况如下:
     *   1. 从左到右的方向
     *   2. 从右往左方向，并且 是奇数的情况
     */
    public static int lastRemaining1(int n) {
        boolean directFromLToR = true;
        int step = 1;
        int head = 1;
        while (n > 1){
            if(directFromLToR || (n & 1) == 1){
                head  += step;
            }
            step = step << 1;
            n = n >> 1;
            directFromLToR = !directFromLToR;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(4));
        System.out.println(lastRemaining1(4));
    }
}
