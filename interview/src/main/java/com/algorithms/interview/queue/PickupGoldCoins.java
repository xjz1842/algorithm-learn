package com.algorithms.interview.queue;

import java.util.ArrayDeque;

/**
 * 【题目】给定一个数组 A[]，每个位置 i 放置了金币 A[i]，小明从 A[0] 出发。当小明走到 A[i] 的时候，
 * 下一步他可以选择 A[i+1, i+k]（当然，不能超出数组边界）。
 * 每个位置一旦被选择，将会把那个位置的金币收走（如果为负数，就要交出金币）。请问，最多能收集多少金币？
 * <p>
 * 输入：[1,-1,-100,-1000,100,3], k = 2
 * <p>
 * 输出：4
 */
public class PickupGoldCoins {

    public static int maxResult(int[] A, int k) {
        if (A == null || A.length == 0 || k <= 0) {
            return 0;
        }
        int[] result = new int[A.length];
        //初始化数据
        result[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            int max = Integer.MIN_VALUE;
            if (i >= k) {
                for (int j = 0; j < k; j++) {
                    max = Math.max(max, result[j]);
                }
            } else {
                for (int j = 0; j < result.length; j++) {
                    max = Math.max(max, result[j]);
                }
            }
            result[i] = max + A[i];
        }
        return result[A.length - 1];
    }

    //基于队列
    public static int maxResult1(int[] A, int k) {
        if (A == null || A.length == 0 || k <= 0) {
            return 0;
        }
        final int N = A.length;
        //每个位置可以收集到的金币数目
        int[] result = new int[A.length];
        //单调队列，这里并不是严格递减
        ArrayDeque<Integer> Q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            //在取最大值之前，需要保证单调队列中都是有效值。
            //也就是都在区间里面的值
            //当要求get[i]的时候，
            //单调队列中应该是只能保存[i-k,i-1]这个范围
            if (i - k > 0) {
                if (!Q.isEmpty() && Q.getFirst() == result[i - k - 1]) {
                    Q.removeFirst();
                }
            }
        //从单调队列中取得较大值
            int old = Q.isEmpty()? 0 : Q.getFirst();
            result[i] = old + A[i];
            //入队的时候，采用单调队列入队
            while (!Q.isEmpty() && Q.getLast() < result[i]){
                Q.removeLast();
            }
            Q.add(result[i]);
        }
        return result[A.length - 1];
    }

    class Node {
        // 累计取得的金币!
        int sum = 0;
        // 在index = idx的时候
        // 取得的最大金币为sum
        int idx = 0;
        public Node(int s, int i) {
            sum = s;
            idx = i;
        }
    };

    /**
     * 那么是否还有别的出队方式？是否可以不通过元素值相等的方式进行出队？针对上述两个问题，我们一起来看一下具体如何处理。
     *
     * 入队：入队的时候，将值和下标一起入队。
     *
     * 出队：直接判断队首元素的下标，进而判断是否应该将队首元素出队。
     */
    public int maxResult2(int[] A, int k) {
        // 严格单调递减队列
        // 里面存放的是每个位置可以收集到的金币以及下标index
        ArrayDeque<Node> Q = new ArrayDeque<Node>();
        // 走到i位置时，最大的金币收益
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            // 出队！
            // 对于i而言，
            // [i-k, i-1]可以跳到A[i]
            // 最远i - (i - k) = k
            // 因此超出这个范围的，必须要出队
            while (!Q.isEmpty() && i - Q.getFirst().idx > k) {
                Q.removeFirst();
            }
            // 获得在位置i时的收益
            if (Q.isEmpty()) {
                ans = A[i];
            } else {
                ans = Q.getFirst().sum + A[i];
            }
            // 入队，当A[i]入队的时候，要把小于他的那些
            // 收益比他低，又比他旧的给踢除掉
            // 注意！这里使用的是严格的单调递减!
            while (!Q.isEmpty() && Q.getLast().sum <= ans) {
                Q.removeLast();
            }
            Q.addLast(new Node(ans, i));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, -1, -100, -1000, 100, 3};
        int k = 2;
        System.out.println(maxResult(A, k));
        System.out.println(maxResult1(A, k));
    }

}
