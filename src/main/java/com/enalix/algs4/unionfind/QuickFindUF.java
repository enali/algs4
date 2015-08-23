package com.enalix.algs4.unionfind;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by enali on 5/7/15.
 * Quick-Find算法
 */
public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i=0; i<N; i++)
            id[i] = i;
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

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i=0; i<id.length; i++)
            if (id[i] == pId) id[i] = qId;

        count--;
    }

    private void validate(int p) {
        int N = id.length;
        if (p<0 || p>=N)
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
    }
}
