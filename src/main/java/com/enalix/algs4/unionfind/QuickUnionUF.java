package com.enalix.algs4.unionfind;

/**
 * Created by enali on 5/7/15.
 * Quick-Union算法
 */
public class QuickUnionUF {
    private int[] parent;
    private int count;

    public QuickUnionUF(int N) {
        count = N;
        parent = new int[N];
        for (int i=0; i<N; i++)
            parent[i] = i;
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
        int proot = find(p);
        int qroot = find(q);
        if (proot == qroot) return;
        parent[proot] = qroot;
        count--;
    }

    private void validate(int p) {
        int N = parent.length;
        if (p<0 || p>=N)
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
    }
}
