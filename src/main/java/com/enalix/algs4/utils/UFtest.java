package com.enalix.algs4.utils;

import com.enalix.algs4.unionfind.QuickFindUF;
import com.enalix.algs4.unionfind.QuickUnionPathCompressionUF;
import com.enalix.algs4.unionfind.WeightedQuickFindUF;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by enali on 5/7/15.
 */
public class UFtest {

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();

        int N = StdIn.readInt();

        //QuickUnionPathCompressionUF uf = new QuickUnionPathCompressionUF(N);
        //WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        //WeightedQuickUnionPathCompression uf = new WeightedQuickUnionPathCompression(N);
        //WeightedQuickUnionByHeightUF uf = new WeightedQuickUnionByHeightUF(N);
        //WeightedQuickFindUF uf = new WeightedQuickFindUF(N);
        QuickFindUF uf = new QuickFindUF(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");

        double time = sw.elapsedTime();
        StdOut.println("total spend " + time + " seconds");
        //StdOut.println("the max height of the tree is " + uf.maxHeight());
    }
}
