package com.enalix.algs4.unionfind;

/**
 * Created by enali on 5/7/15.
 * 加权的union-find算法
 * 对union-find算法进行加权,保证问题将小分量复制成大分量,只是小改进.
 */
public class WeightedQuickFindUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickFindUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    private void validate(int p) {
        int N = id.length;
        if (p<0 || p>=N)
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        int N = id.length;
        if (sz[pId] < sz[qId]) {
            for (int i = 0; i < N; i++)
                if (id[i] == pId) {
                    id[i] = qId;
                    sz[qId]++;
                }

        } else {
            for (int i=0; i<N; i++)
                if (id[i] == qId) {
                    id[i] = pId;
                    sz[pId]++;
                }
        }
    }
}
