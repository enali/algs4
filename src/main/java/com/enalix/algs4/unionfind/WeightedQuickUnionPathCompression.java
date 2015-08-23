package com.enalix.algs4.unionfind;

/**
 * Created by enali on 5/7/15.
 */
public class WeightedQuickUnionPathCompression {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnionPathCompression(int N) {
        count = N;
        parent = new int[N];
        size = new int[N];
        for (int i=0; i<N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private void validate(int p) {
        int N = parent.length;
        if (p<0 || p>=N)
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
    }

    public int find(int p) {
        validate(p);
        int root = p;
        while (root != parent[root])
            root = parent[root];
        if (root != p)
            while (root != parent[p]) {
                int newp = p;
                parent[p] = root;
                p = newp;
            }
        return root;
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);

        if (proot == qroot) return;

        if (size[proot] < size[qroot]) {
            parent[proot] = qroot;
            size[qroot] += size[proot];
        } else {
            parent[qroot] = proot;
            size[proot] += size[qroot];
        }

        count--;
    }

}
