package com.enalix.algs4.unionfind;

/**
 * Created by enali on 5/7/15.
 * 压缩路径Quick-Union
 * 无需加权数组,节省空间,但比加权Quick-Union会多消耗时间(100万触点200万连接,多消耗2~3秒)
 */
public class QuickUnionPathCompressionUF {
    private int[] parent;
    private int count;

    public QuickUnionPathCompressionUF(int N) {
        parent = new int[N];
        count = N;
        for (int i=0; i<N; i++)
            parent[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 这里的路径压缩并不是严格意义上的全局意义上的路径压缩,只有连接对中的节点高度大于1时才会被压缩
     * 若连接对节点总是根节点,则树高度会越来越高
     * @param p 节点编号
     * @return 返回节点的根节点
     */
    public int find(int p) {
        validate(p);    //验证节点在0~N-1间
        int root = p;
        while (root != parent[root])    //查找p节点的根节点
            root = parent[root];
        if (p != root) {
            while (root != parent[p]) {     //若p节点的深度大于1则压缩路径
                int newp = p;   //保存变量
                parent[p] = root;
                p = parent[newp];   //递归压缩
            }
        }
        return root;
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

        parent[proot] = qroot;  //考虑到所有节点深度都为0或1,则无需加权数组,谁连接谁都一样
        count--;    //每连接一个减小一个连通分量
    }

    /**
     * 是的,最大高度并不是1,而是取决于连接,可能很大
     * @return
     */
    public int maxHeight() {
        int MAX = 0;
        int N = parent.length;
        for (int i=0; i<N; i++) {
            int height = 0;
            int p = i;
            while (p != parent[p]) {
                p = parent[p];
                height++;
            }
            if (height > MAX)
                MAX = height;
        }
        return MAX;
    }
}
