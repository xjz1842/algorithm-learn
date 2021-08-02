package com.algorithms.interview.tree;

public class UnionFindSet {

    // 并查集数组
    int[] F = null;
    // 记录并查集中集合的个数
    int count = 0;

    // 记录集合中点的个数，比如要知道i所在集合的点有多少个: C[Find(i)]
    // 注意：这里不能直接使用C[i]
    // 因为只有根结点的统计才是正确的
    int[] cnt = null;

    // 并查集的初始化
    void init(int n) {
        F = new int[n];
        cnt = new int[n];

        for (int i = 0; i < n; i++) {
            F[i] = i;
            cnt[i] = 1;
        }
        count = n;
    }

    //查询
    int find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = find(F[x]);
        return F[x];
    }

    //合并
    void union(int x, int y) {
        int xparent = find(x);
        int yparent = find(y);
        // 将x所在集合，合并到y所在集合
        if (xparent != yparent) {
            F[xparent] = yparent;
            // y集合里面的个数要增加
            cnt[yparent] += cnt[xparent];
            count--;
        }
    }

    int size(int i){
        return cnt[find(i)];
    }
}
