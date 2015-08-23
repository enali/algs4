package com.enalix.algs4.unionfind;

import java.util.Arrays;

/**
 * Created by enali on 5/7/15.
 */
public class WeightedQuickUnionByHeightUF {
    private int[] parent;
    private int[] height;
    private int count;

    public WeightedQuickUnionByHeightUF(int N) {
        parent = new int[N];
        height = new int[N];
        count = N;
        for (int i=0; i<N; i++) {
            parent[i] = i;
            height[i] = 0;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        validate(p);    //验证节点在0~N-1间
        while (p != parent[p])    //查找p节点的根节点
            p = parent[p];
        return p;
    }

    private void validate(int p) {
        int N = parent.length;
        if (p<0 || p>=N)
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N );
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);

        if (proot == qroot) return;

        if (height[proot] < height[qroot]) parent[proot] = qroot;
        else if (height[proot] > height[qroot]) parent[qroot] = proot;
        else {
            parent[proot] = qroot;  //考虑到所有节点深度都为0或1,则无需加权数组,谁连接谁都一样
            height[qroot]++;
        }
        count--;    //每连接一个减小一个连通分量
    }

}
