package com.algorithms.sword.to.offer;

/**
 * &#064;Author:  zxj
 * &#064;Date:  2022/11/11 10:41 AM
 */
public class Offer_15_HammingWeight {

    public static int hammingWeight(int n) {
        //init
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

}
