package com.enalix.algs4.utils;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by enali on 5/4/15.
 * 简单的计时类
 */
public class Stopwatch {
    private final long start;
    public Stopwatch() {
        start = System.currentTimeMillis();
    }
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i=0; i<N; i++)
            a[i] = StdRandom.uniform(-1000000, 1000000);
        Stopwatch sw = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = sw.elapsedTime();
        StdOut.println(cnt + " triples " + time + " seconds");
    }
}
