package com.algorithms.interview.binarysearch;

public class BinarySearch {

    static boolean binarySearch(long[] A, long target) {
        //边界
        if (A == null || A.length == 0) {
            return false;
        }
        //初始区间是左开右闭的
        int l = 0;
        int r = A.length ;

        // 使用的是开闭原则来表示一个区间，所以当l < r的时候
        while (l < r) {
            int mid = l + ((r - l) >> 1);

            if (A[mid] == target) {
                return true;
            }
            if (A[mid] < target) {
                // 当中点比目标值小时，需要把左边的部分扔掉。即[l, m]
                // 这个区间扔掉，由于我们采用的是开闭原则，所以新的区间需要是
                // [mid + 1, r), 因引需要将l = mid + 1
                l = mid + 1;
            } else {
                // 当中点比目标值大时，需要把右边的部分扔掉，即[m, r)这个区间扔掉。
                // 那么新区间变成[l, mid)。由于我们使用的是开闭原则，
                // 只需要设置r = mid即可。
                r = mid;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        long[] arr = new long[]{3, 34, 55, 76, 100};
        int target = 76;
        System.out.println(binarySearch(arr, target));
    }

}
