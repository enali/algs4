package com.enalix.algs4.unionfind;

/**
 * Created by enali on 5/7/15.
 * 加权Quick-Union算法
 */
public class UF {
    private int[] parent;
    private int[] sz;
    private int count;

    public UF(int N) {
        count = N;
        parent = new int[N];
        sz = new int[N];
        for (int i=0; i<N; i++) {
            parent[i] = i;
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
        while (p != parent[p]) p = parent[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) return;

        if (sz[i] < sz[j]) {
            parent[i] = j;
            sz[j] += sz[i];
        } else {
            parent[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    private void validate(int p) {
        int N = parent.length;
        if (p<0 || p>=N)
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
    }

}
