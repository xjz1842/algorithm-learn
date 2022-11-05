package com.algorithms.leetcode.threehundred;

public class leetcode_278_FirstBadVersion {

    /**
     * 二分搜索
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l < r){
            int mid = l + (r - l)/2;

            if(!isBadVersion(mid)){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    /**
     *  系统提供的方法，此方法为mock数据
     **/
    public static boolean isBadVersion(int mid){
        return true;
    }

}
