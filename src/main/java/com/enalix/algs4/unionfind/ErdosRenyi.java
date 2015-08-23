package com.enalix.algs4.unionfind;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

/**
 * Created by enali on 5/7/15.
 */
public class ErdosRenyi {
    public static int count(int N) {
        int edges = 0;
        UF uf = new UF(N);
        while (uf.count() > 1) {
            int i = StdRandom.uniform(N);
            int j = StdRandom.uniform(N);
            if (j == i)
                j = StdRandom.uniform(N);

            //if (uf.connected(i,j)) continue;

            uf.union(i, j);
            edges++;
        }
        return edges;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int[] edges = new int[T];

        for (int t=0; t<T; t++)
            edges[t] = count(N);

        StdOut.println("1/2 N ln N = " + 0.5 * N * Math.log(N));
        StdOut.println("mean       = " + StdStats.mean(edges));
        StdOut.println("stddev     = " + StdStats.stddev(edges));
    }
}
